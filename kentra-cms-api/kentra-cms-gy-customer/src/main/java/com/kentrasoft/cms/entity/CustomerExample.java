package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    /**
     * customer
     */
    protected String orderByClause;

    /**
     * customer
     */
    protected boolean distinct;

    /**
     * customer
     */
    protected List<Criteria> oredCriteria;

    /**
     * customer
     */
    protected Integer limitStart;

    /**
     * customer
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-06-13
     */
    public CustomerExample() {
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
     * customer 2018-06-13
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNationalIsNull() {
            addCriterion("`national` is null");
            return (Criteria) this;
        }

        public Criteria andNationalIsNotNull() {
            addCriterion("`national` is not null");
            return (Criteria) this;
        }

        public Criteria andNationalEqualTo(String value) {
            addCriterion("`national` =", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotEqualTo(String value) {
            addCriterion("`national` <>", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalGreaterThan(String value) {
            addCriterion("`national` >", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalGreaterThanOrEqualTo(String value) {
            addCriterion("`national` >=", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalLessThan(String value) {
            addCriterion("`national` <", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalLessThanOrEqualTo(String value) {
            addCriterion("`national` <=", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalLike(String value) {
            addCriterion("`national` like", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotLike(String value) {
            addCriterion("`national` not like", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalIn(List<String> values) {
            addCriterion("`national` in", values, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotIn(List<String> values) {
            addCriterion("`national` not in", values, "national");
            return (Criteria) this;
        }

        public Criteria andNationalBetween(String value1, String value2) {
            addCriterion("`national` between", value1, value2, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotBetween(String value1, String value2) {
            addCriterion("`national` not between", value1, value2, "national");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeIsNull() {
            addCriterion("document_type is null");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeIsNotNull() {
            addCriterion("document_type is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeEqualTo(String value) {
            addCriterion("document_type =", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotEqualTo(String value) {
            addCriterion("document_type <>", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeGreaterThan(String value) {
            addCriterion("document_type >", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("document_type >=", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeLessThan(String value) {
            addCriterion("document_type <", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeLessThanOrEqualTo(String value) {
            addCriterion("document_type <=", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeLike(String value) {
            addCriterion("document_type like", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotLike(String value) {
            addCriterion("document_type not like", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeIn(List<String> values) {
            addCriterion("document_type in", values, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotIn(List<String> values) {
            addCriterion("document_type not in", values, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeBetween(String value1, String value2) {
            addCriterion("document_type between", value1, value2, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotBetween(String value1, String value2) {
            addCriterion("document_type not between", value1, value2, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentNumIsNull() {
            addCriterion("document_num is null");
            return (Criteria) this;
        }

        public Criteria andDocumentNumIsNotNull() {
            addCriterion("document_num is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentNumEqualTo(String value) {
            addCriterion("document_num =", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumNotEqualTo(String value) {
            addCriterion("document_num <>", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumGreaterThan(String value) {
            addCriterion("document_num >", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumGreaterThanOrEqualTo(String value) {
            addCriterion("document_num >=", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumLessThan(String value) {
            addCriterion("document_num <", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumLessThanOrEqualTo(String value) {
            addCriterion("document_num <=", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumLike(String value) {
            addCriterion("document_num like", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumNotLike(String value) {
            addCriterion("document_num not like", value, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumIn(List<String> values) {
            addCriterion("document_num in", values, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumNotIn(List<String> values) {
            addCriterion("document_num not in", values, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumBetween(String value1, String value2) {
            addCriterion("document_num between", value1, value2, "documentNum");
            return (Criteria) this;
        }

        public Criteria andDocumentNumNotBetween(String value1, String value2) {
            addCriterion("document_num not between", value1, value2, "documentNum");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1IsNull() {
            addCriterion("link_telphone1 is null");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1IsNotNull() {
            addCriterion("link_telphone1 is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1EqualTo(String value) {
            addCriterion("link_telphone1 =", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1NotEqualTo(String value) {
            addCriterion("link_telphone1 <>", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1GreaterThan(String value) {
            addCriterion("link_telphone1 >", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1GreaterThanOrEqualTo(String value) {
            addCriterion("link_telphone1 >=", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1LessThan(String value) {
            addCriterion("link_telphone1 <", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1LessThanOrEqualTo(String value) {
            addCriterion("link_telphone1 <=", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1Like(String value) {
            addCriterion("link_telphone1 like", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1NotLike(String value) {
            addCriterion("link_telphone1 not like", value, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1In(List<String> values) {
            addCriterion("link_telphone1 in", values, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1NotIn(List<String> values) {
            addCriterion("link_telphone1 not in", values, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1Between(String value1, String value2) {
            addCriterion("link_telphone1 between", value1, value2, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone1NotBetween(String value1, String value2) {
            addCriterion("link_telphone1 not between", value1, value2, "linkTelphone1");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2IsNull() {
            addCriterion("link_telphone2 is null");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2IsNotNull() {
            addCriterion("link_telphone2 is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2EqualTo(String value) {
            addCriterion("link_telphone2 =", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2NotEqualTo(String value) {
            addCriterion("link_telphone2 <>", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2GreaterThan(String value) {
            addCriterion("link_telphone2 >", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2GreaterThanOrEqualTo(String value) {
            addCriterion("link_telphone2 >=", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2LessThan(String value) {
            addCriterion("link_telphone2 <", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2LessThanOrEqualTo(String value) {
            addCriterion("link_telphone2 <=", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2Like(String value) {
            addCriterion("link_telphone2 like", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2NotLike(String value) {
            addCriterion("link_telphone2 not like", value, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2In(List<String> values) {
            addCriterion("link_telphone2 in", values, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2NotIn(List<String> values) {
            addCriterion("link_telphone2 not in", values, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2Between(String value1, String value2) {
            addCriterion("link_telphone2 between", value1, value2, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkTelphone2NotBetween(String value1, String value2) {
            addCriterion("link_telphone2 not between", value1, value2, "linkTelphone2");
            return (Criteria) this;
        }

        public Criteria andLinkAddressIsNull() {
            addCriterion("link_address is null");
            return (Criteria) this;
        }

        public Criteria andLinkAddressIsNotNull() {
            addCriterion("link_address is not null");
            return (Criteria) this;
        }

        public Criteria andLinkAddressEqualTo(String value) {
            addCriterion("link_address =", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotEqualTo(String value) {
            addCriterion("link_address <>", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressGreaterThan(String value) {
            addCriterion("link_address >", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("link_address >=", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressLessThan(String value) {
            addCriterion("link_address <", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressLessThanOrEqualTo(String value) {
            addCriterion("link_address <=", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressLike(String value) {
            addCriterion("link_address like", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotLike(String value) {
            addCriterion("link_address not like", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressIn(List<String> values) {
            addCriterion("link_address in", values, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotIn(List<String> values) {
            addCriterion("link_address not in", values, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressBetween(String value1, String value2) {
            addCriterion("link_address between", value1, value2, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotBetween(String value1, String value2) {
            addCriterion("link_address not between", value1, value2, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andDriveNumIsNull() {
            addCriterion("drive_num is null");
            return (Criteria) this;
        }

        public Criteria andDriveNumIsNotNull() {
            addCriterion("drive_num is not null");
            return (Criteria) this;
        }

        public Criteria andDriveNumEqualTo(String value) {
            addCriterion("drive_num =", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumNotEqualTo(String value) {
            addCriterion("drive_num <>", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumGreaterThan(String value) {
            addCriterion("drive_num >", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumGreaterThanOrEqualTo(String value) {
            addCriterion("drive_num >=", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumLessThan(String value) {
            addCriterion("drive_num <", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumLessThanOrEqualTo(String value) {
            addCriterion("drive_num <=", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumLike(String value) {
            addCriterion("drive_num like", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumNotLike(String value) {
            addCriterion("drive_num not like", value, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumIn(List<String> values) {
            addCriterion("drive_num in", values, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumNotIn(List<String> values) {
            addCriterion("drive_num not in", values, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumBetween(String value1, String value2) {
            addCriterion("drive_num between", value1, value2, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveNumNotBetween(String value1, String value2) {
            addCriterion("drive_num not between", value1, value2, "driveNum");
            return (Criteria) this;
        }

        public Criteria andDriveTypeIsNull() {
            addCriterion("drive_type is null");
            return (Criteria) this;
        }

        public Criteria andDriveTypeIsNotNull() {
            addCriterion("drive_type is not null");
            return (Criteria) this;
        }

        public Criteria andDriveTypeEqualTo(String value) {
            addCriterion("drive_type =", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotEqualTo(String value) {
            addCriterion("drive_type <>", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeGreaterThan(String value) {
            addCriterion("drive_type >", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("drive_type >=", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeLessThan(String value) {
            addCriterion("drive_type <", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeLessThanOrEqualTo(String value) {
            addCriterion("drive_type <=", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeLike(String value) {
            addCriterion("drive_type like", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotLike(String value) {
            addCriterion("drive_type not like", value, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeIn(List<String> values) {
            addCriterion("drive_type in", values, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotIn(List<String> values) {
            addCriterion("drive_type not in", values, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeBetween(String value1, String value2) {
            addCriterion("drive_type between", value1, value2, "driveType");
            return (Criteria) this;
        }

        public Criteria andDriveTypeNotBetween(String value1, String value2) {
            addCriterion("drive_type not between", value1, value2, "driveType");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartIsNull() {
            addCriterion("evidence_start is null");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartIsNotNull() {
            addCriterion("evidence_start is not null");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartEqualTo(Date value) {
            addCriterion("evidence_start =", value, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartNotEqualTo(Date value) {
            addCriterion("evidence_start <>", value, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartGreaterThan(Date value) {
            addCriterion("evidence_start >", value, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartGreaterThanOrEqualTo(Date value) {
            addCriterion("evidence_start >=", value, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartLessThan(Date value) {
            addCriterion("evidence_start <", value, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartLessThanOrEqualTo(Date value) {
            addCriterion("evidence_start <=", value, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartIn(List<Date> values) {
            addCriterion("evidence_start in", values, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartNotIn(List<Date> values) {
            addCriterion("evidence_start not in", values, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartBetween(Date value1, Date value2) {
            addCriterion("evidence_start between", value1, value2, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEvidenceStartNotBetween(Date value1, Date value2) {
            addCriterion("evidence_start not between", value1, value2, "evidenceStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartIsNull() {
            addCriterion("effective_start is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartIsNotNull() {
            addCriterion("effective_start is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartEqualTo(Date value) {
            addCriterion("effective_start =", value, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartNotEqualTo(Date value) {
            addCriterion("effective_start <>", value, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartGreaterThan(Date value) {
            addCriterion("effective_start >", value, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_start >=", value, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartLessThan(Date value) {
            addCriterion("effective_start <", value, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartLessThanOrEqualTo(Date value) {
            addCriterion("effective_start <=", value, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartIn(List<Date> values) {
            addCriterion("effective_start in", values, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartNotIn(List<Date> values) {
            addCriterion("effective_start not in", values, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartBetween(Date value1, Date value2) {
            addCriterion("effective_start between", value1, value2, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartNotBetween(Date value1, Date value2) {
            addCriterion("effective_start not between", value1, value2, "effectiveStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndIsNull() {
            addCriterion("effective_end is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndIsNotNull() {
            addCriterion("effective_end is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndEqualTo(Date value) {
            addCriterion("effective_end =", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndNotEqualTo(Date value) {
            addCriterion("effective_end <>", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndGreaterThan(Date value) {
            addCriterion("effective_end >", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_end >=", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndLessThan(Date value) {
            addCriterion("effective_end <", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndLessThanOrEqualTo(Date value) {
            addCriterion("effective_end <=", value, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndIn(List<Date> values) {
            addCriterion("effective_end in", values, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndNotIn(List<Date> values) {
            addCriterion("effective_end not in", values, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndBetween(Date value1, Date value2) {
            addCriterion("effective_end between", value1, value2, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndNotBetween(Date value1, Date value2) {
            addCriterion("effective_end not between", value1, value2, "effectiveEnd");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationDateEqualTo(String value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotEqualTo(String value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThan(String value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateGreaterThanOrEqualTo(String value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThan(String value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLessThanOrEqualTo(String value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateLike(String value) {
            addCriterion("expiration_date like", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotLike(String value) {
            addCriterion("expiration_date not like", value, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateIn(List<String> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotIn(List<String> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateBetween(String value1, String value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (Criteria) this;
        }

        public Criteria andExpirationDateNotBetween(String value1, String value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
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

        public Criteria andCustomerStatusIsNull() {
            addCriterion("customer_status is null");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusIsNotNull() {
            addCriterion("customer_status is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusEqualTo(String value) {
            addCriterion("customer_status =", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotEqualTo(String value) {
            addCriterion("customer_status <>", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusGreaterThan(String value) {
            addCriterion("customer_status >", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("customer_status >=", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusLessThan(String value) {
            addCriterion("customer_status <", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusLessThanOrEqualTo(String value) {
            addCriterion("customer_status <=", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusLike(String value) {
            addCriterion("customer_status like", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotLike(String value) {
            addCriterion("customer_status not like", value, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusIn(List<String> values) {
            addCriterion("customer_status in", values, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotIn(List<String> values) {
            addCriterion("customer_status not in", values, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusBetween(String value1, String value2) {
            addCriterion("customer_status between", value1, value2, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andCustomerStatusNotBetween(String value1, String value2) {
            addCriterion("customer_status not between", value1, value2, "customerStatus");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseIsNull() {
            addCriterion("driver_license is null");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseIsNotNull() {
            addCriterion("driver_license is not null");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseEqualTo(String value) {
            addCriterion("driver_license =", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseNotEqualTo(String value) {
            addCriterion("driver_license <>", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseGreaterThan(String value) {
            addCriterion("driver_license >", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("driver_license >=", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseLessThan(String value) {
            addCriterion("driver_license <", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseLessThanOrEqualTo(String value) {
            addCriterion("driver_license <=", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseLike(String value) {
            addCriterion("driver_license like", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseNotLike(String value) {
            addCriterion("driver_license not like", value, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseIn(List<String> values) {
            addCriterion("driver_license in", values, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseNotIn(List<String> values) {
            addCriterion("driver_license not in", values, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseBetween(String value1, String value2) {
            addCriterion("driver_license between", value1, value2, "driverLicense");
            return (Criteria) this;
        }

        public Criteria andDriverLicenseNotBetween(String value1, String value2) {
            addCriterion("driver_license not between", value1, value2, "driverLicense");
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
     * customer
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * customer 2018-06-13
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