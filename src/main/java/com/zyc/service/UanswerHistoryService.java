package com.zyc.service;

import com.zyc.mapper.UanswerhistoryMapper;
import com.zyc.model.Example.UanswerhistoryExample;
import com.zyc.model.Uanswerhistory;
import com.zyc.service.iservice.IUserAnswerHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@Service
public class UanswerHistoryService implements IUserAnswerHistoryService {
    private static final Logger log = LogManager.getFormatterLogger(UanswerHistoryService.class);
    @Autowired
    UanswerhistoryMapper uanswerHistoryMapper;

    @Override
    public List<Uanswerhistory> query(UanswerhistoryExample uanswerhistoryExample) {
        List result = uanswerHistoryMapper.selectByExample(uanswerhistoryExample);
        log.info("查询用户答历史表记录"+result.size()+"条");
        return result;
    }

    @Override
    public Integer insert(Uanswerhistory uanswerhistory) {
        log.info("插入用户答案临时表 用户"+uanswerhistory.getUserid()+"试卷"+uanswerhistory.getPaperid()+"试题"+uanswerhistory.getQuestionid()+"答案"+uanswerhistory.getUanswer());
        return uanswerHistoryMapper.insert(uanswerhistory);
    }

    @Override
    public Integer delete(UanswerhistoryExample uanswerhistoryExample) {
        Integer result = uanswerHistoryMapper.deleteByExample(uanswerhistoryExample);
        log.info("删除用户答案临时表"+result+"条记录");
        return result;
    }

    @Override
    public Integer update(Uanswerhistory uanswerhistory, UanswerhistoryExample uanswerhistoryExample) {
        Integer result = uanswerHistoryMapper.updateByExampleSelective(uanswerhistory,uanswerhistoryExample);
        log.info("更新用户答案临时表"+result+"条记录");
        return result;
    }
}
