package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.RepairRecord;
import com.kentrasoft.cms.entity.RepairRecordExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component(value = "repairRecordMapper")
public interface RepairRecordMapper {
    /**
     * @mbg.generated 2018-06-20
     */
    long countByExample(RepairRecordExample example);

    /**
     * @mbg.generated 2018-06-20
     */
    int deleteByExample(RepairRecordExample example);

    /**
     * @mbg.generated 2018-06-20
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 2018-06-20
     */
    int insert(RepairRecord record);

    /**
     * @mbg.generated 2018-06-20
     */
    int insertSelective(RepairRecord record);

    /**
     * @mbg.generated 2018-06-20
     */
    List<RepairRecord> selectByExample(RepairRecordExample example);

    /**
     * @mbg.generated 2018-06-20
     */
    RepairRecord selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 2018-06-20
     */
    int updateByExampleSelective(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    /**
     * @mbg.generated 2018-06-20
     */
    int updateByExample(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

    /**
     * @mbg.generated 2018-06-20
     */
    int updateByPrimaryKeySelective(RepairRecord record);

    /**
     * @mbg.generated 2018-06-20
     */
    int updateByPrimaryKey(RepairRecord record);

    void deleteByPKs(String ids);

    /**---------------------------ly----------------------------*/
    /**
     * 获取led设备维修记录
     *
     * @param ledId
     */
    List<RepairRecord> selectByLedId(String ledId);

    /**
     *
     * @param params
     */
    void deleteByIds(Map<String, Object> params);
    /**---------------------------ly----------------------------*/
    
    //更新维修状态
    void updateRepairRecordStatus(@Param("repairDeviceId") String repairDeviceId, @Param("repairStatus") String repairStatus);
}