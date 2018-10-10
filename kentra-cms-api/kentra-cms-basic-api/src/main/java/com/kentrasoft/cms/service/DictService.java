package com.kentrasoft.cms.service;


import com.kentrasoft.cms.base.service.BaseService;
import com.kentrasoft.cms.model.Dict;

import java.util.List;

/**
 * 描述：DictService
 *
 * @author : zmk
 * @date : 2018-09-11
 */
public interface DictService extends BaseService<Dict> {

    public List<Dict> findAllNormal();

    public List<Dict> getDictTree(List<Dict> dicts);

    public List<Dict> findByPid(Long pid, List<Dict> dicts);

}