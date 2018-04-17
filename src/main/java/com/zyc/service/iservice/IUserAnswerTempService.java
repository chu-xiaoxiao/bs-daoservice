package com.zyc.service.iservice;

import com.zyc.model.Example.UanswertempExample;
import com.zyc.model.Uanswertemp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@Service
public interface IUserAnswerTempService {
    List<Uanswertemp> query(UanswertempExample uanswertempExample);
    Integer insert(Uanswertemp uanswertemp);
    Integer delete(UanswertempExample uanswertempExample);
    Integer update(Uanswertemp uanswertemp,UanswertempExample uanswertempExample);
}
