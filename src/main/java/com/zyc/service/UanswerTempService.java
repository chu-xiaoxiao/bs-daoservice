package com.zyc.service;

import com.zyc.mapper.UanswertempMapper;
import com.zyc.model.Example.UanswertempExample;
import com.zyc.model.Uanswertemp;
import com.zyc.service.iservice.IUserAnswerTempService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@Service
public class UanswerTempService implements IUserAnswerTempService {
    private static final Logger log = LogManager.getFormatterLogger(UanswerTempService.class);
    @Autowired
    UanswertempMapper uanswertempMapper;

    @Override
    public List<Uanswertemp> query(UanswertempExample uanswertempExample) {
        List result = uanswertempMapper.selectByExample(uanswertempExample);
        log.info("查询用户答案临时表记录"+result.size()+"条");
        return result;
    }

    @Override
    public Integer insert(Uanswertemp uanswertemp) {
        log.info("插入用户答案临时表 用户"+uanswertemp.getUserid()+"试卷"+uanswertemp.getPaperid()+"试题"+uanswertemp.getQuestionid()+"答案"+uanswertemp.getUanswer());
        return uanswertempMapper.insert(uanswertemp);
    }

    @Override
    public Integer delete(UanswertempExample uanswertempExample) {
        Integer result = uanswertempMapper.deleteByExample(uanswertempExample);
        log.info("删除用户答案临时表"+result+"条记录");
        return result;
    }

    @Override
    public Integer update(Uanswertemp uanswertemp, UanswertempExample uanswertempExample) {
        Integer result = uanswertempMapper.updateByExampleSelective(uanswertemp,uanswertempExample);
        log.info("更新用户答案临时表"+result+"条记录");
        return result;
    }
}
