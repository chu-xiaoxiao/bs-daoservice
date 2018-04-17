package com.zyc.service;

import com.zyc.mapper.QuestionitopaperMapper;
import com.zyc.model.Example.QuestionitopaperExample;
import com.zyc.model.Questionitopaper;
import com.zyc.service.iservice.IQuestionitopaperService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/12.
 */
@Service
public class QuestionitopaperService implements IQuestionitopaperService {
    private static final Logger log = LogManager.getFormatterLogger(QuestionitopaperService.class);
    @Autowired
    QuestionitopaperMapper questionitopaperMapper;
    @Override
    public List<Questionitopaper> query(QuestionitopaperExample questionitopaperExample) {
        List result =  questionitopaperMapper.selectByExample(questionitopaperExample);
        log.info("查询试卷试题对应表"+result.size()+"条记录");
        return result;
    }
}
