package com.zyc.service;

import com.alibaba.fastjson.JSON;
import com.zyc.mapper.SubjectMapper;
import com.zyc.model.Example.SubjectExample;
import com.zyc.model.Subject;
import com.zyc.service.iservice.ISubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/11.
 */
@Service
public class SubjecService implements ISubjectService {
    private static final Logger log = LogManager.getFormatterLogger(SubjecService.class);
    @Autowired
    SubjectMapper subjectMapper;


    @Override
    public List<Subject> querySubject(SubjectExample subjectExample) {
        List<Subject> result = subjectMapper.selectByExample(subjectExample);
        log.info("查询学科"+result.size()+"条记录");
        return result;
    }

    @Override
    public Subject querySubject(Integer id) {
        Subject subject = subjectMapper.selectByPrimaryKey(id);
        log.info("按主键查询结果"+ JSON.toJSONString(subject));
        return subject;
    }

    @Override
    public Subject insertSubject(Subject subject) {
        log.info("插入",JSON.toJSONString(subject)+"成功");
        subjectMapper.insert(subject);
        return subject;
    }

    @Override
    public Integer deleteSubject(SubjectExample subjectExample) {
        Integer result = subjectMapper.deleteByExample(subjectExample);
        log.info("删除"+result+"条学科记录");
        return result;
    }

    @Override
    public Integer deleteSubject(Integer id) {
        Integer result = subjectMapper.deleteByPrimaryKey(id);
        log.info("删除"+result+"条学科记录");
        return result;
    }

    @Override
    public Integer modifySubject(Subject subject, SubjectExample subjectExample) {
        Integer result = subjectMapper.updateByExampleSelective(subject,subjectExample);
        log.info("更新"+result+"条学科记录");
        return result;
    }
}
