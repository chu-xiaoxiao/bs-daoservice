package com.zyc.service.iservice;

import com.zyc.model.Example.PaperconfigExample;
import com.zyc.model.Paperconfig;
import com.zyc.util.Page;


/**
 * Created by YuChen Zhang on 18/02/05.
 */
public interface IPaperConfigeService {
    Paperconfig insertPaperConfig(Paperconfig paperconfig);
    Paperconfig queryPaperconfig(Integer id);
    Page queryPaperconfig(Page<Paperconfig,PaperconfigExample> page);
    Integer deletePaperxonfig(Integer id);
    Integer deletePaperconfig(PaperconfigExample paperconfigExample);
}
