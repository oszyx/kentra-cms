package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.DictMapper;
import com.kentrasoft.cms.entity.Dict;
import com.kentrasoft.cms.entity.DictExample;
import com.kentrasoft.cms.service.DictService;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：数据字典service实现
 *
 * @author lihr
 * @date 2018/5/28 10:25
 */
@Service
@Transactional
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    /**
     * 描述：条件分页查询
     *
     * @param page
     * @return
     */
    @Override
    public PageForm<Dict> getPageList(PageForm<Dict> page, Long pid, String dictName, String dictStatus) {

        DictExample dictExample = new DictExample();
        DictExample.Criteria crit = dictExample.createCriteria();
        //条件查询
        crit.andDictParentIdEqualTo(pid.toString());
        if (dictName != null && dictName != "") {
            crit.andDictNameLike("%" + dictName + "%");
        }
        if (dictStatus != null && dictStatus != "") {
        	crit.andDictStatusEqualTo(dictStatus);
        }
        //查询所有的数据数量
        long dictCount = dictMapper.countByExample(dictExample);

        //分页查询所有的数据
        dictExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        dictExample.setLimitEnd(page.getLimit());

        List<Dict> dicts = dictMapper.selectByExample(dictExample);

        //回写内容
        page.setCount((int) dictCount);
        page.setData(dicts);

        return page;
    }

    /**
     * 描述：新增数据字典
     *
     * @param dict
     */
    @Override
    public String add(Dict dict) {
        dict.setCreator("1");
        dict.setCreateDate(new Date());
        dict.setStatus(true);

        List<Dict> dictList = dictMapper.listDictByDictCode(dict.getDictCode(),"");

        if (dictList.size() > 0) {
            return "字典编号已存在";
        }

        dictMapper.insertSelective(dict);

        return "";
    }

    /**
     * 描述：根据Id查找数据字典
     *
     * @param id
     * @return
     */
    @Override
    public Dict findById(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    /**
     * 描述：修改数据字典信息
     *
     * @param dict
     */
    @Override
    public void edit(Dict dict) {
        dict.setUpdator("1");
        dict.setUpdateDate(new Date());
        dictMapper.updateByPrimaryKeySelective(dict);
    }

    /**
     * 描述：批量删除
     *
     * @param ids
     */
    @Override
    public String delete(String ids) {
        try {
            dictMapper.delete(ids);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 通过ID获取其子级列表
     *
     * @param dictParentId
     * @return
     */
    @Override
    public List<Dict> listSubDictByParentId(Long dictParentId) {
        return dictMapper.listSubDictByParentId(dictParentId);
    }

    /**
     * 获取所有数据并填充每条数据的子级列表(递归处理)
     *
     * @param dictParentId
     * @return
     */
    @Override
    public List<Dict> listAllDict(Long dictParentId) {
        List<Dict> dictList = this.listSubDictByParentId(dictParentId);
        for (Dict dict : dictList) {
//			dict.setUrl("/web/dict/index?dictParentId="+dict.getId());
            dict.setUrl("javascript:openTab(\"" + dict.getId() + "\")");
            dict.setChildren(this.listAllDict(dict.getId()));
            dict.setTarget("ajax");
        }
        return dictList;
    }

    /**
     * 根据字典code查询数据字典
     *
     * @param dictCode
     * @return
     */
    @Override
    public List<Dict> listDictByDictCode(String dictCode) {
        return dictMapper.listDictByDictCode(dictCode,"");
    }

}
