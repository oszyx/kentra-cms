package com.kentrasoft.cms.web.controller.tollStation;

import com.kentrasoft.cms.dao.TollStationMapper;
import com.kentrasoft.cms.entity.TollStation;
import com.kentrasoft.cms.entity.TollStationExample;
import com.kentrasoft.cms.entity.TollStationExample.Criteria;
import com.kentrasoft.cms.service.TollStationService;
import com.kentrasoft.utils.exportExcel.ExportExcelUtils;
import com.kentrasoft.utils.exportExcel.bean.ExcelData;
import com.kentrasoft.utils.plugin.BaseController;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/tollStation")
public class TollStationController extends BaseController {
	
	@Autowired
	private TollStationService	tollStationService;
	
	@Autowired
	private TollStationMapper tollStationMapper;
	
	/**
     * 描述：分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getListPage")
    @ResponseBody
    public PageForm<TollStation> getPageList(PageForm<TollStation> page, String tollStationName, String tollStationCode) {
        PageForm<TollStation> pageForm = tollStationService.getPageList(page,tollStationName,tollStationCode);
        return pageForm;
    }

    /**
     * 描述：添加
     *
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(TollStation tollStation) {
    	//判断编号是否重复
    	TollStationExample tollStationExample = new TollStationExample();
    	Criteria criteria=tollStationExample.createCriteria();
    	criteria.andTollStationCodeEqualTo(tollStation.getTollStationCode());
    	criteria.andIdNotEqualTo(tollStation.getId());
    	List<TollStation> tollStationList=tollStationMapper.selectByExample(tollStationExample);
    	if(tollStationList!=null && tollStationList.size()>0) {
    		return BaseResult.faild("收费站编码已存在！");
    	}
    	return tollStationService.add(tollStation);
    }

    /**
     * 描述：删除
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        return tollStationService.delete(ids);
    }


    /**
     * 描述：修改
     *
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public BaseResult edit(TollStation tollStation) {
    	//判断编号是否存在
    	TollStationExample tollStationExample = new TollStationExample();
    	Criteria criteria=tollStationExample.createCriteria();
    	criteria.andTollStationCodeEqualTo(tollStation.getTollStationCode());
    	criteria.andIdNotEqualTo(tollStation.getId());
    	List<TollStation> tollStationList=tollStationMapper.selectByExample(tollStationExample);
    	if(tollStationList!=null && tollStationList.size()>0) {
    		return BaseResult.faild("收费站编码已存在！");
    	}
        return tollStationService.edit(tollStation);
    }
    
    /**
     * 描述:导出违规信息
     */
    @RequestMapping("/exportTollStation")
    public void exportTollStation(String tollStationName,String tollStationCode) {
        ExcelData excelData = this.exportRegisterOrgan(tollStationName,tollStationCode);
        ExportExcelUtils.exportFile(this.getResponse(), excelData);
    }
    
    
    public ExcelData exportRegisterOrgan(String tollStationName, String tollStationCode) {
        ExcelData excelData = new ExcelData();
        excelData.setExcelName("收费站信息数据");
        // 设置Sheet名称
        excelData.setSheetName("收费站信息数据");
        // 设置表头
        String heads = "收费站名称,收费站编码,经度,纬度";
        // 设置单元格宽度
        Map<Integer, Integer> widthAndHeiht = new HashMap<Integer, Integer>();
        widthAndHeiht.put(0, 7000);
        widthAndHeiht.put(1, 5000);
        widthAndHeiht.put(2, 5000);
        widthAndHeiht.put(3, 5000);
        excelData.setWidthAndHeiht(widthAndHeiht);
        // 设置表格主内容
        List<TollStation> payRecords = tollStationService.exportBreakRecord(tollStationName,tollStationCode);
        if (payRecords != null && payRecords.size() > 0) {
            List<String> data = new ArrayList<String>();
            StringBuffer row = new StringBuffer();
            for (TollStation payRecord : payRecords) {
                row.append(payRecord.getTollStationName()).append(",")
                	.append(payRecord.getTollStationCode()).append(",")
                    .append(payRecord.getLongitude()).append(",")
                	.append(payRecord.getLatitude()).append(",");	
                data.add(row.toString());
                row.delete(0, row.length());
            }
            excelData.setData(data);
        }

        excelData.setHeads(heads);
        return excelData;
    }
}
