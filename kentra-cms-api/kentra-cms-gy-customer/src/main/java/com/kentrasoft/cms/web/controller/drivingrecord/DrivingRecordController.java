package com.kentrasoft.cms.web.controller.drivingrecord;

import com.kentrasoft.cms.dao.BreakRecordMapper;
import com.kentrasoft.cms.dao.DrivingTrackMapper;
import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.cms.service.DrivingRecordService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/drivingrecord")
public class DrivingRecordController {
	@Autowired
	private DrivingRecordService drivingRecordService;
	
	@Autowired
	private DrivingTrackMapper drivingTrackMapper;
	
	@Autowired
	private BreakRecordMapper breakRecordMapper;
	
	/**
	 * 获取行驶记录数据列表
	 */
	@RequestMapping(value = "/getPageList")
	@ResponseBody
	public PageForm<DrivingRecord> getPageList(PageForm<DrivingRecord> page, String licenseNum, String entranceName, String exitName){
		PageForm<DrivingRecord> pageForm = drivingRecordService.queryDrivingList(page,licenseNum,entranceName,exitName);
		return pageForm;
	}
	
	/**
	 * 获取关于车牌的所有行驶记录
	 * @param licenseNum
	 * @return
	 */
	@RequestMapping(value = "/getLicenseNumList")
	@ResponseBody
	public PageForm<DrivingRecord> getLicenseNumList(String licenseNum) {
		if (StringUtils.isEmpty(licenseNum)) {
			return null;
		}
		List<DrivingRecord> data=drivingRecordService.getLicenseNum(licenseNum);
		PageForm<DrivingRecord> page=new PageForm<DrivingRecord>();
		page.setData(data);
		return page;
	}
	
	/**
	 * 存储行驶记录
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public BaseResult save(DrivingRecord drivingRecord) {
		drivingRecordService.add(drivingRecord);
		return BaseResult.success("保存成功！");
	}

	/**
	 *  查询行车记录
	 */
	@RequestMapping(value = "/findByCustomerId")
	@ResponseBody
	public BaseResult findByCustomerId(Long customerId){
		if (customerId==null) {
			return BaseResult.faild("未知用户信息！");
		}
		BaseResult baseResult = drivingRecordService.findByCustomerId(customerId);
		return baseResult;
	}
	
    /**
     * 描述：删除行驶记录
     *
     * @param ids
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public BaseResult delete(String ids) {
        String status = drivingRecordService.delete(ids);
        if (!status.equals("200")) {
            return BaseResult.faild(status);
        }
        return BaseResult.success("删除成功");
    }
    
    /**
     * 保存违规记录
     */
    @RequestMapping(value = "/saveIrregularities")
    @ResponseBody
    public BaseResult saveIrregularities(DrivingRecord drivingRecord) {
    	try {
        BreakRecord breakRecord = new BreakRecord();
        breakRecord.setDrivingRecord(drivingRecord.getDrivingRecord());
        breakRecord.setLicenseNum(drivingRecord.getLicenseNum());
        breakRecord.setEntranceName(drivingRecord.getEntranceName());
        breakRecord.setEntranceTime(drivingRecord.getEntranceTime());
        breakRecord.setExitName(drivingRecord.getExitName());
        breakRecord.setExitTime(drivingRecord.getExitTime());
        
        String str1 = drivingRecord.getReceivables();
        String str2 = drivingRecord.getPayCount();
        double receivables = Double.valueOf(str1);
        double payCount = Double.valueOf(str2);
        double expensesPaid = receivables - payCount;
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        format.setMinimumFractionDigits(2);
        String value=format.format(expensesPaid);
        
        breakRecord.setExtends1(format.format(Double.valueOf(drivingRecord.getReceivables())));//应缴费
        breakRecord.setExtends2(format.format(Double.valueOf(drivingRecord.getPayCount())));//已缴费          
        breakRecord.setPayMoney(value);//待缴费
        breakRecord.setAuditStatus("break_underview_01");//待审核
        breakRecord.setRemakeType(drivingRecord.getExtends1());//违规类型
        breakRecord.setRemakeContent(drivingRecord.getExtends2());//违规备注
        breakRecord.setCreateTime(new Date());
        breakRecordMapper.insert(breakRecord);        
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return BaseResult.success("违规处理信息录入成功！");
    }
}
