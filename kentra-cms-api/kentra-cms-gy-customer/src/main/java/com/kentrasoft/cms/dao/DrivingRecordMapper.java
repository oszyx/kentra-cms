package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.cms.entity.DrivingRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "drivingRecordMapper")
public interface DrivingRecordMapper {
    /**
     *
     * @mbg.generated 2018-06-27
     */
    long countByExample(DrivingRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int deleteByExample(DrivingRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int insert(DrivingRecord record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int insertSelective(DrivingRecord record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    List<DrivingRecord> selectByExample(DrivingRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    DrivingRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByExampleSelective(@Param("record") DrivingRecord record, @Param("example") DrivingRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByExample(@Param("record") DrivingRecord record, @Param("example") DrivingRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByPrimaryKeySelective(DrivingRecord record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByPrimaryKey(DrivingRecord record);
    
    /**
     * 删除
     * @param ids
     */
    void deleteByPKs(String ids);
    
    /**
     * 查询行驶记录数据列表
     */
//    List<DrivingRecord> queryDrivingList(PageForm<DrivingRecord> page);
    
//    List<DrivingRecord> queryDrivingListBylicenseNum(@Param("page")PageForm<DrivingRecord> page,@Param("licenseNum")String licenseNum,@Param("entranceName")String entranceName,@Param("exitName")String exitName);

    List<DrivingRecord> findByCustomerId(Long customerId);
    
    List<DrivingRecord> selectDrivingRecordBylicenseNum(String licenseNum);
    
    /**
     * 卡口查询最近的行驶记录id
     */
    DrivingRecord selectbyCardportPasstime(@Param("licenseNum") String licenseNum, @Param("passtime") String passtime);

    /**
     * 进出口查询行驶记录
     *author:赵参谋
     * @param licenseNum
     * @param outTime 出站时间
     * @return
     */
    DrivingRecord selectbyInoutEndtime(@Param("licenseNum") String licenseNum, @Param("outTime") String outTime);
}