package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.LedManagement;
import com.kentrasoft.utils.plugin.PageForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "ledManagementMapper")
public interface LedManagementMapper {

    /**-------------------------------------------liyang----------------------------------------*/
    /**
     * 获取总数据量
     *
     * @mbg.generated 2018-06-19
     */
    long countByExample(LedManagement ledManagement);

    /**
     * 获取列表数据
     *
     * @mbg.generated 2018-06-19
     */
    List<LedManagement> selectByExample(PageForm<LedManagement> page);

    /**
     * 编辑信息
     *
     * @param ledManagement led信息
     * @return
     */
    int updateByExampleSelective(LedManagement ledManagement);

    /**
     * 删除led信息，PS:维修记录保留
     *
     * @param params 删除的id集合
     */
    void deleteByIds(Map<String, Object> params);

    /**
     * 添加功能
     *
     * @mbg.generated 2018-06-19
     */
    int insert(LedManagement ledManagement);

    /**
     * 添加的时候查询是否已经存在此设备
     *
     * @param ledCode
     * @return
     */
    LedManagement selectByLedCode(String ledCode);

    /**
     * 修改的时候根据设备id和code查询该code是否已经存在
     *
     * @param params
     * @return
     */
    LedManagement selectByLedCodeId(Map<String, Object> params);

    /**-------------------------------------------liyang----------------------------------------*/

    /**
     * 查询导出数据
     */
    List<LedManagement> selectLedList();
    List<LedManagement> selectLedListBySearch(@Param("searchName") String searchName, @Param("searchCode") String searchCode, @Param("searchStatus") String searchStatus);
}