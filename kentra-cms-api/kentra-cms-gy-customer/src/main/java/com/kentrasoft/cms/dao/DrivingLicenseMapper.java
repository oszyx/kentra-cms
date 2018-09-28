package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.DrivingLicense;
import com.kentrasoft.cms.entity.DrivingLicenseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "drivingLicenseMapper")
public interface DrivingLicenseMapper {
    /**
     *
     * @mbg.generated 2018-06-13
     */
    long countByExample(DrivingLicenseExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int deleteByExample(DrivingLicenseExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int insert(DrivingLicense record);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int insertSelective(DrivingLicense record);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    List<DrivingLicense> selectByExample(DrivingLicenseExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    DrivingLicense selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByExampleSelective(@Param("record") DrivingLicense record, @Param("example") DrivingLicenseExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByExample(@Param("record") DrivingLicense record, @Param("example") DrivingLicenseExample example);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByPrimaryKeySelective(DrivingLicense record);

    /**
     *
     * @mbg.generated 2018-06-13
     */
    int updateByPrimaryKey(DrivingLicense record);

    /**
     *
     * @mbg.generated 2018-06-21
     */
    int updateDrivingLicenseStatus(Long customerId);
    
    /**
     *
     * @mbg.generated 2018-06-21
     */
    int delete(String id);

    /**
     * 添加行驶证信息的时候查询该车牌号是否存在
     * @param licenseNum
     */
    List<DrivingLicense> selectByLicNum(String licenseNum);

    /**-------------------------------------liyang-----------------------------------*/

    void deleteByCustomerIds(String ids);
    /**
     * 打印的时候根据客户id查询其所有的drivinglicense
     * @param customerId 客户id
     * @return
     */
    List<DrivingLicense> getDrivingLicenseList(String customerId);
    /**-------------------------------------liyang-----------------------------------*/
    
    /**
     * 根据车牌查询是否重复
     */
   List<DrivingLicense> queryBylicense(DrivingLicense drivingLicense);
}