package com.zyc.controller;

import ch.qos.logback.core.spi.ScanException;
import com.zyc.model.*;
import com.zyc.model.Example.*;
import com.zyc.service.QuestionService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import com.zyc.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/01/07.
 */
@RestController
@RequestMapping("/question")
public class QuestionController {
    private static final Logger LOGGER = LogManager.getFormatterLogger(QuestionController.class);
    @Autowired
    QuestionService questionService;


    @RequestMapping(value = "insertMCQ",method = RequestMethod.POST)
    public String insert(@RequestBody Mcq mcq){
        questionService.instrQuestion(mcq);
        LOGGER.info("插入问题成功");
        return JSONResult.fillResultString("插入问题成功",mcq);
    }
    @RequestMapping(value = "insertPQ",method = RequestMethod.POST)
    public String insert(@RequestBody Pq pq){
        questionService.instrQuestion(pq);
        LOGGER.info("插入问题成功");
        return JSONResult.fillResultString("插入问题成功",pq);
    }
    @RequestMapping(value = "insertSCQ",method = RequestMethod.POST)
    public String insert(@RequestBody Scq scq){
        questionService.instrQuestion(scq);
        LOGGER.info("插入问题成功");
        return JSONResult.fillResultString("插入问题成功",scq);
    }
    @RequestMapping(value = "insertTFQ",method = RequestMethod.POST)
    public String insert(@RequestBody Tfq tfq){
        questionService.instrQuestion(tfq);
        LOGGER.info("插入问题成功");
        return JSONResult.fillResultString("插入问题成功",tfq);
    }
    @RequestMapping(value = "queryQuestion",method = RequestMethod.POST)
    public String queryQuestion (@RequestBody QuestionExample questionExample) throws CloneNotSupportedException {
        List<Question> result = questionService.queryQuestion(questionExample);
        LOGGER.info("查询问题"+ result.size());
        return JSONResult.fillResultString("查询成功",result);
    }
    @RequestMapping(value = "queryQuestion/{id}",method = RequestMethod.POST)
    public String queryQuestion (@PathVariable Integer id) throws CloneNotSupportedException {
        Question question = questionService.queryQuestion(id);
        LOGGER.info("查询问题"+question.toString());
        return JSONResult.fillResultString("查询问题成功",question);
    }
    @RequestMapping(value = "queryMCQ",method = RequestMethod.POST)
    public String queryMCQ(@RequestBody McqExample mcqExample){
        List result = questionService.queryQuestionMCQ(mcqExample);
        LOGGER.info("查询多选"+result.size()+"个结果");
        return JSONResult.fillResultString("查询多选题成功",result);
    }
    @RequestMapping(value = "queryPq",method = RequestMethod.POST)
    public String queryPQ(@RequestBody PqExample pqExample){
        List result = questionService.queryQuestionPQ(pqExample);
        LOGGER.info("查询编程题"+result.size()+"个结果");
        return JSONResult.fillResultString("查询变成题成功",result);
    }
    @RequestMapping(value = "querySCQ",method = RequestMethod.POST)
    public String querySCQ(@RequestBody ScqExample scqExample){
        List result = questionService.queryQuestionSCQ(scqExample);
        LOGGER.info("查询单选"+result.size()+"个结果");
        return JSONResult.fillResultString("查询单选题成功",result);
    }
    @RequestMapping(value = "queryTFQ",method = RequestMethod.POST)
    public String queryTFQ(@RequestBody TfqExample tfqExample){
        List result = questionService.queryQuestionTFQ(tfqExample);
        LOGGER.info("查询判断"+result.size()+"个结果");
        return JSONResult.fillResultString("查询判断题成功",result);
    }
    @RequestMapping(value = "queryMCQPage",method = RequestMethod.POST)
    public String queryMCQ(@RequestBody Page<Mcq,McqExample> page){
        Page result = questionService.queryQuestionMCQ(page);
        LOGGER.info("查询多选"+result.getList().size()+"个结果");
        return JSONResult.fillResultString("查询多选题成功",result);
    }
    @RequestMapping(value = "queryPqPage",method = RequestMethod.POST)
    public String queryPQ(@RequestBody Page<Pq,PqExample> page){
        Page result = questionService.queryQuestionPQ(page);
        LOGGER.info("查询编程题"+result.getList().size()+"个结果");
        return JSONResult.fillResultString("查询编程题成功",result);
    }
    @RequestMapping(value = "querySCQPage",method = RequestMethod.POST)
    public String querySCQ(@RequestBody Page<Scq,ScqExample> page) throws Exception {
        Page result = questionService.queryQuestionSCQ(page);
        LOGGER.info("查询单选题"+result.getList().size()+"个结果");
        return JSONResult.fillResultString("查询单选题成功",result);
    }
    @RequestMapping(value = "queryTFQPage",method = RequestMethod.POST)
    public String queryTFQ(@RequestBody Page<Tfq,TfqExample> page){
        Page result = questionService.queryQuestionTFQ(page);
        LOGGER.info("查询判断题题"+result.getList().size()+"个结果");
        return JSONResult.fillResultString("查询判断题成功",result);
    }
    @RequestMapping(value = "deleteQuestion",method = RequestMethod.POST)
    public String delteQuestion(@RequestBody Integer id){
        return JSONResult.fillResultString("删除问题成功[id = "+id+"]",questionService.deleteQuestion(id));
    }

    @RequestMapping(value = "deleteMCQ",method = RequestMethod.POST)
    public String deleteMCQ(@RequestBody McqExample mcqExample){
        LOGGER.info("删除多选成功");
        return JSONResult.fillResultString("删除多选成功",questionService.deleteQuestion(mcqExample));
    }
    @RequestMapping(value = "deletePq",method = RequestMethod.POST)
    public String deletePQ(@RequestBody PqExample pqExample){
        LOGGER.info("删除编程题成功");
        return JSONResult.fillResultString("修改编程题成功",questionService.deleteQuestion(pqExample));
    }
    @RequestMapping(value = "deleteSCQ",method = RequestMethod.POST)
    public String deleteSCQ(@RequestBody ScqExample scqExample){
        LOGGER.info("删除单选成功");
        return JSONResult.fillResultString("修改单选成功",questionService.deleteQuestion(scqExample));
    }
    @RequestMapping(value = "deleteTFQ",method = RequestMethod.POST)
    public String deleteTFQ(@RequestBody TfqExample tfqExample){
        LOGGER.info("删除判断题成功");
        return JSONResult.fillResultString("修修改判断题成功",questionService.deleteQuestion(tfqExample));
    }

    @RequestMapping(value = "modifyMCQ",method = RequestMethod.POST)
    public String modifyMCQ(@RequestBody Map<String,Object> modifyResult) throws Exception {
        Mcq mcq = MapUtil.map2bean((Map<String, Object>) modifyResult.get("mcq"),Mcq.class);
        McqExample mcqExample = MapUtil.map2bean((Map<String, Object>) modifyResult.get("mcqExample"),McqExample.class);
        LOGGER.info("修改多选成功");
        return JSONResult.fillResultString("修改多选成功",questionService.modifyQuestion(mcq,mcqExample));
    }
    @RequestMapping(value = "modifyPq",method = RequestMethod.POST)
    public String modifyPQ(@RequestBody Map<String,Object> modifyResult) throws Exception {
        Pq pq = MapUtil.map2bean((Map<String, Object>) modifyResult.get("pq"),Pq.class);
        PqExample pqExample = MapUtil.map2bean((Map<String, Object>) modifyResult.get("pqExample"),PqExample.class);
        LOGGER.info("修改编程题成功");
        return JSONResult.fillResultString("修改编程题成功",questionService.modifyQuestion(pq,pqExample));
    }
    @RequestMapping(value = "modifySCQ",method = RequestMethod.POST)
    public String modifySCQ(@RequestBody Map<String,Object> modifyResult) throws Exception {
        Scq scq = MapUtil.map2bean((Map<String, Object>) modifyResult.get("scq"),Scq.class);
        ScqExample scqExample = MapUtil.map2bean((Map<String, Object>) modifyResult.get("scqExample"),ScqExample.class);
        LOGGER.info("修改单选成功");
        return JSONResult.fillResultString("修改单选题成功",questionService.modifyQuestion(scq,scqExample));
    }
    @RequestMapping(value = "modifyTFQ",method = RequestMethod.POST)
    public String modifyTFQ(@RequestBody Map<String,Object> modifyResult) throws Exception {
        Tfq tfq = MapUtil.map2bean((Map<String, Object>) modifyResult.get("tfq"),Tfq.class);
        TfqExample tfqExample = MapUtil.map2bean((Map<String, Object>) modifyResult.get("tfqExample"),TfqExample.class);
        LOGGER.info("修改判断题成功");
        return JSONResult.fillResultString("修改判断题成功",questionService.modifyQuestion(tfq,tfqExample));
    }
}
