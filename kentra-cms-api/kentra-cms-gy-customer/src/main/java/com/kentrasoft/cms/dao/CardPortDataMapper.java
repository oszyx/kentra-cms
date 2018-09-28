package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.CardPortData;
import com.kentrasoft.cms.port.entity.cardPortPoint.CardportPointQueryResult;
import com.kentrasoft.cms.port.entity.importPoint.ImportpointQueryResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "cardPortDataMapper")
public interface CardPortDataMapper {

    List<CardPortData> findByDrivingRecord(String drivingRecord);
    
    //根据车牌查询未结束行程
    List<CardPortData> queryCardportdataNotend(@Param("license") String license, @Param("status") String status);

    //根据车牌，出站时间查询卡口数据，出站口接口数据


    //更新卡口数据状态，已结束行程
    void updatecardportStatus(@Param("trackId") String trackId, @Param("status") String status);

    //存储卡口数据
    int insert(CardPortData cardPortData);

    //根据车牌、进出站时间查询 卡口数据
    List<ImportpointQueryResult> queryCardPort(@Param("license") String licens, @Param("instationTime") String instationTime, @Param("outstationTime") String outstationTime);

    //查询卡口数据(状态为未结束（01）)
    List<CardportPointQueryResult> pointQueryResults(@Param("license") String license);

    //根据车牌号、行驶记录ID查询卡口图片
    List<CardPortData> getCardPortIllegalImages(@Param("licenseNum") String licenseNum, @Param("drivingRecord") String drivingRecord);
}