package com.kentrasoft.cms.service.impl;

import com.kentrasoft.base.dao.BaseDao;
import com.kentrasoft.base.service.impl.BaseServiceImpl;
import com.kentrasoft.cms.dao.DictDao;
import com.kentrasoft.cms.model.Dict;
import com.kentrasoft.cms.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：DictServiceImpl
 *
 * @author : zmk
 * @date : 2018-09-11
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    @Autowired
    private DictDao dictDao;

    @Override
    public BaseDao getModelDao() {
        return this.dictDao;
    }

    /**
     * 描述：查询所有可用菜单
     *
     * @return dicts
     */
    @Override
    public List<Dict> findAllNormal() {
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put("dictStatus",1);
        List<Dict> dicts = dictDao.queryByParams(queryParam);
        return dicts;
    }

    /**
     * 描述：组装字典树
     *
     * @param dicts
     * @return dicts
     */
    @Override
    public List<Dict> getDictTree(List<Dict> dicts) {
        //获取菜单
        Map<Long, Dict> dictMap = new HashMap<>();
        for (Dict dict : dicts) {
            dictMap.put(dict.getId(), dict);
        }

        // 组装树形菜单
        Dict root = null;
        for (Dict dict : dictMap.values()) {
            if (dict.getDictPid() == null || dict.getDictPid() == 0) {
                root = dict;
            } else {
                dictMap.get(dict.getDictPid()).addChildDict(dict);
            }
        }

        // 4.菜单排序
        root.sameLevelSort();
        return root.getChildDicts();
    }


    /**
     * 描述：根据Pid查找字典
     *
     * @param dicts 所有可用字典
     * @param pid
     * @return dicts
     */
    @Override
    public List<Dict> findByPid(Long pid, List<Dict> dicts) {
        List<Dict> newDict = new ArrayList<>();
        for (Dict dict : dicts) {
            if (dict.getDictPid().equals(pid)) {
                newDict.add(dict);
            }
        }
        return newDict;
    }

}
