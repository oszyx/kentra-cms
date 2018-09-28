package com.kentrasoft.cms.web.controller;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.service.ControllerManagementService;
import com.kentrasoft.cms.service.RepairRecordService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：控制器管理controller
 *
 * @author zmk
 * @date 2018-6-12 13:42:37
 */
@Controller
@RequestMapping(value = "/control")
public class ControllerManagementController extends BaseController {
    @Autowired
    private ControllerManagementService controllerManagementService;

    @Autowired
    private RepairRecordService repairRecordService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 描述：分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getListPage",method = RequestMethod.GET)
    @ResponseBody
    public PageForm<ControllerManagement> getPageList(PageForm<ControllerManagement> page, HttpServletRequest httpRequest) {
        String name = httpRequest.getParameter("name");
        String controllerCode = httpRequest.getParameter("controllerCode");
        String controllerStatus = httpRequest.getParameter("controllerStatus");
        String extends3 = httpRequest.getParameter("extends3");
        PageForm<ControllerManagement> pageForm = controllerManagementService.getPageList(page,name,controllerCode,controllerStatus,extends3);
        return pageForm;
    }

    /**
     * 描述：添加控制器
     *
     * @param controllerManagement
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(ControllerManagement controllerManagement) {
        return controllerManagementService.add(controllerManagement);
    }

    /**
     * 描述：删除控制器
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return controllerManagementService.delete(ids);
    }


    /**
     * 描述：修改控制器信息
     *
     * @param controllerManagement
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(ControllerManagement controllerManagement) {
        return controllerManagementService.edit(controllerManagement);
    }

    /**
     * 描述：添加维修记录
     *
     * @param repairRecord
     * @return
     */
    @RequestMapping(value = "/repair")
    @ResponseBody
    public BaseResult repair(RepairRecord repairRecord) {
        BaseResult result = repairRecordService.add(repairRecord);
        /*if ("200".equals(result.getStatusCode())) {
            controllerManagementService.updataStatus(repairRecord.getRepairDeviceId(),repairRecord.getRepairStatus());
        }*/
        return result;
    }

    /**
     * 描述：导出excel
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ExcelData excelData = this.exportRegisterOrgan(request,response);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }
    /**
     * 
     *author:赵参谋
     * @param request
     * @param response
     * @return
     */
    public ExcelData exportRegisterOrgan(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		ExcelData excelData = new ExcelData();
            excelData.setExcelName("控制器管理数据");
            // 设置Sheet名称
            excelData.setSheetName("控制器管理数据");
            // 设置表头
            String heads = "设备编号,设备名称,设备地址,设备经度,设备纬度,网络地址,网络端口,网络状态,天线状态,设备描述信息,设备创建时间,设备更新时间";
           // 设置单元格宽度
            Map<Integer, Integer> widthAndHeiht = new HashMap<Integer, Integer>();
            widthAndHeiht.put(1, 5000);
            widthAndHeiht.put(2, 5000);
            widthAndHeiht.put(3, 5000);
            widthAndHeiht.put(4, 5000);
            widthAndHeiht.put(5, 5000);
            widthAndHeiht.put(6, 5000);
            widthAndHeiht.put(7, 5000);
            widthAndHeiht.put(8, 5000);
            widthAndHeiht.put(9, 5000);
            widthAndHeiht.put(10, 5000);
            widthAndHeiht.put(11, 5000);
            widthAndHeiht.put(12, 5000);
            excelData.setWidthAndHeiht(widthAndHeiht);
            
            //数据
            PageForm<ControllerManagement> pageForm = new PageForm();
            pageForm.setLimit(Integer.MAX_VALUE);
            pageForm.setPage(1);
            PageForm<ControllerManagement> pageList = this.getPageList(pageForm, request);
            List<ControllerManagement> controllerManagements = pageList.getData();
            
            if (controllerManagements != null && controllerManagements.size() > 0) {
                List<String> data = new ArrayList<String>();
                StringBuffer row = new StringBuffer();
                SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (ControllerManagement controller : controllerManagements) {
                	row.append(controller.getControllerCode()==null?"":controller.getControllerCode()).append(",")
                	           .append(controller.getName()==null?"":controller.getName()).append(",")
                	           .append(controller.getControllerAddress()==null?"":controller.getControllerAddress()).append(",")
                	           .append(controller.getControllerGisX()==null?"":controller.getControllerGisX()).append(",")
                	           .append(controller.getControllerGisY()==null?"":controller.getControllerGisY()).append(",")
                	           .append(controller.getExtends1()==null?"":controller.getExtends1()).append(",")
                	           .append(controller.getExtends2()==null?"":controller.getExtends2()).append(",")
                	           .append((String)redisUtil.get(controller.getControllerStatus())).append(",")
                	           .append((String)redisUtil.get(controller.getExtends3())).append(",")
                	           .append(controller.getDescripInfos()==null?"":controller.getDescripInfos()).append(",")
                	           .append(controller.getCreateTime()==null? "":dateFormate.format(controller.getCreateTime())).append(",")
                	           .append(controller.getUpdateTime() == null?"":dateFormate.format(controller.getUpdateTime()));
                	data.add(row.toString());
                	row.delete(0, row.length());
                }
                excelData.setData(data);
            }
            excelData.setHeads(heads);
            return excelData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}
