package com.kentrasoft.cms.web.controller.drivingtrack;

import com.kentrasoft.cms.entity.DrivingTrack;
import com.kentrasoft.cms.service.DrivingTrackService;
import com.kentrasoft.utils.plugin.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 行驶记录统计分析
 * @author jiaming
 *
 */

@Controller
@RequestMapping(value = "/drivingtrack")
public class DrivingTrackController {

	@Autowired
	private DrivingTrackService drivingTrackService;


	/**
	 * 描述：根据行驶记录id查询卡口
	 *
	 * @param drivingRecord 行驶记录Id
	 * @return
	 */
	@RequestMapping("/findByDrivingRecord")
	@ResponseBody
	public BaseResult findByDrivingRecord(String drivingRecord) {
		if (drivingRecord == ""||drivingRecord==null) {
			return BaseResult.faild("行驶记录Id不能为空！");
		}
		BaseResult baseResult = drivingTrackService.findByDrivingRecord(drivingRecord);
		return baseResult;
	}
	/**
	 * 存储设备采集数据
	 */
	@RequestMapping("/save")
	@ResponseBody
	public BaseResult save(DrivingTrack drivingTrack) {
		drivingTrackService.save(drivingTrack);
		return BaseResult.success("保存成功！");
	}
	
	/**
	 * 根据车牌号查询行驶轨迹
	 */
	@RequestMapping("/getDrivingTrack")
	@ResponseBody
	public List<DrivingTrack> getDrivingTrackBylicenseNum(String licenseNum,String drivingRecord) {
		if(licenseNum != null && licenseNum != "" && drivingRecord != null && drivingRecord != ""){
			List<DrivingTrack> list = drivingTrackService.queryDrivingTrackBylicenseNum(licenseNum,drivingRecord);
			return list;
		}
		return null;
	}
}
