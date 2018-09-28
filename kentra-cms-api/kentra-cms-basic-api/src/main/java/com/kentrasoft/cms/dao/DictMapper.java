package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.Dict;
import com.kentrasoft.cms.entity.DictExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "dictMapper")
public interface DictMapper {
    /**
     * @mbg.generated 2018-05-25
     */
    long countByExample(DictExample example);

    /**
     * @mbg.generated 2018-05-25
     */
    int deleteByExample(DictExample example);

    /**
     * @mbg.generated 2018-05-25
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 2018-05-25
     */
    int insert(Dict record);

    /**
     * @mbg.generated 2018-05-25
     */
    int insertSelective(Dict record);

    /**
     * @mbg.generated 2018-05-25
     */
    List<Dict> selectByExample(DictExample example);

    /**
     * @mbg.generated 2018-05-25
     */
    Dict selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 2018-05-25
     */
    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    /**
     * @mbg.generated 2018-05-25
     */
    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    /**
     * @mbg.generated 2018-05-25
     */
    int updateByPrimaryKeySelective(Dict record);

    /**
     * @mbg.generated 2018-05-25
     */
    int updateByPrimaryKey(Dict record);


    /**
     * 描述：批量删除
     */
    void deleteByPKs(String ids);

    /**
     * 描述：根据父级ID查询数据字典信息
     *
     * @mbg.generated 2018-06-05
     */
    List<Dict> listSubDictByParentId(Long dictParentId);

    /**
     * 描述：根据字典code查询数据字典信息
     *
     * @mbg.generated 2018-06-10
     */
    List<Dict> listDictByDictCode(@Param("dictCode") String dictCode, @Param("dictId") String dictId);

    /**
     * 删除字典
     */
    void delete(String ids);

    /**
     * 查询是否含有子菜单
     */
    List<Dict> queryChildrenBydictId(@Param("dictId") String dictId);

    /**
     * 用户添加信息的时候 获取准驾车型数据字典数据
     *
     * @return
     */
    List<Dict> getQuasiDrivingType();

    /**
     * 用户添加信息的时候 获取车辆类型
     * @return
     */
    List<Dict> getCarType();

    /**
     * 用户添加信息的时候 获取车牌号前缀
     * @return
     */
    List<Dict> getPlateNumPrefix();
}