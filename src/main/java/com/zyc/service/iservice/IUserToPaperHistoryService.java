package com.zyc.service.iservice;

import com.zyc.model.Example.UsertopaperhistoryExample;
import com.zyc.model.Usertopaperhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
public interface IUserToPaperHistoryService {
    List<Usertopaperhistory> query(UsertopaperhistoryExample usertopaperhistoryExample);
    Integer insert(Usertopaperhistory usertopaperhistory);
    Integer delete(UsertopaperhistoryExample usertopaperhistoryExample);
    Integer update(Usertopaperhistory usertopaperhistory,UsertopaperhistoryExample usertopaperhistoryExample);
}
