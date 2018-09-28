package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.LedManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * 描述：控制器管理服务接口
 *
 * @author liyang
 * @date 2018年6月19日 16点15分
 */
public interface LedService {

    /**
     * 分页查询
     *
     * @param page 分页数据
     * @return
     */
    PageForm<LedManagement> getLedPage(PageForm<LedManagement> page);

    /**
     * 编辑信息
     *
     * @param ledManagement 修改led信息体
     * @return
     */
    BaseResult edit(LedManagement ledManagement);

    /**
     * 删除led信息，PS:维修记录保留
     *
     * @param ids 删除数据ids
     * @return
     */
    BaseResult delete(String ids);

    /**
     * 添加led信息
     *
     * @param ledManagement 添加led信息体
     * @return
     */
    BaseResult add(LedManagement ledManagement) throws ParseException;

    /**
     * 导出
     *
     * @param request
     * @param response
     * @param name     查询参数
     */
    void export(HttpServletRequest request, HttpServletResponse response, String name, String code, String status) throws IOException;

    /**
     * led维护
     *
     * @param repairRecord
     * @return
     */
    BaseResult repair(RepairRecord repairRecord);

    /**
     * 获取维修记录分页列表
     *
     * @param ledId led谁被id
     * @return
     */
    List<RepairRecord> getRepairRecord(String ledId);
}
