package com.zyc.service;

import com.zyc.mapper.FilterpathMapper;
import com.zyc.model.Example.FilterpathExample;
import com.zyc.model.Filterpath;
import com.zyc.service.iservice.IFilterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterPathServcie implements IFilterService {
    private static final Logger log = LogManager.getFormatterLogger(FilterPathServcie.class);
    @Autowired
    FilterpathMapper filterpathMapper;

    @Override
    public List<Filterpath> getFilterPath(FilterpathExample filterpathExample) {
        List<Filterpath> result = filterpathMapper.selectByExample(filterpathExample);
        log.info("查询权限过滤表"+result.size()+"结果");
        return result;
    }
}
