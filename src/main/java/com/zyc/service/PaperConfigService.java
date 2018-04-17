package com.zyc.service;

import com.zyc.mapper.PaperconfigMapper;
import com.zyc.model.Example.PaperconfigExample;
import com.zyc.model.Paperconfig;
import com.zyc.service.iservice.IPaperConfigeService;
import com.zyc.util.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by YuChen Zhang on 18/02/05.
 */
@Service
public class PaperConfigService implements IPaperConfigeService {
    private static final Logger log = LogManager.getFormatterLogger(PaperConfigService.class);
    @Autowired
    PaperconfigMapper paperconfigMapper;

    @Override
    public Paperconfig insertPaperConfig(Paperconfig paperconfig) {
        paperconfigMapper.insert(paperconfig);
        log.info("插入试卷配置表");
        return paperconfig;
    }

    @Override
    public Paperconfig queryPaperconfig(Integer id) {
        Paperconfig result = paperconfigMapper.selectByPrimaryKey(id);
        log.info("查询试卷配置表");
        return result;
    }

    @Override
    public Page<Paperconfig, PaperconfigExample> queryPaperconfig(Page<Paperconfig,PaperconfigExample> page) {
        page.getE().setOffset(page.getStart());
        page.getE().setLimit(page.getSize());
        page.setList(paperconfigMapper.selectByExample(page.getE()));
        page.countAllPage(paperconfigMapper.countByExample(page.getE()));
        log.info("查询试卷配置表"+page.getList().size()+"条记录");
        return page;
    }


    @Override
    public Integer deletePaperxonfig(Integer id) {
        log.info("删除试卷配置表 id:"+id);
        return paperconfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deletePaperconfig(PaperconfigExample paperconfigExample) {
        Integer result = paperconfigMapper.deleteByExample(paperconfigExample);
        log.info("删除试卷配置表"+result+"条记录");
        return result;
    }
}
