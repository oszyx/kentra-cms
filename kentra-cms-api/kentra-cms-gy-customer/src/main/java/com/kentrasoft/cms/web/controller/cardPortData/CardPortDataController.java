package com.kentrasoft.cms.web.controller.cardPortData;

import com.kentrasoft.cms.dao.CardPortDataMapper;
import com.kentrasoft.cms.entity.CardPortData;
import com.kentrasoft.cms.service.CardPortDataService;
import com.kentrasoft.utils.plugin.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述：卡口controller
 *
 * @author zhangmengkang
 * @date 2018-6-27 16:46:59
 */
@Controller
@RequestMapping(value = "/cardPort")
public class CardPortDataController {
    @Autowired
    private CardPortDataService cardPortDataService;
    @Autowired
    private CardPortDataMapper cardPortDataMapper;
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
        BaseResult baseResult = cardPortDataService.findByDrivingRecord(drivingRecord);
        return baseResult;
    }
    /**
     * 根据车牌号、行驶记录ID查询卡口图片
     */
    @RequestMapping("/getCardPortIllegalImages")
    @ResponseBody
     public List<CardPortData> getCardPortIllegalImages(String licenseNum,String drivingRecord){
    	 if(licenseNum != null && licenseNum != "" && drivingRecord != null && drivingRecord != ""){
    		 List<CardPortData> list = cardPortDataMapper.getCardPortIllegalImages(licenseNum,drivingRecord);
    		 return list;
    	 }
    	 return null;
     }
}
