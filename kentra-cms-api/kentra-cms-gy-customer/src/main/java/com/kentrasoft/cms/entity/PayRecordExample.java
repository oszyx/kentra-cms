package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayRecordExample {
    /**
     * pay_record
     */
    protected String orderByClause;

    /**
     * pay_record
     */
    protected boolean distinct;

    /**
     * pay_record
     */
    protected List<Criteria> oredCriteria;

    /**
     * pay_record
     */
    protected Integer limitStart;

    /**
     * pay_record
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public PayRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-08-10
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
     * @mbg.generated 2018-08-10
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-08-10
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * pay_record 2018-08-10
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

        public Criteria andReceivablesIsNull() {
            addCriterion("receivables is null");
            return (Criteria) this;
        }

        public Criteria andReceivablesIsNotNull() {
            addCriterion("receivables is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablesEqualTo(Double value) {
            addCriterion("receivables =", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotEqualTo(Double value) {
            addCriterion("receivables <>", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesGreaterThan(Double value) {
            addCriterion("receivables >", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesGreaterThanOrEqualTo(Double value) {
            addCriterion("receivables >=", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLessThan(Double value) {
            addCriterion("receivables <", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesLessThanOrEqualTo(Double value) {
            addCriterion("receivables <=", value, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesIn(List<Double> values) {
            addCriterion("receivables in", values, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotIn(List<Double> values) {
            addCriterion("receivables not in", values, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesBetween(Double value1, Double value2) {
            addCriterion("receivables between", value1, value2, "receivables");
            return (Criteria) this;
        }

        public Criteria andReceivablesNotBetween(Double value1, Double value2) {
            addCriterion("receivables not between", value1, value2, "receivables");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNull() {
            addCriterion("pay_count is null");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNotNull() {
            addCriterion("pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andPayCountEqualTo(Double value) {
            addCriterion("pay_count =", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotEqualTo(Double value) {
            addCriterion("pay_count <>", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThan(Double value) {
            addCriterion("pay_count >", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThanOrEqualTo(Double value) {
            addCriterion("pay_count >=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThan(Double value) {
            addCriterion("pay_count <", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThanOrEqualTo(Double value) {
            addCriterion("pay_count <=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountIn(List<Double> values) {
            addCriterion("pay_count in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotIn(List<Double> values) {
            addCriterion("pay_count not in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountBetween(Double value1, Double value2) {
            addCriterion("pay_count between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotBetween(Double value1, Double value2) {
            addCriterion("pay_count not between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidIsNull() {
            addCriterion("expenses_paid is null");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidIsNotNull() {
            addCriterion("expenses_paid is not null");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidEqualTo(Double value) {
            addCriterion("expenses_paid =", value, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidNotEqualTo(Double value) {
            addCriterion("expenses_paid <>", value, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidGreaterThan(Double value) {
            addCriterion("expenses_paid >", value, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidGreaterThanOrEqualTo(Double value) {
            addCriterion("expenses_paid >=", value, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidLessThan(Double value) {
            addCriterion("expenses_paid <", value, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidLessThanOrEqualTo(Double value) {
            addCriterion("expenses_paid <=", value, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidIn(List<Double> values) {
            addCriterion("expenses_paid in", values, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidNotIn(List<Double> values) {
            addCriterion("expenses_paid not in", values, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidBetween(Double value1, Double value2) {
            addCriterion("expenses_paid between", value1, value2, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andExpensesPaidNotBetween(Double value1, Double value2) {
            addCriterion("expenses_paid not between", value1, value2, "expensesPaid");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(String value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(String value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(String value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(String value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(String value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(String value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLike(String value) {
            addCriterion("is_pay like", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotLike(String value) {
            addCriterion("is_pay not like", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<String> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<String> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(String value1, String value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(String value1, String value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
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
     * pay_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * pay_record 2018-08-10
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