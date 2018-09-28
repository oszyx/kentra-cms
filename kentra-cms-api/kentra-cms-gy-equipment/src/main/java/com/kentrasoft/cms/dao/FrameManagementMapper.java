package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.DictInfos;
import com.kentrasoft.cms.entity.FrameManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FrameManagementMapper {
    /**
     *
     * @mbg.generated 2018-06-21
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-21
     */
    int insert(FrameManagement record);

    /**
     *
     * @mbg.generated 2018-06-21
     */
    FrameManagement selectByPrimaryKey(String id);

    /**
     *自定义查询导出数据
     * @mbg.generated 2018-06-21
     */
    List<FrameManagement> selectAll();
    List<FrameManagement> selectBykey(@Param("serchnameParam") String serchnameParam, @Param("searchNoParam") String searchNoParam, @Param("serchStatusParam") String serchStatusParam);

    /**
     *
     * @mbg.generated 2018-06-21
     */
    int updateByPrimaryKey(FrameManagement record);

    /**
     * 查询总数
     */
    int QueryCount(@Param("serchName") String serchName, @Param("searchNo") String searchNo,
                   @Param("serchStatus") String serchStatus);

    /**
     * 翻页查询
     */
    List<FrameManagement> QuerypageForm(@Param("limitStar") int limitStar, @Param("limitEnd") int limitEnd,
                                        @Param("serchName") String serchName, @Param("searchNo") String searchNo,
                                        @Param("serchStatus") String serchStatus);
    /**
     * 获取设备状态信息
     *author:赵参谋
     * @return
     */
    List<DictInfos> getDictFrameStatus(@Param("parentId") String parentId);
    /**
     * 查询判断是否重复数据
     */
    List<FrameManagement> querybyFrameCode(@Param("frameCode") String frameCode, @Param("frameId") String frameId);

    /**
     * 设备状态更新
     */
    void updateFrameStatus(@Param("id") String id, @Param("frameStatus") String frameStatus);
    
    /**
     * 查询创建时间
     */
    List<FrameManagement> QueryCreatTime(String id);
}