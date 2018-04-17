package com.zyc.service.iservice;

import com.zyc.model.Example.UsertopaperhistoryExample;
import com.zyc.model.Example.UsertopapertempExample;
import com.zyc.model.Usertopaperhistory;
import com.zyc.model.Usertopapertemp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
public interface IUserToPaperTempService {
    List<Usertopapertemp> query(UsertopapertempExample usertopapertempExample);
    Integer insert(Usertopapertemp usertopapertemp);
    Integer delete(UsertopapertempExample usertopapertempExample);
    Integer update(Usertopapertemp usertopapertemp,UsertopapertempExample usertopapertempExample);
}
