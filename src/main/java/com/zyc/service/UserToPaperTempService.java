package com.zyc.service;

import com.zyc.mapper.UsertopapertempMapper;
import com.zyc.model.Example.UsertopapertempExample;
import com.zyc.model.Usertopapertemp;
import com.zyc.service.iservice.IUserToPaperTempService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@Service
public class UserToPaperTempService implements IUserToPaperTempService {
    private static final Logger log = LogManager.getFormatterLogger(UserToPaperTempService.class);
    @Autowired
    UsertopapertempMapper usertopapertempMapper;

    @Override
    public List<Usertopapertemp> query(UsertopapertempExample usertopapertempExample) {
        List result = usertopapertempMapper.selectByExample(usertopapertempExample);
        log.info("查询用户答卷临时表"+result.size());
        return result;
    }

    @Override
    public Integer insert(Usertopapertemp usertopapertemp) {
        log.info("插入用户临时答题表 用户:"+usertopapertemp.getUserid()+"试卷："+usertopapertemp.getPaperid());
        return usertopapertempMapper.insert(usertopapertemp);
    }

    @Override
    public Integer delete(UsertopapertempExample usertopapertempExample) {
        Integer result =usertopapertempMapper.deleteByExample(usertopapertempExample);
        log.info("删除用户临时答题表记录"+result+"条");
        return result;
    }

    @Override
    public Integer update(Usertopapertemp usertopapertemp, UsertopapertempExample usertopapertempExample) {
        Integer result =usertopapertempMapper.updateByExample(usertopapertemp,usertopapertempExample);
        log.info("更新用户临时答题表记录"+result+"条");
        return result;
    }
}
