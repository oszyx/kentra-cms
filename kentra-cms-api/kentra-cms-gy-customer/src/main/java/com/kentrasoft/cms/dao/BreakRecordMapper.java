package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.cms.entity.BreakRecordExample;
import com.kentrasoft.cms.entity.dto.BreakCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "breakRecordMapper")
public interface BreakRecordMapper {
    /**
     *
     * @mbg.generated 2018-06-14
     */
    long countByExample(BreakRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int deleteByExample(BreakRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int insert(BreakRecord record);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int insertSelective(BreakRecord record);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    List<BreakRecord> selectByExample(BreakRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    BreakRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByExampleSelective(@Param("record") BreakRecord record, @Param("example") BreakRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByExample(@Param("record") BreakRecord record, @Param("example") BreakRecordExample example);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByPrimaryKeySelective(BreakRecord record);

    /**
     *
     * @mbg.generated 2018-06-14
     */
    int updateByPrimaryKey(BreakRecord record);
    
    void deleteByPKs(String ids);
    
    BreakRecord selectBreakRecordBylicenseNum(String licenseNum);

    List<BreakCount> breakCount(String year);
    
    /**
     * 进出口查询违规记录
     *author:赵参谋
     * @param trackId
     * @return
     */
    BreakRecord selectBytrackid(@Param("trackId") String trackId);
}