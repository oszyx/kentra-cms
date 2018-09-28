package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrivingLicenseExample {
    /**
     * driving_license
     */
    protected String orderByClause;

    /**
     * driving_license
     */
    protected boolean distinct;

    /**
     * driving_license
     */
    protected List<Criteria> oredCriteria;

    /**
     * driving_license
     */
    protected Integer limitStart;

    /**
     * driving_license
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public DrivingLicenseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-13
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
     * @mbg.generated 2018-06-13
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * driving_license 2018-06-13
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIsNull() {
            addCriterion("customer_level is null");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIsNotNull() {
            addCriterion("customer_level is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelEqualTo(String value) {
            addCriterion("customer_level =", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotEqualTo(String value) {
            addCriterion("customer_level <>", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelGreaterThan(String value) {
            addCriterion("customer_level >", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelGreaterThanOrEqualTo(String value) {
            addCriterion("customer_level >=", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLessThan(String value) {
            addCriterion("customer_level <", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLessThanOrEqualTo(String value) {
            addCriterion("customer_level <=", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLike(String value) {
            addCriterion("customer_level like", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotLike(String value) {
            addCriterion("customer_level not like", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIn(List<String> values) {
            addCriterion("customer_level in", values, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotIn(List<String> values) {
            addCriterion("customer_level not in", values, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelBetween(String value1, String value2) {
            addCriterion("customer_level between", value1, value2, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotBetween(String value1, String value2) {
            addCriterion("customer_level not between", value1, value2, "customerLevel");
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

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("`owner` is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("`owner` is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("`owner` =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("`owner` <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("`owner` >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("`owner` >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("`owner` <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("`owner` <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("`owner` like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("`owner` not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("`owner` in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("`owner` not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("`owner` between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("`owner` not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNull() {
            addCriterion("house_address is null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIsNotNull() {
            addCriterion("house_address is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAddressEqualTo(String value) {
            addCriterion("house_address =", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotEqualTo(String value) {
            addCriterion("house_address <>", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThan(String value) {
            addCriterion("house_address >", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressGreaterThanOrEqualTo(String value) {
            addCriterion("house_address >=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThan(String value) {
            addCriterion("house_address <", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLessThanOrEqualTo(String value) {
            addCriterion("house_address <=", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressLike(String value) {
            addCriterion("house_address like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotLike(String value) {
            addCriterion("house_address not like", value, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressIn(List<String> values) {
            addCriterion("house_address in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotIn(List<String> values) {
            addCriterion("house_address not in", values, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressBetween(String value1, String value2) {
            addCriterion("house_address between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andHouseAddressNotBetween(String value1, String value2) {
            addCriterion("house_address not between", value1, value2, "houseAddress");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeIsNull() {
            addCriterion("car_usetype is null");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeIsNotNull() {
            addCriterion("car_usetype is not null");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeEqualTo(String value) {
            addCriterion("car_usetype =", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeNotEqualTo(String value) {
            addCriterion("car_usetype <>", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeGreaterThan(String value) {
            addCriterion("car_usetype >", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_usetype >=", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeLessThan(String value) {
            addCriterion("car_usetype <", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeLessThanOrEqualTo(String value) {
            addCriterion("car_usetype <=", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeLike(String value) {
            addCriterion("car_usetype like", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeNotLike(String value) {
            addCriterion("car_usetype not like", value, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeIn(List<String> values) {
            addCriterion("car_usetype in", values, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeNotIn(List<String> values) {
            addCriterion("car_usetype not in", values, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeBetween(String value1, String value2) {
            addCriterion("car_usetype between", value1, value2, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarUsetypeNotBetween(String value1, String value2) {
            addCriterion("car_usetype not between", value1, value2, "carUsetype");
            return (Criteria) this;
        }

        public Criteria andCarVehicleIsNull() {
            addCriterion("car_vehicle is null");
            return (Criteria) this;
        }

        public Criteria andCarVehicleIsNotNull() {
            addCriterion("car_vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andCarVehicleEqualTo(String value) {
            addCriterion("car_vehicle =", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleNotEqualTo(String value) {
            addCriterion("car_vehicle <>", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleGreaterThan(String value) {
            addCriterion("car_vehicle >", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("car_vehicle >=", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleLessThan(String value) {
            addCriterion("car_vehicle <", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleLessThanOrEqualTo(String value) {
            addCriterion("car_vehicle <=", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleLike(String value) {
            addCriterion("car_vehicle like", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleNotLike(String value) {
            addCriterion("car_vehicle not like", value, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleIn(List<String> values) {
            addCriterion("car_vehicle in", values, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleNotIn(List<String> values) {
            addCriterion("car_vehicle not in", values, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleBetween(String value1, String value2) {
            addCriterion("car_vehicle between", value1, value2, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarVehicleNotBetween(String value1, String value2) {
            addCriterion("car_vehicle not between", value1, value2, "carVehicle");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeIsNull() {
            addCriterion("car_indetcode is null");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeIsNotNull() {
            addCriterion("car_indetcode is not null");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeEqualTo(String value) {
            addCriterion("car_indetcode =", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeNotEqualTo(String value) {
            addCriterion("car_indetcode <>", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeGreaterThan(String value) {
            addCriterion("car_indetcode >", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("car_indetcode >=", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeLessThan(String value) {
            addCriterion("car_indetcode <", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeLessThanOrEqualTo(String value) {
            addCriterion("car_indetcode <=", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeLike(String value) {
            addCriterion("car_indetcode like", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeNotLike(String value) {
            addCriterion("car_indetcode not like", value, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeIn(List<String> values) {
            addCriterion("car_indetcode in", values, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeNotIn(List<String> values) {
            addCriterion("car_indetcode not in", values, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeBetween(String value1, String value2) {
            addCriterion("car_indetcode between", value1, value2, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarIndetcodeNotBetween(String value1, String value2) {
            addCriterion("car_indetcode not between", value1, value2, "carIndetcode");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberIsNull() {
            addCriterion("car_framenumber is null");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberIsNotNull() {
            addCriterion("car_framenumber is not null");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberEqualTo(String value) {
            addCriterion("car_framenumber =", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberNotEqualTo(String value) {
            addCriterion("car_framenumber <>", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberGreaterThan(String value) {
            addCriterion("car_framenumber >", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_framenumber >=", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberLessThan(String value) {
            addCriterion("car_framenumber <", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberLessThanOrEqualTo(String value) {
            addCriterion("car_framenumber <=", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberLike(String value) {
            addCriterion("car_framenumber like", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberNotLike(String value) {
            addCriterion("car_framenumber not like", value, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberIn(List<String> values) {
            addCriterion("car_framenumber in", values, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberNotIn(List<String> values) {
            addCriterion("car_framenumber not in", values, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberBetween(String value1, String value2) {
            addCriterion("car_framenumber between", value1, value2, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andCarFramenumberNotBetween(String value1, String value2) {
            addCriterion("car_framenumber not between", value1, value2, "carFramenumber");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterion("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterion("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterion("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterion("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterion("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterion("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addCriterion("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addCriterion("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterion("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterion("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateIsNull() {
            addCriterion("issue_date is null");
            return (Criteria) this;
        }

        public Criteria andIssueDateIsNotNull() {
            addCriterion("issue_date is not null");
            return (Criteria) this;
        }

        public Criteria andIssueDateEqualTo(Date value) {
            addCriterion("issue_date =", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateNotEqualTo(Date value) {
            addCriterion("issue_date <>", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateGreaterThan(Date value) {
            addCriterion("issue_date >", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_date >=", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateLessThan(Date value) {
            addCriterion("issue_date <", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateLessThanOrEqualTo(Date value) {
            addCriterion("issue_date <=", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateIn(List<Date> values) {
            addCriterion("issue_date in", values, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateNotIn(List<Date> values) {
            addCriterion("issue_date not in", values, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateBetween(Date value1, Date value2) {
            addCriterion("issue_date between", value1, value2, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateNotBetween(Date value1, Date value2) {
            addCriterion("issue_date not between", value1, value2, "issueDate");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNull() {
            addCriterion("file_num is null");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNotNull() {
            addCriterion("file_num is not null");
            return (Criteria) this;
        }

        public Criteria andFileNumEqualTo(String value) {
            addCriterion("file_num =", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotEqualTo(String value) {
            addCriterion("file_num <>", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThan(String value) {
            addCriterion("file_num >", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThanOrEqualTo(String value) {
            addCriterion("file_num >=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThan(String value) {
            addCriterion("file_num <", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThanOrEqualTo(String value) {
            addCriterion("file_num <=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLike(String value) {
            addCriterion("file_num like", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotLike(String value) {
            addCriterion("file_num not like", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumIn(List<String> values) {
            addCriterion("file_num in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotIn(List<String> values) {
            addCriterion("file_num not in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumBetween(String value1, String value2) {
            addCriterion("file_num between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotBetween(String value1, String value2) {
            addCriterion("file_num not between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumIsNull() {
            addCriterion("author_num is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNumIsNotNull() {
            addCriterion("author_num is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNumEqualTo(String value) {
            addCriterion("author_num =", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotEqualTo(String value) {
            addCriterion("author_num <>", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumGreaterThan(String value) {
            addCriterion("author_num >", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumGreaterThanOrEqualTo(String value) {
            addCriterion("author_num >=", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumLessThan(String value) {
            addCriterion("author_num <", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumLessThanOrEqualTo(String value) {
            addCriterion("author_num <=", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumLike(String value) {
            addCriterion("author_num like", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotLike(String value) {
            addCriterion("author_num not like", value, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumIn(List<String> values) {
            addCriterion("author_num in", values, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotIn(List<String> values) {
            addCriterion("author_num not in", values, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumBetween(String value1, String value2) {
            addCriterion("author_num between", value1, value2, "authorNum");
            return (Criteria) this;
        }

        public Criteria andAuthorNumNotBetween(String value1, String value2) {
            addCriterion("author_num not between", value1, value2, "authorNum");
            return (Criteria) this;
        }

        public Criteria andTotalMassIsNull() {
            addCriterion("total_mass is null");
            return (Criteria) this;
        }

        public Criteria andTotalMassIsNotNull() {
            addCriterion("total_mass is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMassEqualTo(String value) {
            addCriterion("total_mass =", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassNotEqualTo(String value) {
            addCriterion("total_mass <>", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassGreaterThan(String value) {
            addCriterion("total_mass >", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassGreaterThanOrEqualTo(String value) {
            addCriterion("total_mass >=", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassLessThan(String value) {
            addCriterion("total_mass <", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassLessThanOrEqualTo(String value) {
            addCriterion("total_mass <=", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassLike(String value) {
            addCriterion("total_mass like", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassNotLike(String value) {
            addCriterion("total_mass not like", value, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassIn(List<String> values) {
            addCriterion("total_mass in", values, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassNotIn(List<String> values) {
            addCriterion("total_mass not in", values, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassBetween(String value1, String value2) {
            addCriterion("total_mass between", value1, value2, "totalMass");
            return (Criteria) this;
        }

        public Criteria andTotalMassNotBetween(String value1, String value2) {
            addCriterion("total_mass not between", value1, value2, "totalMass");
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

        public Criteria andDrivingLicenseIsNull() {
            addCriterion("driving_license is null");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseIsNotNull() {
            addCriterion("driving_license is not null");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseEqualTo(String value) {
            addCriterion("driving_license =", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseNotEqualTo(String value) {
            addCriterion("driving_license <>", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseGreaterThan(String value) {
            addCriterion("driving_license >", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("driving_license >=", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseLessThan(String value) {
            addCriterion("driving_license <", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseLessThanOrEqualTo(String value) {
            addCriterion("driving_license <=", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseLike(String value) {
            addCriterion("driving_license like", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseNotLike(String value) {
            addCriterion("driving_license not like", value, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseIn(List<String> values) {
            addCriterion("driving_license in", values, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseNotIn(List<String> values) {
            addCriterion("driving_license not in", values, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseBetween(String value1, String value2) {
            addCriterion("driving_license between", value1, value2, "drivingLicense");
            return (Criteria) this;
        }

        public Criteria andDrivingLicenseNotBetween(String value1, String value2) {
            addCriterion("driving_license not between", value1, value2, "drivingLicense");
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
     * driving_license
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * driving_license 2018-06-13
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