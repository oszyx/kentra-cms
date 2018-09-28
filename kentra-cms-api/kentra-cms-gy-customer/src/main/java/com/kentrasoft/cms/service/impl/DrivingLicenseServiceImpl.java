package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.DrivingLicenseMapper;
import com.kentrasoft.cms.entity.DrivingLicense;
import com.kentrasoft.cms.entity.DrivingLicenseExample;
import com.kentrasoft.cms.service.DrivingLicenseService;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：客户行驶证信息service实现
 *
 * @author lihr
 * @date 2018/6/13
 */
@Service
@Transactional
public class DrivingLicenseServiceImpl implements DrivingLicenseService {
	
    @Autowired
    private DrivingLicenseMapper drivingLicenseMapper;
    
    /**
     * 描述：条件分页查询
     * @param page
     * @return
     */
    @Override
    public PageForm<DrivingLicense> getPageList(PageForm<DrivingLicense> page, String customerId) {

    	DrivingLicenseExample drivingLicenseExample = new DrivingLicenseExample();
    	DrivingLicenseExample.Criteria crit = drivingLicenseExample.createCriteria();
    	
        //查询所有的数据数量
        long dricingLicenseCount = drivingLicenseMapper.countByExample(drivingLicenseExample);

        //分页查询所有的数据
        drivingLicenseExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        drivingLicenseExample.setLimitEnd(page.getLimit());
        
        crit.andCustomerIdEqualTo(Long.parseLong(customerId));
        List<DrivingLicense> drivingLicenses = drivingLicenseMapper.selectByExample(drivingLicenseExample);

        //回写内容
        page.setCount((int) dricingLicenseCount);
        page.setData(drivingLicenses);

        return page;
    }

    /**
     * 描述：新增用户行驶证信息
     *
     * @param
     */
    @Override
    public String add(DrivingLicense drivingLicense) { 
    	
    	List<DrivingLicense> drivingLicenseList = this.getDrivingLicense(drivingLicense.getCustomerId().toString());
    	
    	if(drivingLicenseList.isEmpty()) {
    		drivingLicense.setCustomerLevel("0");
    	}else {
    		drivingLicense.setCustomerLevel("1");
    	}
    	
    	drivingLicense.setCreateTime(new Date());
    	drivingLicenseMapper.insertSelective(drivingLicense);
    	
    	return "";
    }
    
    /**
     * 描述：根据Id查找用户行驶证信息
     *
     * @param id
     * @return
     */
    @Override
    public DrivingLicense findById(Long id) {
        return drivingLicenseMapper.selectByPrimaryKey(id);
    }

    /**
     * 描述：修改用户行驶证信息
     *
     * @param
     */
    @Override
    public void edit(DrivingLicense drivingLicense) {
    	drivingLicense.setUpdateTime(new Date());
    	drivingLicenseMapper.updateByPrimaryKeySelective(drivingLicense);
    }

    /**
     * 描述：批量删除
     *
     * @param ids
     */
    @Override
    public String delete(String ids) {
        try {
        	drivingLicenseMapper.delete(ids);
            return "200";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 描述：查询行驶证信息
     *
     * @param customerId
     */
    @Override
    public List<DrivingLicense> getDrivingLicense(String customerId) {
    	DrivingLicenseExample example = new DrivingLicenseExample();
    	DrivingLicenseExample.Criteria crit = example.createCriteria();
    	
    	crit.andCustomerIdEqualTo(Long.parseLong(customerId));
    	
    	return drivingLicenseMapper.selectByExample(example);
    }

    /**
     * 描述：修改用户默认行驶证
     *
     * @param id
     */
    @Override
    public void updateDrivingLicenseStatus(String id,String customerId) {
    	//把该用户的默认行驶证取消
    	drivingLicenseMapper.updateDrivingLicenseStatus(Long.parseLong(customerId));
    	
    	DrivingLicense drivingLicense = new DrivingLicense();
    	drivingLicense.setId(Long.parseLong(id));
    	drivingLicense.setCustomerLevel("0");
    	
    	drivingLicenseMapper.updateByPrimaryKeySelective(drivingLicense);
    }

    /**-------------------------------------liyang-----------------------------------*/
    /**
     * 打印的时候根据客户id查询其所有的drivinglicense
     * @param customerId 客户id
     * @return
     */
    @Override
    public List<DrivingLicense> getDrivingLicenseList(String customerId) {
        return drivingLicenseMapper.getDrivingLicenseList(customerId);
    }
    /**-------------------------------------liyang-----------------------------------*/

//	@Override
//	public List<DrivingLicense> queryBylicense(DrivingLicense drivingLicense) {
//		return  drivingLicenseMapper.queryBylicense(drivingLicense);
//	}
}
