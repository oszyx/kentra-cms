package com.kentrasoft.cms.web.controller.customer;

import com.kentrasoft.cms.dao.DrivingLicenseMapper;
import com.kentrasoft.cms.entity.DrivingLicense;
import com.kentrasoft.cms.service.DrivingLicenseService;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/management/drivingLicense/")
public class DrivingLicenseController {

	@Autowired
	private DrivingLicenseService drivingLicenseService;
	
	@Autowired
	private DrivingLicenseMapper drivingLicenseMapper;
	
    /**
     * 行驶证列表
     * @param page
     * @return
     */
    @RequestMapping("getPageList")
	public PageForm<DrivingLicense> getPageList(PageForm<DrivingLicense> page,
                                                String customerId) {
    	PageForm<DrivingLicense> pageForm = drivingLicenseService.getPageList(page,customerId);
        return pageForm;
	}

    /**
     * 描述：新增行驶证
     * @param drivingLicense
     */
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/add")
    @ResponseBody
    public BaseResult add(DrivingLicense drivingLicense) {
    	//判断车牌是否重复
//    	List<DrivingLicense> drvinglicenselist=drivingLicenseService.queryBylicense(drivingLicense);
        List<DrivingLicense> drivingLicenses = drivingLicenseMapper.selectByLicNum(drivingLicense.getLicenseNum());
        if(drivingLicenses!=null && drivingLicenses.size()>0) {
    		return BaseResult.faild("车牌号已存在");
    	}
    	String result = drivingLicenseService.add(drivingLicense);
    	if(result != "") {
            return BaseResult.faild(result);
    	}
        return BaseResult.success("新增成功！");
    }

    /**-------------------------------------liyang-----------------------------------*/
    /**打印的时候根据客户id查询其所有的drivinglicense*/
    @RequestMapping(value = "/getDrivingLicenseList")
    @ResponseBody
    public List<DrivingLicense> getDrivingLicenseList(String customerId) {
        if (StringUtils.isNullOrEmpty(customerId)) {
            return null;
        }
        List<DrivingLicense> drivingLicenseList = drivingLicenseService.getDrivingLicenseList(customerId);
        return drivingLicenseList;
    }
    /**-------------------------------------liyang-----------------------------------*/
    /**
     * 删除行驶证信息
     */
    @RequestMapping("/deleteLicense")
    public BaseResult<DrivingLicense> deleteLicense(String id){
    	try {
    		drivingLicenseMapper.delete(id);
    		return BaseResult.success("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return BaseResult.faild("删除失败");
		}
    }
}
