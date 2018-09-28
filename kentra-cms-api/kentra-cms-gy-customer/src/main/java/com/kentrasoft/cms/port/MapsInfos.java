package com.kentrasoft.cms.port;

import com.kentrasoft.cms.dao.DrivingTrackMapper;
import com.kentrasoft.cms.port.entity.exitPoint.ExitpointQueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MapsInfos {
	
	private static final Logger log=LoggerFactory.getLogger(MapsInfos.class);
     
	@Autowired
	DrivingTrackMapper drvingTrackMapper;
	
	/**
	 * 获取地图轨迹信息
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/getMapInfos")
	@ResponseBody
	public  List<ExitpointQueryResult> getMapInofos(String trackid) {
		log.info("----地图查询行驶轨迹----{}",trackid);
		List<ExitpointQueryResult> exitpointQueryResult=drvingTrackMapper.queryBytrackid(trackid);
		return exitpointQueryResult;
	}
}
