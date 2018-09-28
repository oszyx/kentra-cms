package com.kentrasoft.cms.service;


import com.kentrasoft.cms.entity.TollStation;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

/**
 * 
 * 收费站接口
 * @author Administrator
 *
 */
public interface TollStationService {
	/**
     * 分页查询
     *
     * @param page
     * @return
     */
    PageForm<TollStation> getPageList(PageForm<TollStation> page, String tollStationName, String tollStationCode);

    /**
     * 描述：添加
     * @param breakRecord
     */
    BaseResult add(TollStation tollStation);

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
    BaseResult edit(TollStation tollStation);

    /**
     * 导出违规信息
     * @return
     */
    List<TollStation> exportBreakRecord(String tollStationName, String tollStationCode);
    
}
