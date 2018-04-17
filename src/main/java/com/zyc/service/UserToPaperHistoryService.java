package com.zyc.service;

import com.zyc.mapper.UsertopaperhistoryMapper;
import com.zyc.model.Example.UsertopaperhistoryExample;
import com.zyc.model.Usertopaperhistory;
import com.zyc.service.iservice.IUserToPaperHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by YuChen Zhang on 18/03/13.
 */
@Service
public class UserToPaperHistoryService implements IUserToPaperHistoryService {
    private static final Logger log = LogManager.getFormatterLogger(UserToPaperHistoryService.class);
    @Autowired
    UsertopaperhistoryMapper usertopaperhistoryMapper;
    @Override
    public List<Usertopaperhistory> query(UsertopaperhistoryExample usertopaperhistoryExample) {
        List result = usertopaperhistoryMapper.selectByExample(usertopaperhistoryExample);
        log.info("查询用户答题历史表记录"+result.size()+"条");
        return result;
    }

    @Override
    public Integer insert(Usertopaperhistory usertopaperhistory) {
        log.info("插入用户答题历史表记录 用户id"+usertopaperhistory.getUserid()+"试卷id"+usertopaperhistory.getPaperid());
        return usertopaperhistoryMapper.insert(usertopaperhistory);
    }

    @Override
    public Integer delete(UsertopaperhistoryExample usertopaperhistoryExample) {
        Integer result = usertopaperhistoryMapper.deleteByExample(usertopaperhistoryExample);
        log.info("删除用户答题历史表记录"+result+"条");
        return result;
    }

    @Override
    public Integer update(Usertopaperhistory usertopaperhistory, UsertopaperhistoryExample usertopaperhistoryExample) {
        Integer result = usertopaperhistoryMapper.updateByExampleSelective(usertopaperhistory,usertopaperhistoryExample);
        log.info("更新用户答题历史表记录"+result+"条");
        return result;
    }
}
