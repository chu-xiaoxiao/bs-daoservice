package com.zyc.service.iservice;

import com.zyc.model.Paper;
import com.zyc.model.Example.PaperExample;
import com.zyc.model.Paperconfig;
import com.zyc.util.Page;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/01/23.
 */
public interface IPaperService {
    Paper createPaper(Paperconfig paperconfig,Integer subject);
    Paper queryPaper(Integer id);
    Page queryPaper(Page<Paper,PaperExample> result);
    Integer deletePaper(Integer id);
    Integer deletePaper(PaperExample paperExample);
}
