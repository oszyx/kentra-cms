package com.kentrasoft.cms.controller.dict;


import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.DictMapper;
import com.kentrasoft.cms.entity.Dict;
import com.kentrasoft.cms.entity.DictExample;
import com.kentrasoft.cms.service.DictService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sys/dict/")
public class DictController {

    @Autowired
    private DictService dictService;

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 数据字典tree
     *
     * @param
     * @return
     */
    @RequestMapping("getNodeList")
    public List<Dict> getNodeList() {
        List<Dict> dictList = dictService.listAllDict(Long.parseLong("1"));
        return dictList;
    }

    /**
     * 数据字典列表
     *
     * @param page
     * @return
     */
    @RequestMapping("getPageList")
    public PageForm<Dict> getPageList(PageForm<Dict> page, Long pid, String dictName, String dictStatus) {
        PageForm<Dict> pageForm = dictService.getPageList(page, pid, dictName, dictStatus);
        return pageForm;
    }

    /**
     * 描述：新增数据字典
     *
     * @param
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(Dict dict) {
        try {
            if (dict.getDictParentId() == null || "".equals(dict.getDictParentId())) {
                dict.setDictParentId(Long.parseLong("1"));
            }
            dict.setCreator("1");
            dict.setCreateDate(new Date());
            dict.setStatus(true);
            List<Dict> dictList = dictMapper.listDictByDictCode(dict.getDictCode(), "");
            if (dictList.size() > 0) {
                return BaseResult.faild("字典编号已存在");
            }
            redisUtil.set(dict.getDictCode(), dict.getDictName());
            dictMapper.insertSelective(dict);
            return BaseResult.success("新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("新增失败！");
        }
    }

    /**
     * 描述：修改数据字典信息
     *
     * @param
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(Dict dict) {
        try {
            //查询字典编号是否重复
            DictExample dictExample = new DictExample();
            DictExample.Criteria crit = dictExample.createCriteria();
            crit.andDictCodeEqualTo(dict.getDictCode());
            crit.andIdNotEqualTo(dict.getId());
            List<Dict> dictList = dictMapper.selectByExample(dictExample);
            if (dictList != null && dictList.size() > 0) {
                return BaseResult.faild("字典编号已存在");
            }
            //删除redis数据
            Dict dict_index = dictMapper.selectByPrimaryKey(dict.getId());
            redisUtil.remove(dict_index.getDictCode());
            //新增redis数据
            redisUtil.set(dict.getDictCode(), dict.getDictName());
            dictService.edit(dict);
            return BaseResult.success("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("修改失败！");
        }

    }

    /**
     * 描述：删除数据字典
     *
     * @param ids
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        try {
            //判断是否含有子菜单
            List<Dict> dictList = dictMapper.queryChildrenBydictId(ids);
            if (dictList != null && dictList.size() > 0) {
                return BaseResult.faild("请先删除子字典");
            }
            List<String> dictIds = Arrays.asList(ids.split(","));
            for (String id : dictIds) {
                Dict dict = dictMapper.selectByPrimaryKey(Long.parseLong(id));
                redisUtil.remove(dict.getDictCode());
            }
            dictService.delete(ids);
            return BaseResult.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.faild("删除失败！");
        }
    }

    /**
     * 根据字典父节点查询数据字典
     *
     * @param dictParentId
     * @return
     */
    @RequestMapping(value = "/findByDictParentId")
    @ResponseBody
    public List<Dict> findByDictParentId(Long dictParentId) {
        List<Dict> dict = dictService.listSubDictByParentId(dictParentId);
        return dict;
    }

    /**
     * 根据字典code查询数据字典
     *
     * @param dictCode
     * @return
     */
    @RequestMapping(value = "/listDictByDictCode")
    @ResponseBody
    public List<Dict> listDictByDictCode(String dictCode) {
        List<Dict> dict = dictService.listDictByDictCode(dictCode);
        return dict;
    }

    /**
     * 根据字典Id查询数据字典
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById")
    @ResponseBody
    public Dict findById(Long id) {
        Dict dict = dictService.findById(id);
        return dict;
    }

    /**
     * 用户添加信息的时候 获取车辆类型 和 准驾车型 数据字典数据
     */
    @RequestMapping(value = "/getDriAndCarTypeDict")
    @ResponseBody
    public BaseResult getQuasiDrivingType() {
        Dict dict = new Dict();
        List<Dict> quasiDrivingType = dictMapper.getQuasiDrivingType();
        List<Dict> carType = dictMapper.getCarType();
        List<Dict> plateNumPrefix = dictMapper.getPlateNumPrefix();
        dict.setQuasiDrivingType(quasiDrivingType);
        dict.setCarType(carType);
        dict.setPlateNumPrefix(plateNumPrefix);
        return BaseResult.success("获取成功!", dict);
    }
}
