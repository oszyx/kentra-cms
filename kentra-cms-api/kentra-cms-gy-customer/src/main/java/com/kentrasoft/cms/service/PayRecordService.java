package com.kentrasoft.cms.service;


import com.kentrasoft.cms.entity.PayRecord;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;
import java.util.Map;

/**
 * 描述：缴费记录Service
 * @author jiaming
 *
 */

public interface PayRecordService {
	/**
     * 分页查询
     *
     * @param page
     * @return
     */
    PageForm<PayRecord> getPageList(PageForm<PayRecord> page, String licenseNum, String payStatus, String isPay);

    /**
     * 描述：添加缴费记录
     * @param record
     */
    void add(PayRecord record);

    /**
     * 描述：删除缴费记录
     *
     * @param ids
     */
    String delete(String ids);

    /**
     * 描述：修改缴费记录
     *
     * @param record
     */
    void edit(PayRecord record);

	/**
	 * 导出缴费记录
	 * @return
	 */
	List<PayRecord> exportPayRecord(String licenseNumParam, String PayStatusParam, String IsPayParam);

    /**
     * 描述：查询用户行车缴费记录
     * @param queryData
     * @return
     */
    BaseResult findDrivingPayment(Map<String, Object> queryData);

}
