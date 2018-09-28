package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.DrivingLicense;
import com.kentrasoft.utils.plugin.PageForm;

import java.util.List;

/**
 * 描述：客户行驶证信息service接口
 *
 * @author lihr
 * @date 2018/6/13
 */
public interface DrivingLicenseService {

    /**
     * 描述：条件分页查询
     * @param page
     * @return
     */
    PageForm<DrivingLicense> getPageList(PageForm<DrivingLicense> page, String customerId);

    /**
     * 描述：新增用户行驶证信息
     * @param customer
     */
    String add(DrivingLicense drivingLicense);

    /**
     * 描述：根据Id查找用户行驶证信息
     * @param id
     * @return
     */
    DrivingLicense findById(Long id);

    /**
     * 描述：修改用户行驶证信息
     * @param dict
     */
    void edit(DrivingLicense drivingLicense);

    /**
     * 描述：删除用户行驶证信息
     * @param ids
     */
    String delete(String ids);

    /**
     * 描述：查询行驶证信息
     * @param customerId
     */
    List<DrivingLicense> getDrivingLicense(String customerId);

    /**
     * 描述：修改用户默认行驶证
     * @param id,customerId
     */
    void updateDrivingLicenseStatus(String id, String customerId);

    /**-------------------------------------liyang-----------------------------------*/
    /**
     * 打印的时候根据客户id查询其所有的drivinglicense
     * @param customerId 客户id
     * @return
     */
    List<DrivingLicense> getDrivingLicenseList(String customerId);
    /**-------------------------------------liyang-----------------------------------*/
   
    /**
     * 查询车牌号是否已经路径
     */
//    List<DrivingLicense> queryBylicense(DrivingLicense drivingLicense);
}
