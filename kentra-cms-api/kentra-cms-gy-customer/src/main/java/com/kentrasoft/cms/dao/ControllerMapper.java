package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.ControllerManagement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component(value="controllerMapper")
public interface ControllerMapper {
	
	/**
	 * 查询控制器设备信息
	 *author:赵参谋
	 * @return
	 */
	public ControllerManagement selectController(@Param("controllerCode") String controllerCode);
    
	/**
	 * 更新控制器状态
	 *author:赵参谋
	 */
	public void updateControllerNet(@Param("controllerCode") String controllerCode,
                                    @Param("netStatus") String netStatus,
                                    @Param("equipStatus") String equipStatus);
	
}
