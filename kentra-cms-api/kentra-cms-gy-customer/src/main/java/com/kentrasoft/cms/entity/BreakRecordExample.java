package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BreakRecordExample {
    /**
     * break_record
     */
    protected String orderByClause;

    /**
     * break_record
     */
    protected boolean distinct;

    /**
     * break_record
     */
    protected List<Criteria> oredCriteria;

    /**
     * break_record
     */
    protected Integer limitStart;

    /**
     * break_record
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public BreakRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-06-14
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * break_record 2018-06-14
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordIsNull() {
            addCriterion("driving_record is null");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordIsNotNull() {
            addCriterion("driving_record is not null");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordEqualTo(String value) {
            addCriterion("driving_record =", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordNotEqualTo(String value) {
            addCriterion("driving_record <>", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordGreaterThan(String value) {
            addCriterion("driving_record >", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordGreaterThanOrEqualTo(String value) {
            addCriterion("driving_record >=", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordLessThan(String value) {
            addCriterion("driving_record <", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordLessThanOrEqualTo(String value) {
            addCriterion("driving_record <=", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordLike(String value) {
            addCriterion("driving_record like", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordNotLike(String value) {
            addCriterion("driving_record not like", value, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordIn(List<String> values) {
            addCriterion("driving_record in", values, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordNotIn(List<String> values) {
            addCriterion("driving_record not in", values, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordBetween(String value1, String value2) {
            addCriterion("driving_record between", value1, value2, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andDrivingRecordNotBetween(String value1, String value2) {
            addCriterion("driving_record not between", value1, value2, "drivingRecord");
            return (Criteria) this;
        }

        public Criteria andLicenseNumIsNull() {
            addCriterion("license_num is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNumIsNotNull() {
            addCriterion("license_num is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNumEqualTo(String value) {
            addCriterion("license_num =", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumNotEqualTo(String value) {
            addCriterion("license_num <>", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumGreaterThan(String value) {
            addCriterion("license_num >", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumGreaterThanOrEqualTo(String value) {
            addCriterion("license_num >=", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumLessThan(String value) {
            addCriterion("license_num <", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumLessThanOrEqualTo(String value) {
            addCriterion("license_num <=", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumLike(String value) {
            addCriterion("license_num like", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumNotLike(String value) {
            addCriterion("license_num not like", value, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumIn(List<String> values) {
            addCriterion("license_num in", values, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumNotIn(List<String> values) {
            addCriterion("license_num not in", values, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumBetween(String value1, String value2) {
            addCriterion("license_num between", value1, value2, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andLicenseNumNotBetween(String value1, String value2) {
            addCriterion("license_num not between", value1, value2, "licenseNum");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeIsNull() {
            addCriterion("entrance_time is null");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeIsNotNull() {
            addCriterion("entrance_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeEqualTo(Date value) {
            addCriterion("entrance_time =", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeNotEqualTo(Date value) {
            addCriterion("entrance_time <>", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeGreaterThan(Date value) {
            addCriterion("entrance_time >", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("entrance_time >=", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeLessThan(Date value) {
            addCriterion("entrance_time <", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeLessThanOrEqualTo(Date value) {
            addCriterion("entrance_time <=", value, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeIn(List<Date> values) {
            addCriterion("entrance_time in", values, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeNotIn(List<Date> values) {
            addCriterion("entrance_time not in", values, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeBetween(Date value1, Date value2) {
            addCriterion("entrance_time between", value1, value2, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andEntranceTimeNotBetween(Date value1, Date value2) {
            addCriterion("entrance_time not between", value1, value2, "entranceTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeIsNull() {
            addCriterion("exit_time is null");
            return (Criteria) this;
        }

        public Criteria andExitTimeIsNotNull() {
            addCriterion("exit_time is not null");
            return (Criteria) this;
        }

        public Criteria andExitTimeEqualTo(Date value) {
            addCriterion("exit_time =", value, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeNotEqualTo(Date value) {
            addCriterion("exit_time <>", value, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeGreaterThan(Date value) {
            addCriterion("exit_time >", value, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("exit_time >=", value, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeLessThan(Date value) {
            addCriterion("exit_time <", value, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeLessThanOrEqualTo(Date value) {
            addCriterion("exit_time <=", value, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeIn(List<Date> values) {
            addCriterion("exit_time in", values, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeNotIn(List<Date> values) {
            addCriterion("exit_time not in", values, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeBetween(Date value1, Date value2) {
            addCriterion("exit_time between", value1, value2, "exitTime");
            return (Criteria) this;
        }

        public Criteria andExitTimeNotBetween(Date value1, Date value2) {
            addCriterion("exit_time not between", value1, value2, "exitTime");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIsNull() {
            addCriterion("entrance_name is null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIsNotNull() {
            addCriterion("entrance_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameEqualTo(String value) {
            addCriterion("entrance_name =", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotEqualTo(String value) {
            addCriterion("entrance_name <>", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameGreaterThan(String value) {
            addCriterion("entrance_name >", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameGreaterThanOrEqualTo(String value) {
            addCriterion("entrance_name >=", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLessThan(String value) {
            addCriterion("entrance_name <", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLessThanOrEqualTo(String value) {
            addCriterion("entrance_name <=", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLike(String value) {
            addCriterion("entrance_name like", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotLike(String value) {
            addCriterion("entrance_name not like", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIn(List<String> values) {
            addCriterion("entrance_name in", values, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotIn(List<String> values) {
            addCriterion("entrance_name not in", values, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameBetween(String value1, String value2) {
            addCriterion("entrance_name between", value1, value2, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotBetween(String value1, String value2) {
            addCriterion("entrance_name not between", value1, value2, "entranceName");
            return (Criteria) this;
        }

        public Criteria andExitNameIsNull() {
            addCriterion("exit_name is null");
            return (Criteria) this;
        }

        public Criteria andExitNameIsNotNull() {
            addCriterion("exit_name is not null");
            return (Criteria) this;
        }

        public Criteria andExitNameEqualTo(String value) {
            addCriterion("exit_name =", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameNotEqualTo(String value) {
            addCriterion("exit_name <>", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameGreaterThan(String value) {
            addCriterion("exit_name >", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameGreaterThanOrEqualTo(String value) {
            addCriterion("exit_name >=", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameLessThan(String value) {
            addCriterion("exit_name <", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameLessThanOrEqualTo(String value) {
            addCriterion("exit_name <=", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameLike(String value) {
            addCriterion("exit_name like", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameNotLike(String value) {
            addCriterion("exit_name not like", value, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameIn(List<String> values) {
            addCriterion("exit_name in", values, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameNotIn(List<String> values) {
            addCriterion("exit_name not in", values, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameBetween(String value1, String value2) {
            addCriterion("exit_name between", value1, value2, "exitName");
            return (Criteria) this;
        }

        public Criteria andExitNameNotBetween(String value1, String value2) {
            addCriterion("exit_name not between", value1, value2, "exitName");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(String value) {
            addCriterion("pay_money =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(String value) {
            addCriterion("pay_money <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(String value) {
            addCriterion("pay_money >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("pay_money >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(String value) {
            addCriterion("pay_money <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(String value) {
            addCriterion("pay_money <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLike(String value) {
            addCriterion("pay_money like", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotLike(String value) {
            addCriterion("pay_money not like", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<String> values) {
            addCriterion("pay_money in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<String> values) {
            addCriterion("pay_money not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(String value1, String value2) {
            addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(String value1, String value2) {
            addCriterion("pay_money not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeIsNull() {
            addCriterion("remake_type is null");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeIsNotNull() {
            addCriterion("remake_type is not null");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeEqualTo(String value) {
            addCriterion("remake_type =", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeNotEqualTo(String value) {
            addCriterion("remake_type <>", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeGreaterThan(String value) {
            addCriterion("remake_type >", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("remake_type >=", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeLessThan(String value) {
            addCriterion("remake_type <", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeLessThanOrEqualTo(String value) {
            addCriterion("remake_type <=", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeLike(String value) {
            addCriterion("remake_type like", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeNotLike(String value) {
            addCriterion("remake_type not like", value, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeIn(List<String> values) {
            addCriterion("remake_type in", values, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeNotIn(List<String> values) {
            addCriterion("remake_type not in", values, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeBetween(String value1, String value2) {
            addCriterion("remake_type between", value1, value2, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeTypeNotBetween(String value1, String value2) {
            addCriterion("remake_type not between", value1, value2, "remakeType");
            return (Criteria) this;
        }

        public Criteria andRemakeContentIsNull() {
            addCriterion("remake_content is null");
            return (Criteria) this;
        }

        public Criteria andRemakeContentIsNotNull() {
            addCriterion("remake_content is not null");
            return (Criteria) this;
        }

        public Criteria andRemakeContentEqualTo(String value) {
            addCriterion("remake_content =", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentNotEqualTo(String value) {
            addCriterion("remake_content <>", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentGreaterThan(String value) {
            addCriterion("remake_content >", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentGreaterThanOrEqualTo(String value) {
            addCriterion("remake_content >=", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentLessThan(String value) {
            addCriterion("remake_content <", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentLessThanOrEqualTo(String value) {
            addCriterion("remake_content <=", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentLike(String value) {
            addCriterion("remake_content like", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentNotLike(String value) {
            addCriterion("remake_content not like", value, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentIn(List<String> values) {
            addCriterion("remake_content in", values, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentNotIn(List<String> values) {
            addCriterion("remake_content not in", values, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentBetween(String value1, String value2) {
            addCriterion("remake_content between", value1, value2, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andRemakeContentNotBetween(String value1, String value2) {
            addCriterion("remake_content not between", value1, value2, "remakeContent");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExtends1IsNull() {
            addCriterion("extends1 is null");
            return (Criteria) this;
        }

        public Criteria andExtends1IsNotNull() {
            addCriterion("extends1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtends1EqualTo(String value) {
            addCriterion("extends1 =", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1NotEqualTo(String value) {
            addCriterion("extends1 <>", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1GreaterThan(String value) {
            addCriterion("extends1 >", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1GreaterThanOrEqualTo(String value) {
            addCriterion("extends1 >=", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1LessThan(String value) {
            addCriterion("extends1 <", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1LessThanOrEqualTo(String value) {
            addCriterion("extends1 <=", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1Like(String value) {
            addCriterion("extends1 like", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1NotLike(String value) {
            addCriterion("extends1 not like", value, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1In(List<String> values) {
            addCriterion("extends1 in", values, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1NotIn(List<String> values) {
            addCriterion("extends1 not in", values, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1Between(String value1, String value2) {
            addCriterion("extends1 between", value1, value2, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends1NotBetween(String value1, String value2) {
            addCriterion("extends1 not between", value1, value2, "extends1");
            return (Criteria) this;
        }

        public Criteria andExtends2IsNull() {
            addCriterion("extends2 is null");
            return (Criteria) this;
        }

        public Criteria andExtends2IsNotNull() {
            addCriterion("extends2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtends2EqualTo(String value) {
            addCriterion("extends2 =", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2NotEqualTo(String value) {
            addCriterion("extends2 <>", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2GreaterThan(String value) {
            addCriterion("extends2 >", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2GreaterThanOrEqualTo(String value) {
            addCriterion("extends2 >=", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2LessThan(String value) {
            addCriterion("extends2 <", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2LessThanOrEqualTo(String value) {
            addCriterion("extends2 <=", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2Like(String value) {
            addCriterion("extends2 like", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2NotLike(String value) {
            addCriterion("extends2 not like", value, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2In(List<String> values) {
            addCriterion("extends2 in", values, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2NotIn(List<String> values) {
            addCriterion("extends2 not in", values, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2Between(String value1, String value2) {
            addCriterion("extends2 between", value1, value2, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends2NotBetween(String value1, String value2) {
            addCriterion("extends2 not between", value1, value2, "extends2");
            return (Criteria) this;
        }

        public Criteria andExtends3IsNull() {
            addCriterion("extends3 is null");
            return (Criteria) this;
        }

        public Criteria andExtends3IsNotNull() {
            addCriterion("extends3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtends3EqualTo(String value) {
            addCriterion("extends3 =", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3NotEqualTo(String value) {
            addCriterion("extends3 <>", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3GreaterThan(String value) {
            addCriterion("extends3 >", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3GreaterThanOrEqualTo(String value) {
            addCriterion("extends3 >=", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3LessThan(String value) {
            addCriterion("extends3 <", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3LessThanOrEqualTo(String value) {
            addCriterion("extends3 <=", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3Like(String value) {
            addCriterion("extends3 like", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3NotLike(String value) {
            addCriterion("extends3 not like", value, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3In(List<String> values) {
            addCriterion("extends3 in", values, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3NotIn(List<String> values) {
            addCriterion("extends3 not in", values, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3Between(String value1, String value2) {
            addCriterion("extends3 between", value1, value2, "extends3");
            return (Criteria) this;
        }

        public Criteria andExtends3NotBetween(String value1, String value2) {
            addCriterion("extends3 not between", value1, value2, "extends3");
            return (Criteria) this;
        }
    }

    /**
     * break_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * break_record 2018-06-14
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}