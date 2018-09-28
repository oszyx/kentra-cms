package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.DrivingTrack;
import com.kentrasoft.cms.entity.DrivingTrackExample;
import com.kentrasoft.cms.entity.dto.RecordDetails;
import com.kentrasoft.cms.port.entity.cardPortPoint.CardportPointQueryResult;
import com.kentrasoft.cms.port.entity.exitPoint.ExitpointQueryResult;
import com.kentrasoft.cms.port.entity.importPoint.ImportpointQueryResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "drivingTrackMapper")
public interface DrivingTrackMapper {
    /**
     *
     * @mbg.generated 2018-06-27
     */
    long countByExample(DrivingTrackExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int deleteByExample(DrivingTrackExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int insert(DrivingTrack record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int insertSelective(DrivingTrack record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    List<DrivingTrack> selectByExample(DrivingTrackExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    DrivingTrack selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByExampleSelective(@Param("record") DrivingTrack record, @Param("example") DrivingTrackExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByExample(@Param("record") DrivingTrack record, @Param("example") DrivingTrackExample example);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByPrimaryKeySelective(DrivingTrack record);

    /**
     *
     * @mbg.generated 2018-06-27
     */
    int updateByPrimaryKey(DrivingTrack record);

    List<RecordDetails> findByDrivingRecord(String drivingRecord);
    
    DrivingTrack selectDrivingTrackBylicenseNum(String licenseNum);
    
    //根据车牌号查询行驶轨迹
    List<DrivingTrack> queryDrivingTrackBylicenseNum(@Param("licenseNum") String licenseNum, @Param("drivingRecord") String drivingRecord);

    //根据车牌查询未结束记录
    List<DrivingTrack> queryDrivingtrackNotend(@Param("licenseNum") String licenseNum, @Param("trackStatus") String trackStatus);

    //查询5.8G设备信息
    List<String>  queryDeviceCode(@Param("GisX") String GisX, @Param("GisY") String GisY,
                                  @Param("deviceName") String DeviceName, @Param("deviceCode") String deviceCode);

    //根据车牌，出站时间查询行驶轨迹，出站口接口数据
      List<ExitpointQueryResult> queryTrackAndCard(@Param("license") String license, @Param("exitTime") String exitTime);
    //更新行驶轨迹状态
    void updatedeviceStatus(@Param("trackId") String trackId, @Param("status") String status);
    //查询led连接地址
    List<String> querylinkAddress(@Param("cardpoint") String cardpoint);


    //根据车牌、进出站时间 查已结束轨迹记录
    List<ImportpointQueryResult> queryDrivingTrack(@Param("license") String license, @Param("instationTime") String instationTime, @Param("outstationTime") String outstationTime);

    //根基trackid查询行驶轨迹
    List<ExitpointQueryResult> queryBytrackid(@Param("trackid") String trackid);


    //查询行驶轨迹数据(状态为未结束（01）)
    List<CardportPointQueryResult> cardportPointQueryResults(@Param("license") String license);

    //判断5.8G数据是否重复
    List<DrivingTrack> checkresetdata(@Param("license") String license, @Param("througthTime") String througthTime);
    
}