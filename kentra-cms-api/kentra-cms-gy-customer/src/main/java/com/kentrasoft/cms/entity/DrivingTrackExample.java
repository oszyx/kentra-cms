package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrivingTrackExample {
    /**
     * driving_track
     */
    protected String orderByClause;

    /**
     * driving_track
     */
    protected boolean distinct;

    /**
     * driving_track
     */
    protected List<Criteria> oredCriteria;

    /**
     * driving_track
     */
    protected Integer limitStart;

    /**
     * driving_track
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public DrivingTrackExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-29
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
     * @mbg.generated 2018-06-29
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-06-29
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * driving_track 2018-06-29
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

        public Criteria andDeviceGisXIsNull() {
            addCriterion("device_gis_x is null");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXIsNotNull() {
            addCriterion("device_gis_x is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXEqualTo(String value) {
            addCriterion("device_gis_x =", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXNotEqualTo(String value) {
            addCriterion("device_gis_x <>", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXGreaterThan(String value) {
            addCriterion("device_gis_x >", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXGreaterThanOrEqualTo(String value) {
            addCriterion("device_gis_x >=", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXLessThan(String value) {
            addCriterion("device_gis_x <", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXLessThanOrEqualTo(String value) {
            addCriterion("device_gis_x <=", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXLike(String value) {
            addCriterion("device_gis_x like", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXNotLike(String value) {
            addCriterion("device_gis_x not like", value, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXIn(List<String> values) {
            addCriterion("device_gis_x in", values, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXNotIn(List<String> values) {
            addCriterion("device_gis_x not in", values, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXBetween(String value1, String value2) {
            addCriterion("device_gis_x between", value1, value2, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisXNotBetween(String value1, String value2) {
            addCriterion("device_gis_x not between", value1, value2, "deviceGisX");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYIsNull() {
            addCriterion("device_gis_y is null");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYIsNotNull() {
            addCriterion("device_gis_y is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYEqualTo(String value) {
            addCriterion("device_gis_y =", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYNotEqualTo(String value) {
            addCriterion("device_gis_y <>", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYGreaterThan(String value) {
            addCriterion("device_gis_y >", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYGreaterThanOrEqualTo(String value) {
            addCriterion("device_gis_y >=", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYLessThan(String value) {
            addCriterion("device_gis_y <", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYLessThanOrEqualTo(String value) {
            addCriterion("device_gis_y <=", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYLike(String value) {
            addCriterion("device_gis_y like", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYNotLike(String value) {
            addCriterion("device_gis_y not like", value, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYIn(List<String> values) {
            addCriterion("device_gis_y in", values, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYNotIn(List<String> values) {
            addCriterion("device_gis_y not in", values, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYBetween(String value1, String value2) {
            addCriterion("device_gis_y between", value1, value2, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andDeviceGisYNotBetween(String value1, String value2) {
            addCriterion("device_gis_y not between", value1, value2, "deviceGisY");
            return (Criteria) this;
        }

        public Criteria andThroughTimeIsNull() {
            addCriterion("through_time is null");
            return (Criteria) this;
        }

        public Criteria andThroughTimeIsNotNull() {
            addCriterion("through_time is not null");
            return (Criteria) this;
        }

        public Criteria andThroughTimeEqualTo(Date value) {
            addCriterion("through_time =", value, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeNotEqualTo(Date value) {
            addCriterion("through_time <>", value, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeGreaterThan(Date value) {
            addCriterion("through_time >", value, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("through_time >=", value, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeLessThan(Date value) {
            addCriterion("through_time <", value, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeLessThanOrEqualTo(Date value) {
            addCriterion("through_time <=", value, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeIn(List<Date> values) {
            addCriterion("through_time in", values, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeNotIn(List<Date> values) {
            addCriterion("through_time not in", values, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeBetween(Date value1, Date value2) {
            addCriterion("through_time between", value1, value2, "throughTime");
            return (Criteria) this;
        }

        public Criteria andThroughTimeNotBetween(Date value1, Date value2) {
            addCriterion("through_time not between", value1, value2, "throughTime");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNull() {
            addCriterion("device_address is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIsNotNull() {
            addCriterion("device_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressEqualTo(String value) {
            addCriterion("device_address =", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotEqualTo(String value) {
            addCriterion("device_address <>", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThan(String value) {
            addCriterion("device_address >", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("device_address >=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThan(String value) {
            addCriterion("device_address <", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLessThanOrEqualTo(String value) {
            addCriterion("device_address <=", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressLike(String value) {
            addCriterion("device_address like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotLike(String value) {
            addCriterion("device_address not like", value, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressIn(List<String> values) {
            addCriterion("device_address in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotIn(List<String> values) {
            addCriterion("device_address not in", values, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressBetween(String value1, String value2) {
            addCriterion("device_address between", value1, value2, "deviceAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceAddressNotBetween(String value1, String value2) {
            addCriterion("device_address not between", value1, value2, "deviceAddress");
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
    }

    /**
     * driving_track
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * driving_track 2018-06-29
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