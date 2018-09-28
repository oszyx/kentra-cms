package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictExample {
    /**
     * menu
     */
    protected String orderByClause;

    /**
     * menu
     */
    protected boolean distinct;

    /**
     * menu
     */
    protected List<Criteria> oredCriteria;

    /**
     * menu
     */
    protected Integer limitStart;

    /**
     * menu
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public DictExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-05-25
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
     * @mbg.generated 2018-05-25
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-05-25
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * menu 2018-05-25
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

        public Criteria andDictNameIsNull() {
            addCriterion("dict_name is null");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNotNull() {
            addCriterion("dict_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictNameEqualTo(String value) {
            addCriterion("dict_name =", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotEqualTo(String value) {
            addCriterion("dict_name <>", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThan(String value) {
            addCriterion("dict_name >", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThanOrEqualTo(String value) {
            addCriterion("dict_name >=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThan(String value) {
            addCriterion("dict_name <", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThanOrEqualTo(String value) {
            addCriterion("dict_name <=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLike(String value) {
            addCriterion("dict_name like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotLike(String value) {
            addCriterion("dict_name not like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameIn(List<String> values) {
            addCriterion("dict_name in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotIn(List<String> values) {
            addCriterion("dict_name not in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameBetween(String value1, String value2) {
            addCriterion("dict_name between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotBetween(String value1, String value2) {
            addCriterion("dict_name not between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNull() {
            addCriterion("dict_code is null");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNotNull() {
            addCriterion("dict_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodeEqualTo(String value) {
            addCriterion("dict_code =", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotEqualTo(String value) {
            addCriterion("dict_code <>", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThan(String value) {
            addCriterion("dict_code >", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dict_code >=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThan(String value) {
            addCriterion("dict_code <", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThanOrEqualTo(String value) {
            addCriterion("dict_code <=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLike(String value) {
            addCriterion("dict_code like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotLike(String value) {
            addCriterion("dict_code not like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeIn(List<String> values) {
            addCriterion("dict_code in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotIn(List<String> values) {
            addCriterion("dict_code not in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeBetween(String value1, String value2) {
            addCriterion("dict_code between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotBetween(String value1, String value2) {
            addCriterion("dict_code not between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictParentIdIsNull() {
            addCriterion("dict_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andDictParentIdIsNotNull() {
            addCriterion("dict_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictParentIdEqualTo(String value) {
            addCriterion("dict_parent_id =", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdNotEqualTo(String value) {
            addCriterion("dict_parent_id <>", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdGreaterThan(String value) {
            addCriterion("dict_parent_id >", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("dict_parent_id >=", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdLessThan(String value) {
            addCriterion("dict_parent_id <", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdLessThanOrEqualTo(String value) {
            addCriterion("dict_parent_id <=", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdLike(String value) {
            addCriterion("dict_parent_id like", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdNotLike(String value) {
            addCriterion("dict_parent_id not like", value, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdIn(List<String> values) {
            addCriterion("dict_parent_id in", values, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdNotIn(List<String> values) {
            addCriterion("dict_parent_id not in", values, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdBetween(String value1, String value2) {
            addCriterion("dict_parent_id between", value1, value2, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictParentIdNotBetween(String value1, String value2) {
            addCriterion("dict_parent_id not between", value1, value2, "dictParentId");
            return (Criteria) this;
        }

        public Criteria andDictLevelIsNull() {
            addCriterion("dict_level is null");
            return (Criteria) this;
        }

        public Criteria andDictLevelIsNotNull() {
            addCriterion("dict_level is not null");
            return (Criteria) this;
        }

        public Criteria andDictLevelEqualTo(Long value) {
            addCriterion("dict_level =", value, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelNotEqualTo(Long value) {
            addCriterion("dict_level <>", value, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelGreaterThan(Long value) {
            addCriterion("dict_level >", value, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelGreaterThanOrEqualTo(Long value) {
            addCriterion("dict_level >=", value, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelLessThan(Long value) {
            addCriterion("dict_level <", value, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelLessThanOrEqualTo(Long value) {
            addCriterion("dict_level <=", value, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelIn(List<Long> values) {
            addCriterion("dict_level in", values, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelNotIn(List<Long> values) {
            addCriterion("dict_level not in", values, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelBetween(Long value1, Long value2) {
            addCriterion("dict_level between", value1, value2, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictLevelNotBetween(Long value1, Long value2) {
            addCriterion("dict_level not between", value1, value2, "dictLevel");
            return (Criteria) this;
        }

        public Criteria andDictStatusIsNull() {
            addCriterion("dict_status is null");
            return (Criteria) this;
        }

        public Criteria andDictStatusIsNotNull() {
            addCriterion("dict_status is not null");
            return (Criteria) this;
        }

        public Criteria andDictStatusEqualTo(String value) {
            addCriterion("dict_status =", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotEqualTo(String value) {
            addCriterion("dict_status <>", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusGreaterThan(String value) {
            addCriterion("dict_status >", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusGreaterThanOrEqualTo(String value) {
            addCriterion("dict_status >=", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusLessThan(String value) {
            addCriterion("dict_status <", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusLessThanOrEqualTo(String value) {
            addCriterion("dict_status <=", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusLike(String value) {
            addCriterion("dict_status like", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotLike(String value) {
            addCriterion("dict_status not like", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusIn(List<String> values) {
            addCriterion("dict_status in", values, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotIn(List<String> values) {
            addCriterion("dict_status not in", values, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusBetween(String value1, String value2) {
            addCriterion("dict_status between", value1, value2, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotBetween(String value1, String value2) {
            addCriterion("dict_status not between", value1, value2, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    /**
     * dict
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * dict 2018-05-25
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