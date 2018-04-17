package com.zyc.service.iservice;

import com.zyc.model.Example.FilterpathExample;
import com.zyc.model.Filterpath;

import java.util.List;

public interface IFilterService {
    List<Filterpath> getFilterPath(FilterpathExample filterpathExample);
}
