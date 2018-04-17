package com.zyc.controller;

import com.zyc.model.Example.UanswerhistoryExample;
import com.zyc.model.*;
import com.zyc.service.PaperConfigService;
import com.zyc.service.QuestionService;
import com.zyc.service.UserToPaperHistoryService;
import com.zyc.service.iservice.IUserAnswerHistoryService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/14.
 */
@RestController
@RequestMapping("uAnserHistoryController")
public class UAnserHistoryController {
    private static final Logger log = LogManager.getFormatterLogger(UAnserHistoryController.class);
    @Autowired
    IUserAnswerHistoryService userAnswerHistoryService;

    @Autowired
    PaperConfigService paperConfigService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserToPaperHistoryService userToPaperHistoryService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String query(@RequestBody UanswerhistoryExample uanswerhistoryExample){
        return JSONResult.fillResultString("查询用户答案历史表成功",userAnswerHistoryService.query(uanswerhistoryExample));
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@RequestBody Uanswerhistory uanswerhistory){
        return JSONResult.fillResultString("插入用户答案历史表成功",userAnswerHistoryService.insert(uanswerhistory));
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(UanswerhistoryExample uanswerhistoryExample){
        return JSONResult.fillResultString("删除用户答案历史表成功",userAnswerHistoryService.delete(uanswerhistoryExample));
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@RequestBody Map<String,Object> map) throws Exception {
        Uanswerhistory uanswerhistory = MapUtil.map2bean((Map<String, Object>) map.get("uanswerhistory"),Uanswerhistory.class);
        UanswerhistoryExample uanswerhistoryExample = MapUtil.map2bean((Map<String, Object>) map.get("uanswerhistoryExample"),UanswerhistoryExample.class);
        return JSONResult.fillResultString("更新用户答案历史表成功",userAnswerHistoryService.update(uanswerhistory,uanswerhistoryExample));
    }

    @RequestMapping(value = "answer",method = RequestMethod.POST)
    public String score(@RequestBody Uanswerhistory uanswerhistory) throws CloneNotSupportedException {
        Double score = 0.0;
        UanswerhistoryExample uanswerhistoryExample = new UanswerhistoryExample();
        uanswerhistoryExample.createCriteria().andUseridEqualTo(uanswerhistory.getUserid()).andPaperidEqualTo(uanswerhistory.getPaperid());
        //获取考生答题结果
        List<Uanswerhistory> result = userAnswerHistoryService.query(uanswerhistoryExample);
        //获取试卷参数
        Paperconfig paperconfig = paperConfigService.queryPaperconfig(uanswerhistory.getPaperid());

        //比对题目
        List<Integer>questionid = new ArrayList<>();
        for(Uanswerhistory temp : result){
            Question question = questionService.queryQuestion(temp.getQuestionid());
            if(question.getAnswer().equals(temp.getUanswer())){
                if(QuestionType.SCQ.getIndex()==question.getQuestiontype()){
                    score+=paperconfig.getScqvalue();
                }
                if(QuestionType.MCQ.getIndex()==question.getQuestiontype()){
                    score+=paperconfig.getMcavalue();
                }
                if(QuestionType.TFQ.getIndex()==question.getQuestiontype()){
                    score+=paperconfig.getTfqvalue();
                }
                if(QuestionType.PQ.getIndex()==question.getQuestiontype()){
                    score+=paperconfig.getPqvalue();
                }
                temp.setResult(true);
                uanswerhistoryExample = new UanswerhistoryExample();
                uanswerhistoryExample.createCriteria().andDoansweridEqualTo(temp.getDoanswerid());
                userAnswerHistoryService.update(temp,uanswerhistoryExample);
            }
        }
        //得分入表
        Usertopaperhistory usertopaperhistory = new Usertopaperhistory();
        usertopaperhistory.setPaperid(uanswerhistory.getPaperid());
        usertopaperhistory.setUserid(uanswerhistory.getUserid());
        usertopaperhistory.setValue(score);
        userToPaperHistoryService.insert(usertopaperhistory);
        return JSONResult.fillResultString("计算用户分数成功",score);
    }
}
