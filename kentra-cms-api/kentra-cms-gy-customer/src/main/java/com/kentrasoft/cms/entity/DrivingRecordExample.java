package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrivingRecordExample {
    /**
     * driving_record
     */
    protected String orderByClause;

    /**
     * driving_record
     */
    protected boolean distinct;

    /**
     * driving_record
     */
    protected List<Criteria> oredCriteria;

    /**
     * driving_record
     */
    protected Integer limitStart;

    /**
     * driving_record
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public DrivingRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-07-10
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
     * @mbg.generated 2018-07-10
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-07-10
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * driving_record 2018-07-10
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

        public Criteria andLaneNumIsNull() {
            addCriterion("lane_num is null");
            return (Criteria) this;
        }

        public Criteria andLaneNumIsNotNull() {
            addCriterion("lane_num is not null");
            return (Criteria) this;
        }

        public Criteria andLaneNumEqualTo(String value) {
            addCriterion("lane_num =", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumNotEqualTo(String value) {
            addCriterion("lane_num <>", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumGreaterThan(String value) {
            addCriterion("lane_num >", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumGreaterThanOrEqualTo(String value) {
            addCriterion("lane_num >=", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumLessThan(String value) {
            addCriterion("lane_num <", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumLessThanOrEqualTo(String value) {
            addCriterion("lane_num <=", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumLike(String value) {
            addCriterion("lane_num like", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumNotLike(String value) {
            addCriterion("lane_num not like", value, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumIn(List<String> values) {
            addCriterion("lane_num in", values, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumNotIn(List<String> values) {
            addCriterion("lane_num not in", values, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumBetween(String value1, String value2) {
            addCriterion("lane_num between", value1, value2, "laneNum");
            return (Criteria) this;
        }

        public Criteria andLaneNumNotBetween(String value1, String value2) {
            addCriterion("lane_num not between", value1, value2, "laneNum");
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

        public Criteria andMileageIsNull() {
            addCriterion("mileage is null");
            return (Criteria) this;
        }

        public Criteria andMileageIsNotNull() {
            addCriterion("mileage is not null");
            return (Criteria) this;
        }

        public Criteria andMileageEqualTo(String value) {
            addCriterion("mileage =", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotEqualTo(String value) {
            addCriterion("mileage <>", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThan(String value) {
            addCriterion("mileage >", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThanOrEqualTo(String value) {
            addCriterion("mileage >=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThan(String value) {
            addCriterion("mileage <", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThanOrEqualTo(String value) {
            addCriterion("mileage <=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLike(String value) {
            addCriterion("mileage like", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotLike(String value) {
            addCriterion("mileage not like", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageIn(List<String> values) {
            addCriterion("mileage in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotIn(List<String> values) {
            addCriterion("mileage not in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageBetween(String value1, String value2) {
            addCriterion("mileage between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotBetween(String value1, String value2) {
            addCriterion("mileage not between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberIsNull() {
            addCriterion("equipment_number is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberIsNotNull() {
            addCriterion("equipment_number is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberEqualTo(String value) {
            addCriterion("equipment_number =", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotEqualTo(String value) {
            addCriterion("equipment_number <>", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberGreaterThan(String value) {
            addCriterion("equipment_number >", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_number >=", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLessThan(String value) {
            addCriterion("equipment_number <", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLessThanOrEqualTo(String value) {
            addCriterion("equipment_number <=", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLike(String value) {
            addCriterion("equipment_number like", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotLike(String value) {
            addCriterion("equipment_number not like", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberIn(List<String> values) {
            addCriterion("equipment_number in", values, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotIn(List<String> values) {
            addCriterion("equipment_number not in", values, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberBetween(String value1, String value2) {
            addCriterion("equipment_number between", value1, value2, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberNotBetween(String value1, String value2) {
            addCriterion("equipment_number not between", value1, value2, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeIsNull() {
            addCriterion("export_longitude is null");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeIsNotNull() {
            addCriterion("export_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeEqualTo(String value) {
            addCriterion("export_longitude =", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeNotEqualTo(String value) {
            addCriterion("export_longitude <>", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeGreaterThan(String value) {
            addCriterion("export_longitude >", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("export_longitude >=", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeLessThan(String value) {
            addCriterion("export_longitude <", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeLessThanOrEqualTo(String value) {
            addCriterion("export_longitude <=", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeLike(String value) {
            addCriterion("export_longitude like", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeNotLike(String value) {
            addCriterion("export_longitude not like", value, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeIn(List<String> values) {
            addCriterion("export_longitude in", values, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeNotIn(List<String> values) {
            addCriterion("export_longitude not in", values, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeBetween(String value1, String value2) {
            addCriterion("export_longitude between", value1, value2, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLongitudeNotBetween(String value1, String value2) {
            addCriterion("export_longitude not between", value1, value2, "exportLongitude");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesIsNull() {
            addCriterion("export_latitudes is null");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesIsNotNull() {
            addCriterion("export_latitudes is not null");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesEqualTo(String value) {
            addCriterion("export_latitudes =", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesNotEqualTo(String value) {
            addCriterion("export_latitudes <>", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesGreaterThan(String value) {
            addCriterion("export_latitudes >", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesGreaterThanOrEqualTo(String value) {
            addCriterion("export_latitudes >=", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesLessThan(String value) {
            addCriterion("export_latitudes <", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesLessThanOrEqualTo(String value) {
            addCriterion("export_latitudes <=", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesLike(String value) {
            addCriterion("export_latitudes like", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesNotLike(String value) {
            addCriterion("export_latitudes not like", value, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesIn(List<String> values) {
            addCriterion("export_latitudes in", values, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesNotIn(List<String> values) {
            addCriterion("export_latitudes not in", values, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesBetween(String value1, String value2) {
            addCriterion("export_latitudes between", value1, value2, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andExportLatitudesNotBetween(String value1, String value2) {
            addCriterion("export_latitudes not between", value1, value2, "exportLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeIsNull() {
            addCriterion("entrance_longitude is null");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeIsNotNull() {
            addCriterion("entrance_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeEqualTo(String value) {
            addCriterion("entrance_longitude =", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeNotEqualTo(String value) {
            addCriterion("entrance_longitude <>", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeGreaterThan(String value) {
            addCriterion("entrance_longitude >", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("entrance_longitude >=", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeLessThan(String value) {
            addCriterion("entrance_longitude <", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeLessThanOrEqualTo(String value) {
            addCriterion("entrance_longitude <=", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeLike(String value) {
            addCriterion("entrance_longitude like", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeNotLike(String value) {
            addCriterion("entrance_longitude not like", value, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeIn(List<String> values) {
            addCriterion("entrance_longitude in", values, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeNotIn(List<String> values) {
            addCriterion("entrance_longitude not in", values, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeBetween(String value1, String value2) {
            addCriterion("entrance_longitude between", value1, value2, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLongitudeNotBetween(String value1, String value2) {
            addCriterion("entrance_longitude not between", value1, value2, "entranceLongitude");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesIsNull() {
            addCriterion("entrance_latitudes is null");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesIsNotNull() {
            addCriterion("entrance_latitudes is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesEqualTo(String value) {
            addCriterion("entrance_latitudes =", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesNotEqualTo(String value) {
            addCriterion("entrance_latitudes <>", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesGreaterThan(String value) {
            addCriterion("entrance_latitudes >", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesGreaterThanOrEqualTo(String value) {
            addCriterion("entrance_latitudes >=", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesLessThan(String value) {
            addCriterion("entrance_latitudes <", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesLessThanOrEqualTo(String value) {
            addCriterion("entrance_latitudes <=", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesLike(String value) {
            addCriterion("entrance_latitudes like", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesNotLike(String value) {
            addCriterion("entrance_latitudes not like", value, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesIn(List<String> values) {
            addCriterion("entrance_latitudes in", values, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesNotIn(List<String> values) {
            addCriterion("entrance_latitudes not in", values, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesBetween(String value1, String value2) {
            addCriterion("entrance_latitudes between", value1, value2, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andEntranceLatitudesNotBetween(String value1, String value2) {
            addCriterion("entrance_latitudes not between", value1, value2, "entranceLatitudes");
            return (Criteria) this;
        }

        public Criteria andInstationCodeIsNull() {
            addCriterion("instation_code is null");
            return (Criteria) this;
        }

        public Criteria andInstationCodeIsNotNull() {
            addCriterion("instation_code is not null");
            return (Criteria) this;
        }

        public Criteria andInstationCodeEqualTo(String value) {
            addCriterion("instation_code =", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeNotEqualTo(String value) {
            addCriterion("instation_code <>", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeGreaterThan(String value) {
            addCriterion("instation_code >", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("instation_code >=", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeLessThan(String value) {
            addCriterion("instation_code <", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeLessThanOrEqualTo(String value) {
            addCriterion("instation_code <=", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeLike(String value) {
            addCriterion("instation_code like", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeNotLike(String value) {
            addCriterion("instation_code not like", value, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeIn(List<String> values) {
            addCriterion("instation_code in", values, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeNotIn(List<String> values) {
            addCriterion("instation_code not in", values, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeBetween(String value1, String value2) {
            addCriterion("instation_code between", value1, value2, "instationCode");
            return (Criteria) this;
        }

        public Criteria andInstationCodeNotBetween(String value1, String value2) {
            addCriterion("instation_code not between", value1, value2, "instationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeIsNull() {
            addCriterion("outstation_code is null");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeIsNotNull() {
            addCriterion("outstation_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeEqualTo(String value) {
            addCriterion("outstation_code =", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeNotEqualTo(String value) {
            addCriterion("outstation_code <>", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeGreaterThan(String value) {
            addCriterion("outstation_code >", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("outstation_code >=", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeLessThan(String value) {
            addCriterion("outstation_code <", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeLessThanOrEqualTo(String value) {
            addCriterion("outstation_code <=", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeLike(String value) {
            addCriterion("outstation_code like", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeNotLike(String value) {
            addCriterion("outstation_code not like", value, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeIn(List<String> values) {
            addCriterion("outstation_code in", values, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeNotIn(List<String> values) {
            addCriterion("outstation_code not in", values, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeBetween(String value1, String value2) {
            addCriterion("outstation_code between", value1, value2, "outstationCode");
            return (Criteria) this;
        }

        public Criteria andOutstationCodeNotBetween(String value1, String value2) {
            addCriterion("outstation_code not between", value1, value2, "outstationCode");
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
     * driving_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * driving_record 2018-07-10
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