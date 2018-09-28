package com.kentrasoft.cms.service;


import com.kentrasoft.cms.entity.Dict;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

/**
 * 描述：数据字典service接口
 *
 * @author lihr
 * @date 2018/5/28 10:27
 */
public interface DictService {

    /**
     * 描述：条件分页查询
     *
     * @param page
     * @return
     */
    PageForm<Dict> getPageList(PageForm<Dict> page, Long pid, String dictName, String dictStatus);

    /**
     * 描述：新增数据字典
     *
     * @param dict
     */
    String add(Dict dict);

    /**
     * 描述：根据Id查找数据字典
     *
     * @param id
     * @return
     */
    Dict findById(Long id);

    /**
     * 描述：修改数据字典信息
     *
     * @param dict
     */
    void edit(Dict dict);

    /**
     * 描述：删除数据字典
     *
     * @param ids
     */
    String delete(String ids);

    /**
     * 通过ID获取其子级列表
     *
     * @param dictParentId
     * @return
     * @throws Exception
     */
    public List<Dict> listSubDictByParentId(Long dictParentId);

    /**
     * 获取所有数据并填充每条数据的子级列表(递归处理)
     *
     * @param dictParentId
     * @return
     * @throws Exception
     */
    public List<Dict> listAllDict(Long dictParentId);

    /**
     * 根据字典code查询数据字典
     *
     * @return
     * @throws Exception
     */
    public List<Dict> listDictByDictCode(String dictCode);

}
