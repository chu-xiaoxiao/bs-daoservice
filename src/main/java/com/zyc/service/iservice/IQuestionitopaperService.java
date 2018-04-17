package com.zyc.service.iservice;

import com.zyc.model.Example.QuestionitopaperExample;
import com.zyc.model.Questionitopaper;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/12.
 */
public interface IQuestionitopaperService {
    public List<Questionitopaper> query(QuestionitopaperExample questionitopaperExample);
}
