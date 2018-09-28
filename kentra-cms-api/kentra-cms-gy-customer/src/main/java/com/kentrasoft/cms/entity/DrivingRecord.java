package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class DrivingRecord implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 行驶记录ID
     */
    private String drivingRecord;

    /**
     * 车牌号码
     */
    private String licenseNum;

    /**
     * 车道编号
     */
    private String laneNum;

    /**
     * 进站口时间
     */
    private Date entranceTime;

    /**
     * 出站口时间
     */
    private Date exitTime;

    /**
     * 进站口名称
     */
    private String entranceName;

    /**
     * 出站口名称
     */
    private String exitName;

    /**
     * 统计时间
     */
    private Date createTime;

    /**
     * 里程
     */
    private String mileage;

    /**
     * 设备编号
     */
    private String equipmentNumber;

    /**
     * 出口经度
     */
    private String exportLongitude;

    /**
     * 出口纬度
     */
    private String exportLatitudes;

    /**
     * 入口经度
     */
    private String entranceLongitude;

    /**
     * 入口纬度
     */
    private String entranceLatitudes;

    /**
     * 进站口标识
     */
    private String instationCode;

    /**
     * 出站口标识
     */
    private String outstationCode;

    /**
     * 违规类型
     */
    private String extends1;

    /**
     * 违规备注
     */
    private String extends2;

    /**
     * 备用字段3
     */
    private String extends3;

    /**
     * 关联查询相关字段
     */
    private String receivables;
    private String payCount;
    private String expensesPaid;
    
    /**
     * driving_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 行驶记录ID
     * @return driving_record 行驶记录ID
     */
    public String getDrivingRecord() {
        return drivingRecord;
    }

    /**
     * 行驶记录ID
     * @param drivingRecord 行驶记录ID
     */
    public void setDrivingRecord(String drivingRecord) {
        this.drivingRecord = drivingRecord == null ? null : drivingRecord.trim();
    }

    /**
     * 车牌号码
     * @return license_num 车牌号码
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     * 车牌号码
     * @param licenseNum 车牌号码
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum == null ? null : licenseNum.trim();
    }

    /**
     * 车道编号
     * @return lane_num 车道编号
     */
    public String getLaneNum() {
        return laneNum;
    }

    /**
     * 车道编号
     * @param laneNum 车道编号
     */
    public void setLaneNum(String laneNum) {
        this.laneNum = laneNum == null ? null : laneNum.trim();
    }

    /**
     * 进站口时间
     * @return entrance_time 进站口时间
     */
    public Date getEntranceTime() {
        return entranceTime;
    }

    /**
     * 进站口时间
     * @param entranceTime 进站口时间
     */
    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    /**
     * 出站口时间
     * @return exit_time 出站口时间
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * 出站口时间
     * @param exitTime 出站口时间
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * 进站口名称
     * @return entrance_name 进站口名称
     */
    public String getEntranceName() {
        return entranceName;
    }

    /**
     * 进站口名称
     * @param entranceName 进站口名称
     */
    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName == null ? null : entranceName.trim();
    }

    /**
     * 出站口名称
     * @return exit_name 出站口名称
     */
    public String getExitName() {
        return exitName;
    }

    /**
     * 出站口名称
     * @param exitName 出站口名称
     */
    public void setExitName(String exitName) {
        this.exitName = exitName == null ? null : exitName.trim();
    }

    /**
     * 统计时间
     * @return create_time 统计时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 统计时间
     * @param createTime 统计时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 里程
     * @return mileage 里程
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * 里程
     * @param mileage 里程
     */
    public void setMileage(String mileage) {
        this.mileage = mileage == null ? null : mileage.trim();
    }

    /**
     * 设备编号
     * @return equipment_number 设备编号
     */
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    /**
     * 设备编号
     * @param equipmentNumber 设备编号
     */
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber == null ? null : equipmentNumber.trim();
    }

    /**
     * 出口经度
     * @return export_longitude 出口经度
     */
    public String getExportLongitude() {
        return exportLongitude;
    }

    /**
     * 出口经度
     * @param exportLongitude 出口经度
     */
    public void setExportLongitude(String exportLongitude) {
        this.exportLongitude = exportLongitude == null ? null : exportLongitude.trim();
    }

    /**
     * 出口纬度
     * @return export_latitudes 出口纬度
     */
    public String getExportLatitudes() {
        return exportLatitudes;
    }

    /**
     * 出口纬度
     * @param exportLatitudes 出口纬度
     */
    public void setExportLatitudes(String exportLatitudes) {
        this.exportLatitudes = exportLatitudes == null ? null : exportLatitudes.trim();
    }

    /**
     * 入口经度
     * @return entrance_longitude 入口经度
     */
    public String getEntranceLongitude() {
        return entranceLongitude;
    }

    /**
     * 入口经度
     * @param entranceLongitude 入口经度
     */
    public void setEntranceLongitude(String entranceLongitude) {
        this.entranceLongitude = entranceLongitude == null ? null : entranceLongitude.trim();
    }

    /**
     * 入口纬度
     * @return entrance_latitudes 入口纬度
     */
    public String getEntranceLatitudes() {
        return entranceLatitudes;
    }

    /**
     * 入口纬度
     * @param entranceLatitudes 入口纬度
     */
    public void setEntranceLatitudes(String entranceLatitudes) {
        this.entranceLatitudes = entranceLatitudes == null ? null : entranceLatitudes.trim();
    }

    /**
     * 进站口标识
     * @return instation_code 进站口标识
     */
    public String getInstationCode() {
        return instationCode;
    }

    /**
     * 进站口标识
     * @param instationCode 进站口标识
     */
    public void setInstationCode(String instationCode) {
        this.instationCode = instationCode == null ? null : instationCode.trim();
    }

    /**
     * 出站口标识
     * @return outstation_code 出站口标识
     */
    public String getOutstationCode() {
        return outstationCode;
    }

    /**
     * 出站口标识
     * @param outstationCode 出站口标识
     */
    public void setOutstationCode(String outstationCode) {
        this.outstationCode = outstationCode == null ? null : outstationCode.trim();
    }

    /**
     * 备用字段1
     * @return extends1 备用字段1
     */
    public String getExtends1() {
        return extends1;
    }

    /**
     * 备用字段1
     * @param extends1 备用字段1
     */
    public void setExtends1(String extends1) {
        this.extends1 = extends1 == null ? null : extends1.trim();
    }

    /**
     * 备用字段2
     * @return extends2 备用字段2
     */
    public String getExtends2() {
        return extends2;
    }

    /**
     * 备用字段2
     * @param extends2 备用字段2
     */
    public void setExtends2(String extends2) {
        this.extends2 = extends2 == null ? null : extends2.trim();
    }

    /**
     * 备用字段3
     * @return extends3 备用字段3
     */
    public String getExtends3() {
        return extends3;
    }

    /**
     * 备用字段3
     * @param extends3 备用字段3
     */
    public void setExtends3(String extends3) {
        this.extends3 = extends3 == null ? null : extends3.trim();
    }

	public String getReceivables() {
		return receivables;
	}

	public void setReceivables(String receivables) {
		this.receivables = receivables;
	}

	public String getPayCount() {
		return payCount;
	}

	public void setPayCount(String payCount) {
		this.payCount = payCount;
	}

	public String getExpensesPaid() {
		return expensesPaid;
	}

	public void setExpensesPaid(String expensesPaid) {
		this.expensesPaid = expensesPaid;
	}
    
}