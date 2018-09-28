package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

/**
 * 违规处理接口
 *
 * @author Administrator
 */
public interface BreakRecordService {

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    PageForm<BreakRecord> getPageList(PageForm<BreakRecord> page, String licenseNum, String remakeType, String searchBreakType);

    /**
     * 描述：添加
     *
     * @param breakRecord
     */
    BaseResult add(BreakRecord breakRecord);

    /**
     * 描述：删除
     *
     * @param ids
     */
    BaseResult delete(String ids);

    /**
     * 描述：修改
     *
     * @param breakRecord
     */
    BaseResult edit(BreakRecord breakRecord);

    /**
     * 导出违规信息
     *
     * @return
     */
    List<BreakRecord> exportBreakRecord(String searchLicenseNum, String searchAuditStatus, String searchRemakeType);

    /**
     * 审核违规信息
     *
     * @param breakRecord
     * @return
     */
    BaseResult examine(BreakRecord breakRecord);

    /**
     * 描述：违规统计
     *
     * @param year
     */
    BaseResult breakCount(String year);
}
