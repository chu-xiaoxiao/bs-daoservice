package com.zyc.service;

import com.zyc.mapper.*;
import com.zyc.model.Example.*;
import com.zyc.model.*;
import com.zyc.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuChen Zhang on 18/01/07.
 */
@Service
public class QuestionService {
    private static final Logger logger = LogManager.getFormatterLogger(Question.class);
    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    PqMapper pqMapper;

    @Autowired
    McqMapper mcqMapper;

    @Autowired
    ScqMapper scqMapper;

    @Autowired
    TfqMapper tfqMapper;

    @Autowired
    QuestionitopaperMapper questionitopaperMapper;

    public void instrQuestion(Pq pq){
        logger.info("插入编程题"+pq.getPqtext());
        Question question = new Question();
        question.setQuestiontype(QuestionType.PQ.getIndex());
        question.setSubjectid(pq.getSubjectid());
        questionMapper.insert(question);
        pq.setPqid(question.getQuestionid());
        pqMapper.insert(pq);
    }
    public void instrQuestion(Mcq mcq){
        logger.info("插入多选题"+mcq.getMcqtext());
        Question question = new Question();
        question.setQuestiontype(QuestionType.MCQ.getIndex());
        question.setSubjectid(mcq.getSubjectid());
        questionMapper.insert(question);
        mcq.setMcqid(question.getQuestionid());
        mcqMapper.insert(mcq);
    }
    public void instrQuestion(Scq scq){
        logger.info("插入单选题"+scq.getScqtext());
        Question question = new Question();
        question.setQuestiontype(QuestionType.SCQ.getIndex());
        question.setSubjectid(scq.getSubjectid());
        questionMapper.insert(question);
        scq.setScqid(question.getQuestionid());
        scqMapper.insert(scq);
    }
    public void instrQuestion(Tfq tfq){
        logger.info("插入判断题"+tfq.getTfqtext());
        Question question = new Question();
        question.setQuestiontype(QuestionType.TFQ.getIndex());
        question.setSubjectid(tfq.getSubjectid());
        questionMapper.insert(question);
        tfq.setTfqid(question.getQuestionid());
        tfqMapper.insert(tfq);
    }

    public Page queryQuestionMCQ(Page<Mcq,McqExample> page){
        page.getE().setOffset(page.getStart());
        page.getE().setLimit(page.getSize());
        page.setList(mcqMapper.selectByExample(page.getE()));
        page.countAllPage(mcqMapper.countByExample(page.getE()));
        logger.info("分页查询多选题"+page.getList().size()+"条记录");
        return page;
    }
    public List<Mcq> queryQuestionMCQ(McqExample mcqExample){
        List result =  mcqMapper.selectByExample(mcqExample);
        logger.info("查询多选题"+result.size()+"条记录");
        return result;
    }
    public Page queryQuestionPQ(Page<Pq,PqExample> page){
        page.getE().setOffset(page.getStart());
        page.getE().setLimit(page.getSize());
        page.setList(pqMapper.selectByExample(page.getE()));
        page.countAllPage(pqMapper.countByExample(page.getE()));
        logger.info("分页查询编程题"+page.getList().size()+"条记录");
        return page;
    }
    public List<Pq> queryQuestionPQ(PqExample pqExample){
        List result = pqMapper.selectByExample(pqExample);
        logger.info("查询编程题"+result.size()+"条记录");
        return result;
    }
    public Page queryQuestionSCQ(Page<Scq,ScqExample> page){
        page.getE().setOffset(page.getStart());
        page.getE().setLimit(page.getSize());
        page.setList(scqMapper.selectByExample(page.getE()));
        page.countAllPage(scqMapper.countByExample(page.getE()));
        logger.info("分页查询单选题"+page.getList().size()+"条记录");
        return page;
    }
    public List<Scq> queryQuestionSCQ(ScqExample scqExample){
        List result = scqMapper.selectByExample(scqExample);
        logger.info("查询单选题"+result+"条记录");
        return result;    }
    public Page queryQuestionTFQ(Page<Tfq,TfqExample> page){
        page.getE().setOffset(page.getStart());
        page.getE().setLimit(page.getSize());
        page.setList(tfqMapper.selectByExample(page.getE()));
        page.countAllPage(tfqMapper.countByExample(page.getE()));
        logger.info("分页查询判断题"+page.getList().size()+"条记录");
        return page;
    }
    public List<Tfq> queryQuestionTFQ(TfqExample tfqExample){
        List result = tfqMapper.selectByExample(tfqExample);
        logger.info("查询判断题"+result+"条记录");
        return result;
    }

    public Question queryQuestion(Integer id) throws CloneNotSupportedException {
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question!=null){
            Question temp = new Question();
            temp.setQuestionid(question.getQuestionid());
            temp.setQuestiontype(question.getQuestiontype());
            if(question.getQuestiontype().equals(QuestionType.PQ.getIndex())){
                Pq question1 = pqMapper.selectByPrimaryKey(id);
                question1.setQuestiontype(temp.getQuestiontype());
                question1.setQuestionid(temp.getQuestionid());
                question.setAnswer(question1.getPqanswer());
                logger.info("查询结果为编程题id:"+id);
            }
            if(question.getQuestiontype().equals(QuestionType.MCQ.getIndex())){
                question = mcqMapper.selectByPrimaryKey(id);
                question.setQuestiontype(temp.getQuestiontype());
                question.setQuestionid(temp.getQuestionid());
                logger.info("查询结果为多选题id:"+id);
            }
            if(question.getQuestiontype().equals(QuestionType.SCQ.getIndex())){
                question = scqMapper.selectByPrimaryKey(id);
                question.setQuestiontype(temp.getQuestiontype());
                question.setQuestionid(temp.getQuestionid());
                logger.info("查询结果为单选题id:"+id);
            }
            if(question.getQuestiontype().equals(QuestionType.TFQ.getIndex())){
                Tfq question1 = tfqMapper.selectByPrimaryKey(id);
                question1.setQuestiontype(temp.getQuestiontype());
                question1.setQuestionid(temp.getQuestionid());
                question.setAnswer(question1.getTfqanswer().toString());
                logger.info("查询结果为判断题id:"+id);
            }
        }
        return question;
    }


    public List<Question> queryQuestion(QuestionExample questionExample) throws CloneNotSupportedException {
        List result = questionMapper.selectByExample(questionExample);
        logger.info("查询问题"+result.size()+"条记录");
        return result;
    }
    public Integer deleteQuestion(McqExample mcqExample){
        List<Mcq> result = mcqMapper.selectByExample(mcqExample);
        List ids = new ArrayList();
        for(Question temp : result){
            ids.add(temp.getQuestionid());
        }
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andQuestionidIn(ids);
        Integer resultInt = questionMapper.deleteByExample(questionExample);
        logger.info("删除多选题"+resultInt+"条记录");
        return resultInt;
    }
    public Integer deleteQuestion(PqExample pqExample){
        List<Pq> result = pqMapper.selectByExample(pqExample);
        List ids = new ArrayList();
        for(Question temp : result){
            ids.add(temp.getQuestionid());
        }
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andQuestionidIn(ids);
        Integer resultInt = questionMapper.deleteByExample(questionExample);
        logger.info("删除编程题"+resultInt+"条记录");
        return resultInt;
    }

    public Integer deleteQuestion(ScqExample scqExample){
        List<Scq> result = scqMapper.selectByExample(scqExample);
        List ids = new ArrayList();
        for(Question temp : result){
            ids.add(temp.getQuestionid());
        }
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andQuestionidIn(ids);
        Integer resultInt = questionMapper.deleteByExample(questionExample);
        logger.info("删除编程题"+resultInt+"条记录");
        return resultInt;
    }
    public Integer deleteQuestion(TfqExample tfqExample){
        List<Tfq> result = tfqMapper.selectByExample(tfqExample);
        List ids = new ArrayList();
        for(Question temp : result){
            ids.add(temp.getQuestionid());
        }
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andQuestionidIn(ids);
        Integer resultInt = questionMapper.deleteByExample(questionExample);
        logger.info("删除编程题"+resultInt+"条记录");
        return resultInt;
    }
    public Integer deleteQuestion(Integer id){
        logger.info("删除问题id :"+id);
        return questionMapper.deleteByPrimaryKey(id);
    }

    public Integer modifyQuestion(Mcq mcq,McqExample mcqExample){
        Integer result = mcqMapper.updateByExampleSelective(mcq,mcqExample);
        logger.info("修改多团题"+result+"条记录");
        return result;
    }
    public Integer modifyQuestion(Pq pq,PqExample pqExample){
        Integer result =pqMapper.updateByExampleSelective(pq,pqExample);
        logger.info("修改编程题"+result+"条记录");
        return result;
    }
    public Integer modifyQuestion(Scq scq,ScqExample scqExample){
        Integer result =  scqMapper.updateByExampleSelective(scq,scqExample);
        logger.info("修改单选题题"+result+"条记录");
        return result;
    }
    public Integer modifyQuestion(Tfq tfq,TfqExample tfqExample){
        Integer result =tfqMapper.updateByExampleSelective(tfq,tfqExample);
        logger.info("修改单选题题"+result+"条记录");
        return result;
    }

    public void getQuestion(Paperconfig paperconfig){
        QuestionExample questionExample = new QuestionExample();
    }

}
