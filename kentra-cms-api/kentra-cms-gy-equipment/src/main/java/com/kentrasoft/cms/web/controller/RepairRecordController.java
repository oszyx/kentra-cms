package com.kentrasoft.cms.web.controller;


import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.service.RepairRecordService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：设备维护管理controller
 *
 * @author zhangmengkang
 * @date 2018-6-12 13:42:37
 */
@Controller
@RequestMapping(value = "/repair")
public class RepairRecordController {

    @Autowired
    private RepairRecordService repairRecordService;

    /**
     * 描述：分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getListPage", method = RequestMethod.GET)
    @ResponseBody
    public PageForm<RepairRecord> getPageList(PageForm<RepairRecord> page, HttpServletRequest httpRequest) {
        String repairUserName = httpRequest.getParameter("repairUserName");
        String repairDeviceId = httpRequest.getParameter("repairDeviceId");
        PageForm<RepairRecord> pageForm = repairRecordService.getPageList(page, repairUserName, repairDeviceId);
        return pageForm;
    }


    /**
     * 描述：添加维修记录
     *
     * @param repairRecord
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(RepairRecord repairRecord) {
        return repairRecordService.add(repairRecord);
    }

    /**
     * 描述：删除维修记录
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return repairRecordService.delete(ids);
    }


    /**
     * 描述：修改维修记录
     *
     * @param repairRecord
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(RepairRecord repairRecord) {
        return repairRecordService.edit(repairRecord);
    }

    /**
     * 描述：根据设备id查找维修记录
     *
     * @param page
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "/findByRepairDeviceId")
    @ResponseBody
    public PageForm<RepairRecord> findByRepairDeviceId(PageForm<RepairRecord> page, HttpServletRequest httpRequest) {
        String repairDeviceId = httpRequest.getParameter("repairDeviceId");
        if (repairDeviceId == "" || repairDeviceId == null) {
            return page;
        }
        page.setLimit(Integer.MAX_VALUE);
        page.setPage(1);
        PageForm<RepairRecord> pageForm = repairRecordService.getPageList(page, null, repairDeviceId);
        return pageForm;

    }
}
