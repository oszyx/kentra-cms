package com.kentrasoft.cms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairRecordExample {
    /**
     * repair_record
     */
    protected String orderByClause;

    /**
     * repair_record
     */
    protected boolean distinct;

    /**
     * repair_record
     */
    protected List<Criteria> oredCriteria;

    /**
     * repair_record
     */
    protected Integer limitStart;

    /**
     * repair_record
     */
    protected Integer limitEnd;

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public RepairRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-20
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
     * @mbg.generated 2018-06-20
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2018-06-20
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * repair_record 2018-06-20
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

        public Criteria andRepairDeviceIdIsNull() {
            addCriterion("repair_device_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdIsNotNull() {
            addCriterion("repair_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdEqualTo(String value) {
            addCriterion("repair_device_id =", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdNotEqualTo(String value) {
            addCriterion("repair_device_id <>", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdGreaterThan(String value) {
            addCriterion("repair_device_id >", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("repair_device_id >=", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdLessThan(String value) {
            addCriterion("repair_device_id <", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("repair_device_id <=", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdLike(String value) {
            addCriterion("repair_device_id like", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdNotLike(String value) {
            addCriterion("repair_device_id not like", value, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdIn(List<String> values) {
            addCriterion("repair_device_id in", values, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdNotIn(List<String> values) {
            addCriterion("repair_device_id not in", values, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdBetween(String value1, String value2) {
            addCriterion("repair_device_id between", value1, value2, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceIdNotBetween(String value1, String value2) {
            addCriterion("repair_device_id not between", value1, value2, "repairDeviceId");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameIsNull() {
            addCriterion("repair_device_name is null");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameIsNotNull() {
            addCriterion("repair_device_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameEqualTo(String value) {
            addCriterion("repair_device_name =", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameNotEqualTo(String value) {
            addCriterion("repair_device_name <>", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameGreaterThan(String value) {
            addCriterion("repair_device_name >", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("repair_device_name >=", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameLessThan(String value) {
            addCriterion("repair_device_name <", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("repair_device_name <=", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameLike(String value) {
            addCriterion("repair_device_name like", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameNotLike(String value) {
            addCriterion("repair_device_name not like", value, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameIn(List<String> values) {
            addCriterion("repair_device_name in", values, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameNotIn(List<String> values) {
            addCriterion("repair_device_name not in", values, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameBetween(String value1, String value2) {
            addCriterion("repair_device_name between", value1, value2, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairDeviceNameNotBetween(String value1, String value2) {
            addCriterion("repair_device_name not between", value1, value2, "repairDeviceName");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneIsNull() {
            addCriterion("repair_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneIsNotNull() {
            addCriterion("repair_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneEqualTo(String value) {
            addCriterion("repair_user_phone =", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneNotEqualTo(String value) {
            addCriterion("repair_user_phone <>", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneGreaterThan(String value) {
            addCriterion("repair_user_phone >", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("repair_user_phone >=", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneLessThan(String value) {
            addCriterion("repair_user_phone <", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("repair_user_phone <=", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneLike(String value) {
            addCriterion("repair_user_phone like", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneNotLike(String value) {
            addCriterion("repair_user_phone not like", value, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneIn(List<String> values) {
            addCriterion("repair_user_phone in", values, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneNotIn(List<String> values) {
            addCriterion("repair_user_phone not in", values, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneBetween(String value1, String value2) {
            addCriterion("repair_user_phone between", value1, value2, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserPhoneNotBetween(String value1, String value2) {
            addCriterion("repair_user_phone not between", value1, value2, "repairUserPhone");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameIsNull() {
            addCriterion("repair_user_name is null");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameIsNotNull() {
            addCriterion("repair_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameEqualTo(String value) {
            addCriterion("repair_user_name =", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameNotEqualTo(String value) {
            addCriterion("repair_user_name <>", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameGreaterThan(String value) {
            addCriterion("repair_user_name >", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("repair_user_name >=", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameLessThan(String value) {
            addCriterion("repair_user_name <", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameLessThanOrEqualTo(String value) {
            addCriterion("repair_user_name <=", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameLike(String value) {
            addCriterion("repair_user_name like", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameNotLike(String value) {
            addCriterion("repair_user_name not like", value, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameIn(List<String> values) {
            addCriterion("repair_user_name in", values, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameNotIn(List<String> values) {
            addCriterion("repair_user_name not in", values, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameBetween(String value1, String value2) {
            addCriterion("repair_user_name between", value1, value2, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairUserNameNotBetween(String value1, String value2) {
            addCriterion("repair_user_name not between", value1, value2, "repairUserName");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarIsNull() {
            addCriterion("repair_date_star is null");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarIsNotNull() {
            addCriterion("repair_date_star is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarEqualTo(Date value) {
            addCriterion("repair_date_star =", value, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarNotEqualTo(Date value) {
            addCriterion("repair_date_star <>", value, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarGreaterThan(Date value) {
            addCriterion("repair_date_star >", value, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_date_star >=", value, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarLessThan(Date value) {
            addCriterion("repair_date_star <", value, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarLessThanOrEqualTo(Date value) {
            addCriterion("repair_date_star <=", value, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarIn(List<Date> values) {
            addCriterion("repair_date_star in", values, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarNotIn(List<Date> values) {
            addCriterion("repair_date_star not in", values, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarBetween(Date value1, Date value2) {
            addCriterion("repair_date_star between", value1, value2, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateStarNotBetween(Date value1, Date value2) {
            addCriterion("repair_date_star not between", value1, value2, "repairDateStar");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndIsNull() {
            addCriterion("repair_date_end is null");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndIsNotNull() {
            addCriterion("repair_date_end is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndEqualTo(Date value) {
            addCriterion("repair_date_end =", value, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndNotEqualTo(Date value) {
            addCriterion("repair_date_end <>", value, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndGreaterThan(Date value) {
            addCriterion("repair_date_end >", value, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_date_end >=", value, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndLessThan(Date value) {
            addCriterion("repair_date_end <", value, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndLessThanOrEqualTo(Date value) {
            addCriterion("repair_date_end <=", value, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndIn(List<Date> values) {
            addCriterion("repair_date_end in", values, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndNotIn(List<Date> values) {
            addCriterion("repair_date_end not in", values, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndBetween(Date value1, Date value2) {
            addCriterion("repair_date_end between", value1, value2, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairDateEndNotBetween(Date value1, Date value2) {
            addCriterion("repair_date_end not between", value1, value2, "repairDateEnd");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNull() {
            addCriterion("repair_status is null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNotNull() {
            addCriterion("repair_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusEqualTo(String value) {
            addCriterion("repair_status =", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotEqualTo(String value) {
            addCriterion("repair_status <>", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThan(String value) {
            addCriterion("repair_status >", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThanOrEqualTo(String value) {
            addCriterion("repair_status >=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThan(String value) {
            addCriterion("repair_status <", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThanOrEqualTo(String value) {
            addCriterion("repair_status <=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLike(String value) {
            addCriterion("repair_status like", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotLike(String value) {
            addCriterion("repair_status not like", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIn(List<String> values) {
            addCriterion("repair_status in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotIn(List<String> values) {
            addCriterion("repair_status not in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusBetween(String value1, String value2) {
            addCriterion("repair_status between", value1, value2, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotBetween(String value1, String value2) {
            addCriterion("repair_status not between", value1, value2, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeIsNull() {
            addCriterion("repair_notice is null");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeIsNotNull() {
            addCriterion("repair_notice is not null");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeEqualTo(String value) {
            addCriterion("repair_notice =", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeNotEqualTo(String value) {
            addCriterion("repair_notice <>", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeGreaterThan(String value) {
            addCriterion("repair_notice >", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("repair_notice >=", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeLessThan(String value) {
            addCriterion("repair_notice <", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeLessThanOrEqualTo(String value) {
            addCriterion("repair_notice <=", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeLike(String value) {
            addCriterion("repair_notice like", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeNotLike(String value) {
            addCriterion("repair_notice not like", value, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeIn(List<String> values) {
            addCriterion("repair_notice in", values, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeNotIn(List<String> values) {
            addCriterion("repair_notice not in", values, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeBetween(String value1, String value2) {
            addCriterion("repair_notice between", value1, value2, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairNoticeNotBetween(String value1, String value2) {
            addCriterion("repair_notice not between", value1, value2, "repairNotice");
            return (Criteria) this;
        }

        public Criteria andRepairReasonIsNull() {
            addCriterion("repair_reason is null");
            return (Criteria) this;
        }

        public Criteria andRepairReasonIsNotNull() {
            addCriterion("repair_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRepairReasonEqualTo(String value) {
            addCriterion("repair_reason =", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonNotEqualTo(String value) {
            addCriterion("repair_reason <>", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonGreaterThan(String value) {
            addCriterion("repair_reason >", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonGreaterThanOrEqualTo(String value) {
            addCriterion("repair_reason >=", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonLessThan(String value) {
            addCriterion("repair_reason <", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonLessThanOrEqualTo(String value) {
            addCriterion("repair_reason <=", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonLike(String value) {
            addCriterion("repair_reason like", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonNotLike(String value) {
            addCriterion("repair_reason not like", value, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonIn(List<String> values) {
            addCriterion("repair_reason in", values, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonNotIn(List<String> values) {
            addCriterion("repair_reason not in", values, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonBetween(String value1, String value2) {
            addCriterion("repair_reason between", value1, value2, "repairReason");
            return (Criteria) this;
        }

        public Criteria andRepairReasonNotBetween(String value1, String value2) {
            addCriterion("repair_reason not between", value1, value2, "repairReason");
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
     * repair_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * repair_record 2018-06-20
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