package com.kentrasoft.cms.entity.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * 描述：行驶缴费记录表
 *
 * @author zhangmengkang
 */
public class DrivingPayRecord implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 车牌号码
     */
    private String licenseNum;

    /**
     * 行驶记录ID
     */
    private String drivingRecord;

    /**
     * 缴费类型（01：待缴费，02：已缴费，03：补缴费）
     */
    private String payStatus;

    /**
     * 是否缴费（01：完成缴费，02：未完成缴费）
     */
    private String isPay;

    /**
     * 支付日期
     */
    private Date payTime;

    /**
     * 已缴费用
     */
    private Double payCount;

    /**
     * 应缴费用
     */
    private Double receivables;

    /**
     * 补缴费用
     */
    private Double expensesPaid;

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

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getExportLongitude() {
        return exportLongitude;
    }

    public void setExportLongitude(String exportLongitude) {
        this.exportLongitude = exportLongitude;
    }

    public String getExportLatitudes() {
        return exportLatitudes;
    }

    public void setExportLatitudes(String exportLatitudes) {
        this.exportLatitudes = exportLatitudes;
    }

    public String getEntranceLongitude() {
        return entranceLongitude;
    }

    public void setEntranceLongitude(String entranceLongitude) {
        this.entranceLongitude = entranceLongitude;
    }

    public String getEntranceLatitudes() {
        return entranceLatitudes;
    }

    public void setEntranceLatitudes(String entranceLatitudes) {
        this.entranceLatitudes = entranceLatitudes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getDrivingRecord() {
        return drivingRecord;
    }

    public void setDrivingRecord(String drivingRecord) {
        this.drivingRecord = drivingRecord;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Double getPayCount() {
        return payCount;
    }

    public void setPayCount(Double payCount) {
        this.payCount = payCount;
    }

    public Double getReceivables() {
        return receivables;
    }

    public void setReceivables(Double receivables) {
        this.receivables = receivables;
    }

    public Double getExpensesPaid() {
        return expensesPaid;
    }

    public void setExpensesPaid(Double expensesPaid) {
        this.expensesPaid = expensesPaid;
    }

    public String getLaneNum() {
        return laneNum;
    }

    public void setLaneNum(String laneNum) {
        this.laneNum = laneNum;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName;
    }

    public String getExitName() {
        return exitName;
    }

    public void setExitName(String exitName) {
        this.exitName = exitName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
