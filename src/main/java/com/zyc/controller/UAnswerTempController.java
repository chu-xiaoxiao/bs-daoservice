package com.zyc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyc.model.Example.UanswertempExample;
import com.zyc.model.Uanswerhistory;
import com.zyc.model.Uanswertemp;
import com.zyc.service.iservice.IUserAnswerHistoryService;
import com.zyc.service.iservice.IUserAnswerTempService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/14.
 */
@RestController
@RequestMapping("uAnserTempController")
public class UAnswerTempController {
    private static final Logger log = LogManager.getFormatterLogger(UAnswerTempController.class);
    @Autowired
    IUserAnswerTempService userAnswerTempService;

    @Autowired
    IUserAnswerHistoryService userAnswerHistoryService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String query(@RequestBody UanswertempExample uanswertempExample){
        List result = userAnswerTempService.query(uanswertempExample);
        log.info("查询用户答案临时表"+result.size()+"条记录");
        return JSONResult.fillResultString("查询用户答案临时表成功",result);
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@RequestBody Uanswertemp uanswertemp) {
        Integer end;
        UanswertempExample uanswertempExample = new UanswertempExample();
        uanswertempExample.createCriteria().andUseridEqualTo(uanswertemp.getUserid()).andPaperidEqualTo(uanswertemp.getPaperid()).andQuestionidEqualTo(uanswertemp.getQuestionid());
        List result = userAnswerTempService.query(uanswertempExample);
        if(result.size()>0){
            log.info("当前记录已存在由插入变为更新");
            end = userAnswerTempService.update(uanswertemp,uanswertempExample);
        }else{
            end = userAnswerTempService.insert(uanswertemp);
        }
        log.info("变更"+end+"条记录");
        return JSONResult.fillResultString("用户答案临时表变更成功",end);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(UanswertempExample uanswertempExample){
        return JSONResult.fillResultString("删除用户答案临时表成功",userAnswerTempService.delete(uanswertempExample));
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@RequestBody Map<String,Object> map) throws Exception {
        Uanswertemp uanswertemp = MapUtil.map2bean((Map<String, Object>) map.get("uanswertemp"),Uanswertemp.class);
        UanswertempExample uanswertempExample = MapUtil.map2bean((Map<String, Object>) map.get("uanswertempExample"),UanswertempExample.class);
        return JSONResult.fillResultString("用户答案临时表更新成功");
    }
    @RequestMapping("toHistory")
    public String toHistory(@RequestBody Uanswertemp uanswertemp){
        UanswertempExample uanswertempExample = new UanswertempExample();
        uanswertempExample.createCriteria().andPaperidEqualTo(uanswertemp.getPaperid()).andUseridEqualTo(uanswertemp.getUserid());
        List<Uanswertemp> temp = userAnswerTempService.query(uanswertempExample);
        for(Uanswertemp j : temp){
            Uanswerhistory uanswerhistory = new Uanswerhistory();
            uanswerhistory.setUserid(j.getUserid());
            uanswerhistory.setPaperid(j.getPaperid());
            uanswerhistory.setQuestionid(j.getQuestionid());
            uanswerhistory.setUanswer(j.getUanswer());
            userAnswerHistoryService.insert(uanswerhistory);
        }
        Integer result = userAnswerTempService.delete(uanswertempExample);
        return JSONResult.fillResultString("用户答案临时表落历史表成功",result);
    }
}
