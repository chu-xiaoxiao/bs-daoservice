package com.zyc.service.iservice;

import com.zyc.model.Example.UanswerhistoryExample;
import com.zyc.model.Uanswerhistory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@Service
public interface IUserAnswerHistoryService {
    List<Uanswerhistory> query(UanswerhistoryExample uanswerhistoryExample);
    Integer insert(Uanswerhistory uanswerhistory);
    Integer delete(UanswerhistoryExample uanswerhistoryExample) ;
    Integer update(Uanswerhistory uanswerhistory, UanswerhistoryExample uanswerhistoryExample);
}
