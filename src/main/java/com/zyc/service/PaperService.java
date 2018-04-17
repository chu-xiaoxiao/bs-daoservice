package com.zyc.service;

import com.zyc.mapper.PaperMapper;
import com.zyc.mapper.QuestionMapper;
import com.zyc.mapper.QuestionitopaperMapper;
import com.zyc.model.*;
import com.zyc.model.Example.PaperExample;
import com.zyc.model.Example.QuestionExample;
import com.zyc.service.iservice.IPaperService;
import com.zyc.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuChen Zhang on 18/01/23.
 */
@Service
public class PaperService implements IPaperService {
    private static Logger logger = LogManager.getFormatterLogger(PaperService.class);
    @Autowired
    PaperMapper paperMapper;

    @Autowired
    QuestionitopaperMapper questionitopaperMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Paper createPaper(Paperconfig paperconfig,Integer subject) {
        Paper paper = new Paper();
        paper.setPapertype(subject);
        paper.setCreateuser(1);
        paperMapper.insert(paper);
        QuestionExample questionExample = new QuestionExample();
        List<Question> result = new ArrayList<>();
        if (paperconfig.getMcqnum() != null) {
            result.addAll(questionMapper.selectQuestionRandom(QuestionType.MCQ.getIndex(), paperconfig.getMcqnum()));
            logger.info("抽取"+QuestionType.MCQ.getName()+"成功");
        }
        if(paperconfig.getScqnum()!=null){
            result.addAll(questionMapper.selectQuestionRandom(QuestionType.SCQ.getIndex(),paperconfig.getScqnum()));
            logger.info("抽取"+QuestionType.SCQ.getName()+"成功");
        }
        if(paperconfig.getTfqnum()!=null){
            result.addAll(questionMapper.selectQuestionRandom(QuestionType.TFQ.getIndex(),paperconfig.getTfqnum()));
            logger.info("抽取"+QuestionType.TFQ.getName()+"成功");
        }
        if(paperconfig.getPqnum()!=null){
            result.addAll(questionMapper.selectQuestionRandom(QuestionType.PQ.getIndex(),paperconfig.getPqnum()));
            logger.info("抽取"+QuestionType.PQ.getName()+"成功");
        }
        for (Question temp : result) {
            Questionitopaper questionitopaper = new Questionitopaper();
            questionitopaper.setPaperid(paper.getPaperid());
            questionitopaper.setQuestionid(temp.getQuestionid());
            //根据题目的类型设定题目的分值
            if(QuestionType.MCQ.getIndex().equals(temp.getQuestiontype())){
                questionitopaper.setQuestionvalue(paperconfig.getMcavalue());
            }
            else if(QuestionType.SCQ.getIndex().equals(temp.getQuestiontype())){
                questionitopaper.setQuestionvalue(paperconfig.getScqvalue());
            }
            else if(QuestionType.TFQ.getIndex().equals(temp.getQuestiontype())){
                questionitopaper.setQuestionvalue(paperconfig.getTfqvalue());
            }
            else if(QuestionType.PQ.getIndex().equals(temp.getQuestiontype())){
                questionitopaper.setQuestionvalue(paperconfig.getPqvalue());
            }
            questionitopaperMapper.insertSelective(questionitopaper);
            logger.debug("试卷题目关系入表试卷id"+paper.getPaperid()+"题目id"+temp.getQuestionid()+"题目类型"+temp.getQuestiontype()+"题目分值"+questionitopaper.getQuestionvalue());
        }
        return paper;
    }

    @Override
    public Paper queryPaper(Integer id) {
        logger.debug("查询条件id:"+id);
        return paperMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Paper, PaperExample> queryPaper(Page<Paper,PaperExample> result) {
        result.getE().setOffset(result.getStart());
        result.getE().setLimit(result.getSize());
        result.setList(paperMapper.selectByExample(result.getE()));
        result.countAllPage(paperMapper.countByExample(result.getE()));
        return result;
    }

    @Override
    public Integer deletePaper(Integer id) {
        logger.info("删除试卷"+id);
        return paperMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deletePaper(PaperExample paperExample) {
        Integer result = paperMapper.deleteByExample(paperExample);
        logger.info("删除试卷"+result+"条记录");
        return result;
    }
}
