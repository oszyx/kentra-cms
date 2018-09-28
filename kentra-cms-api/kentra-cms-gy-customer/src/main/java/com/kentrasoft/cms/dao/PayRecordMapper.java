package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.PayRecord;
import com.kentrasoft.cms.entity.PayRecordExample;
import com.kentrasoft.cms.entity.dto.DrivingPayRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "payRecordMapper")
public interface PayRecordMapper {
    /**
     *
     * @mbg.generated 2018-06-27
     */
    long countByExample(PayRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int deleteByExample(PayRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int insert(PayRecord record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int insertSelective(PayRecord record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    List<PayRecord> selectByExample(PayRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    PayRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByPrimaryKeySelective(PayRecord record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByPrimaryKey(PayRecord record);
    /**
     * 删除
     * @param ids
     */
    void deleteByPKs(String ids);

    List<DrivingPayRecord> findDrivingPayment(Map<String, Object> queryData);

    //根据车牌号码查询要导出的数据
    List<PayRecord> selectPayRecord();
    List<PayRecord> queryPayRecordListBykey(@Param("licenseNumParam") String licenseNumParam, @Param("PayStatusParam") String PayStatusParam, @Param("IsPayParam") String IsPayParam);
}