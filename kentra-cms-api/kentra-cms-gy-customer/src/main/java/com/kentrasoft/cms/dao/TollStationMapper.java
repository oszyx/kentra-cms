package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.TollStation;
import com.kentrasoft.cms.entity.TollStationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("tollStationMapper")
public interface TollStationMapper {
	
	/**
	 * 查询站口GIS坐标
	 *author:赵参谋
	 * @param stationname
	 * @param stationcode
	 * @return
	 */
	TollStation querytollstationbycode(@Param("stationname") String stationname, @Param("stationcode") String stationcode);

	/**
	 * 查询车道数据
	 */
	List<TollStation> querytollstations(@Param("tollStationCode") String tollStationCode);

	/**
	 * 根据进出站口标识查询进出站口经纬度信息
	 */
	List<TollStation> queryinstationCode(@Param("instationName") String instationName, @Param("instationCode") String instationCode);

	List<TollStation> queryoutstationCode(@Param("outstationName") String outstationName, @Param("outstationCode") String outstationCode);

	/**
    *
    * @mbg.generated 2018-07-12
    */
   long countByExample(TollStationExample example);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int deleteByExample(TollStationExample example);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int deleteByPrimaryKey(String id);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int insert(TollStation record);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int insertSelective(TollStation record);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   List<TollStation> selectByExample(TollStationExample example);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   TollStation selectByPrimaryKey(Integer id);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int updateByExampleSelective(@Param("record") TollStation record, @Param("example") TollStationExample example);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int updateByExample(@Param("record") TollStation record, @Param("example") TollStationExample example);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int updateByPrimaryKeySelective(TollStation record);

   /**
    *
    * @mbg.generated 2018-07-12
    */
   int updateByPrimaryKey(TollStation record);
}
