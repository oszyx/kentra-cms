package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerManagementExample {
    /**
     * controller_management
     */
    protected String orderByClause;

    /**
     * controller_management
     */
    protected boolean distinct;

    /**
     * controller_management
     */
    protected List<Criteria> oredCriteria;

    /**
     * controller_management
     */
    protected Integer limitStart;

    /**
     * controller_management
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public ControllerManagementExample() {
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
     * controller_management 2018-06-13
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andControllerCodeIsNull() {
            addCriterion("controller_code is null");
            return (Criteria) this;
        }

        public Criteria andControllerCodeIsNotNull() {
            addCriterion("controller_code is not null");
            return (Criteria) this;
        }

        public Criteria andControllerCodeEqualTo(String value) {
            addCriterion("controller_code =", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeNotEqualTo(String value) {
            addCriterion("controller_code <>", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeGreaterThan(String value) {
            addCriterion("controller_code >", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("controller_code >=", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeLessThan(String value) {
            addCriterion("controller_code <", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeLessThanOrEqualTo(String value) {
            addCriterion("controller_code <=", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeLike(String value) {
            addCriterion("controller_code like", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeNotLike(String value) {
            addCriterion("controller_code not like", value, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeIn(List<String> values) {
            addCriterion("controller_code in", values, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeNotIn(List<String> values) {
            addCriterion("controller_code not in", values, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeBetween(String value1, String value2) {
            addCriterion("controller_code between", value1, value2, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerCodeNotBetween(String value1, String value2) {
            addCriterion("controller_code not between", value1, value2, "controllerCode");
            return (Criteria) this;
        }

        public Criteria andControllerAddressIsNull() {
            addCriterion("controller_address is null");
            return (Criteria) this;
        }

        public Criteria andControllerAddressIsNotNull() {
            addCriterion("controller_address is not null");
            return (Criteria) this;
        }

        public Criteria andControllerAddressEqualTo(String value) {
            addCriterion("controller_address =", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressNotEqualTo(String value) {
            addCriterion("controller_address <>", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressGreaterThan(String value) {
            addCriterion("controller_address >", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("controller_address >=", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressLessThan(String value) {
            addCriterion("controller_address <", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressLessThanOrEqualTo(String value) {
            addCriterion("controller_address <=", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressLike(String value) {
            addCriterion("controller_address like", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressNotLike(String value) {
            addCriterion("controller_address not like", value, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressIn(List<String> values) {
            addCriterion("controller_address in", values, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressNotIn(List<String> values) {
            addCriterion("controller_address not in", values, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressBetween(String value1, String value2) {
            addCriterion("controller_address between", value1, value2, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerAddressNotBetween(String value1, String value2) {
            addCriterion("controller_address not between", value1, value2, "controllerAddress");
            return (Criteria) this;
        }

        public Criteria andControllerGisXIsNull() {
            addCriterion("controller_gis_x is null");
            return (Criteria) this;
        }

        public Criteria andControllerGisXIsNotNull() {
            addCriterion("controller_gis_x is not null");
            return (Criteria) this;
        }

        public Criteria andControllerGisXEqualTo(String value) {
            addCriterion("controller_gis_x =", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXNotEqualTo(String value) {
            addCriterion("controller_gis_x <>", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXGreaterThan(String value) {
            addCriterion("controller_gis_x >", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXGreaterThanOrEqualTo(String value) {
            addCriterion("controller_gis_x >=", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXLessThan(String value) {
            addCriterion("controller_gis_x <", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXLessThanOrEqualTo(String value) {
            addCriterion("controller_gis_x <=", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXLike(String value) {
            addCriterion("controller_gis_x like", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXNotLike(String value) {
            addCriterion("controller_gis_x not like", value, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXIn(List<String> values) {
            addCriterion("controller_gis_x in", values, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXNotIn(List<String> values) {
            addCriterion("controller_gis_x not in", values, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXBetween(String value1, String value2) {
            addCriterion("controller_gis_x between", value1, value2, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisXNotBetween(String value1, String value2) {
            addCriterion("controller_gis_x not between", value1, value2, "controllerGisX");
            return (Criteria) this;
        }

        public Criteria andControllerGisYIsNull() {
            addCriterion("controller_gis_y is null");
            return (Criteria) this;
        }

        public Criteria andControllerGisYIsNotNull() {
            addCriterion("controller_gis_y is not null");
            return (Criteria) this;
        }

        public Criteria andControllerGisYEqualTo(String value) {
            addCriterion("controller_gis_y =", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYNotEqualTo(String value) {
            addCriterion("controller_gis_y <>", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYGreaterThan(String value) {
            addCriterion("controller_gis_y >", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYGreaterThanOrEqualTo(String value) {
            addCriterion("controller_gis_y >=", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYLessThan(String value) {
            addCriterion("controller_gis_y <", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYLessThanOrEqualTo(String value) {
            addCriterion("controller_gis_y <=", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYLike(String value) {
            addCriterion("controller_gis_y like", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYNotLike(String value) {
            addCriterion("controller_gis_y not like", value, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYIn(List<String> values) {
            addCriterion("controller_gis_y in", values, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYNotIn(List<String> values) {
            addCriterion("controller_gis_y not in", values, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYBetween(String value1, String value2) {
            addCriterion("controller_gis_y between", value1, value2, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerGisYNotBetween(String value1, String value2) {
            addCriterion("controller_gis_y not between", value1, value2, "controllerGisY");
            return (Criteria) this;
        }

        public Criteria andControllerStatusIsNull() {
            addCriterion("controller_status is null");
            return (Criteria) this;
        }

        public Criteria andControllerStatusIsNotNull() {
            addCriterion("controller_status is not null");
            return (Criteria) this;
        }

        public Criteria andControllerStatusEqualTo(String value) {
            addCriterion("controller_status =", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusNotEqualTo(String value) {
            addCriterion("controller_status <>", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusGreaterThan(String value) {
            addCriterion("controller_status >", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("controller_status >=", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusLessThan(String value) {
            addCriterion("controller_status <", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusLessThanOrEqualTo(String value) {
            addCriterion("controller_status <=", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusLike(String value) {
            addCriterion("controller_status like", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusNotLike(String value) {
            addCriterion("controller_status not like", value, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusIn(List<String> values) {
            addCriterion("controller_status in", values, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusNotIn(List<String> values) {
            addCriterion("controller_status not in", values, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusBetween(String value1, String value2) {
            addCriterion("controller_status between", value1, value2, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andControllerStatusNotBetween(String value1, String value2) {
            addCriterion("controller_status not between", value1, value2, "controllerStatus");
            return (Criteria) this;
        }

        public Criteria andDescripInfosIsNull() {
            addCriterion("descrip_infos is null");
            return (Criteria) this;
        }

        public Criteria andDescripInfosIsNotNull() {
            addCriterion("descrip_infos is not null");
            return (Criteria) this;
        }

        public Criteria andDescripInfosEqualTo(String value) {
            addCriterion("descrip_infos =", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosNotEqualTo(String value) {
            addCriterion("descrip_infos <>", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosGreaterThan(String value) {
            addCriterion("descrip_infos >", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosGreaterThanOrEqualTo(String value) {
            addCriterion("descrip_infos >=", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosLessThan(String value) {
            addCriterion("descrip_infos <", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosLessThanOrEqualTo(String value) {
            addCriterion("descrip_infos <=", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosLike(String value) {
            addCriterion("descrip_infos like", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosNotLike(String value) {
            addCriterion("descrip_infos not like", value, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosIn(List<String> values) {
            addCriterion("descrip_infos in", values, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosNotIn(List<String> values) {
            addCriterion("descrip_infos not in", values, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosBetween(String value1, String value2) {
            addCriterion("descrip_infos between", value1, value2, "descripInfos");
            return (Criteria) this;
        }

        public Criteria andDescripInfosNotBetween(String value1, String value2) {
            addCriterion("descrip_infos not between", value1, value2, "descripInfos");
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
     * controller_management
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * controller_management 2018-06-13
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