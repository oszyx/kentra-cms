package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class PayRecord implements Serializable {
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
     * 进站名称
     */
    private String entranceName;

    /**
     * 进站时间
     */
    private Date entranceTime;

    /**
     * 出站名称
     */
    private String exitName;

    /**
     * 出站时间
     */
    private Date exitTime;

    /**
     * 应缴费用
     */
    private Double receivables;

    /**
     * 已缴费用
     */
    private Double payCount;

    /**
     * 补缴费用
     */
    private Double expensesPaid;

    /**
     * 缴费类型（payment_type_0：已缴费，payment_type_1：待缴费，payment_type_2：补缴费）
     */
    private String payStatus;

    /**
     * 是否缴费（payment_state_0：完成缴费，payment_state_1：未完成缴费）
     */
    private String isPay;

    /**
     * 创建日期
     */
    private Date payTime;

    /**
     * 备用字段1(缴费备注使用)
     */
    private String extends1;

    /**
     * 备用字段2
     */
    private String extends2;

    /**
     * 备用字段3
     */
    private String extends3;

    /**
     * pay_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 关联字段
     */
    String payCountstr;
    String receivablesstr;
    String expensesPaidstr;
    
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
     * 进站名称
     * @return entrance_name 进站名称
     */
    public String getEntranceName() {
        return entranceName;
    }

    /**
     * 进站名称
     * @param entranceName 进站名称
     */
    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName == null ? null : entranceName.trim();
    }

    /**
     * 进站时间
     * @return entrance_time 进站时间
     */
    public Date getEntranceTime() {
        return entranceTime;
    }

    /**
     * 进站时间
     * @param entranceTime 进站时间
     */
    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    /**
     * 出站名称
     * @return exit_name 出站名称
     */
    public String getExitName() {
        return exitName;
    }

    /**
     * 出站名称
     * @param exitName 出站名称
     */
    public void setExitName(String exitName) {
        this.exitName = exitName == null ? null : exitName.trim();
    }

    /**
     * 出站时间
     * @return exit_time 出站时间
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * 出站时间
     * @param exitTime 出站时间
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * 应缴费用
     * @return receivables 应缴费用
     */
    public Double getReceivables() {
        return receivables;
    }

    /**
     * 应缴费用
     * @param receivables 应缴费用
     */
    public void setReceivables(Double receivables) {
        this.receivables = receivables;
    }

    /**
     * 已缴费用
     * @return pay_count 已缴费用
     */
    public Double getPayCount() {
        return payCount;
    }

    /**
     * 已缴费用
     * @param payCount 已缴费用
     */
    public void setPayCount(Double payCount) {
        this.payCount = payCount;
    }

    /**
     * 补缴费用
     * @return expenses_paid 补缴费用
     */
    public Double getExpensesPaid() {
        return expensesPaid;
    }

    /**
     * 补缴费用
     * @param expensesPaid 补缴费用
     */
    public void setExpensesPaid(Double expensesPaid) {
        this.expensesPaid = expensesPaid;
    }

    /**
     * 缴费类型（payment_type_0：已缴费，payment_type_1：待缴费，payment_type_2：补缴费）
     * @return pay_status 缴费类型（payment_type_0：已缴费，payment_type_1：待缴费，payment_type_2：补缴费）
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 缴费类型（payment_type_0：已缴费，payment_type_1：待缴费，payment_type_2：补缴费）
     * @param payStatus 缴费类型（payment_type_0：已缴费，payment_type_1：待缴费，payment_type_2：补缴费）
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * 是否缴费（payment_state_0：完成缴费，payment_state_1：未完成缴费）
     * @return is_pay 是否缴费（payment_state_0：完成缴费，payment_state_1：未完成缴费）
     */
    public String getIsPay() {
        return isPay;
    }

    /**
     * 是否缴费（payment_state_0：完成缴费，payment_state_1：未完成缴费）
     * @param isPay 是否缴费（payment_state_0：完成缴费，payment_state_1：未完成缴费）
     */
    public void setIsPay(String isPay) {
        this.isPay = isPay == null ? null : isPay.trim();
    }

    /**
     * 支付日期
     * @return pay_time 支付日期
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 支付日期
     * @param payTime 支付日期
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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

	public String getPayCountstr() {
		return payCountstr;
	}

	public void setPayCountstr(String payCountstr) {
		this.payCountstr = payCountstr;
	}

	public String getReceivablesstr() {
		return receivablesstr;
	}

	public void setReceivablesstr(String receivablesstr) {
		this.receivablesstr = receivablesstr;
	}

	public String getExpensesPaidstr() {
		return expensesPaidstr;
	}

	public void setExpensesPaidstr(String expensesPaidstr) {
		this.expensesPaidstr = expensesPaidstr;
	}
    
}