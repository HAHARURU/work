package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRVideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRVideoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(Integer value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(Integer value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(Integer value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(Integer value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(Integer value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<Integer> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<Integer> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(Integer value1, Integer value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(Integer value1, Integer value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVNameIsNull() {
            addCriterion("v_name is null");
            return (Criteria) this;
        }

        public Criteria andVNameIsNotNull() {
            addCriterion("v_name is not null");
            return (Criteria) this;
        }

        public Criteria andVNameEqualTo(String value) {
            addCriterion("v_name =", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotEqualTo(String value) {
            addCriterion("v_name <>", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThan(String value) {
            addCriterion("v_name >", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThanOrEqualTo(String value) {
            addCriterion("v_name >=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThan(String value) {
            addCriterion("v_name <", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThanOrEqualTo(String value) {
            addCriterion("v_name <=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLike(String value) {
            addCriterion("v_name like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotLike(String value) {
            addCriterion("v_name not like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameIn(List<String> values) {
            addCriterion("v_name in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotIn(List<String> values) {
            addCriterion("v_name not in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameBetween(String value1, String value2) {
            addCriterion("v_name between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotBetween(String value1, String value2) {
            addCriterion("v_name not between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVTitalIsNull() {
            addCriterion("v_tital is null");
            return (Criteria) this;
        }

        public Criteria andVTitalIsNotNull() {
            addCriterion("v_tital is not null");
            return (Criteria) this;
        }

        public Criteria andVTitalEqualTo(String value) {
            addCriterion("v_tital =", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalNotEqualTo(String value) {
            addCriterion("v_tital <>", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalGreaterThan(String value) {
            addCriterion("v_tital >", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalGreaterThanOrEqualTo(String value) {
            addCriterion("v_tital >=", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalLessThan(String value) {
            addCriterion("v_tital <", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalLessThanOrEqualTo(String value) {
            addCriterion("v_tital <=", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalLike(String value) {
            addCriterion("v_tital like", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalNotLike(String value) {
            addCriterion("v_tital not like", value, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalIn(List<String> values) {
            addCriterion("v_tital in", values, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalNotIn(List<String> values) {
            addCriterion("v_tital not in", values, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalBetween(String value1, String value2) {
            addCriterion("v_tital between", value1, value2, "vTital");
            return (Criteria) this;
        }

        public Criteria andVTitalNotBetween(String value1, String value2) {
            addCriterion("v_tital not between", value1, value2, "vTital");
            return (Criteria) this;
        }

        public Criteria andVYearIsNull() {
            addCriterion("v_year is null");
            return (Criteria) this;
        }

        public Criteria andVYearIsNotNull() {
            addCriterion("v_year is not null");
            return (Criteria) this;
        }

        public Criteria andVYearEqualTo(Integer value) {
            addCriterion("v_year =", value, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearNotEqualTo(Integer value) {
            addCriterion("v_year <>", value, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearGreaterThan(Integer value) {
            addCriterion("v_year >", value, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_year >=", value, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearLessThan(Integer value) {
            addCriterion("v_year <", value, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearLessThanOrEqualTo(Integer value) {
            addCriterion("v_year <=", value, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearIn(List<Integer> values) {
            addCriterion("v_year in", values, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearNotIn(List<Integer> values) {
            addCriterion("v_year not in", values, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearBetween(Integer value1, Integer value2) {
            addCriterion("v_year between", value1, value2, "vYear");
            return (Criteria) this;
        }

        public Criteria andVYearNotBetween(Integer value1, Integer value2) {
            addCriterion("v_year not between", value1, value2, "vYear");
            return (Criteria) this;
        }

        public Criteria andVMonthIsNull() {
            addCriterion("v_month is null");
            return (Criteria) this;
        }

        public Criteria andVMonthIsNotNull() {
            addCriterion("v_month is not null");
            return (Criteria) this;
        }

        public Criteria andVMonthEqualTo(Integer value) {
            addCriterion("v_month =", value, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthNotEqualTo(Integer value) {
            addCriterion("v_month <>", value, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthGreaterThan(Integer value) {
            addCriterion("v_month >", value, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_month >=", value, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthLessThan(Integer value) {
            addCriterion("v_month <", value, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthLessThanOrEqualTo(Integer value) {
            addCriterion("v_month <=", value, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthIn(List<Integer> values) {
            addCriterion("v_month in", values, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthNotIn(List<Integer> values) {
            addCriterion("v_month not in", values, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthBetween(Integer value1, Integer value2) {
            addCriterion("v_month between", value1, value2, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("v_month not between", value1, value2, "vMonth");
            return (Criteria) this;
        }

        public Criteria andVDayIsNull() {
            addCriterion("v_day is null");
            return (Criteria) this;
        }

        public Criteria andVDayIsNotNull() {
            addCriterion("v_day is not null");
            return (Criteria) this;
        }

        public Criteria andVDayEqualTo(Integer value) {
            addCriterion("v_day =", value, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayNotEqualTo(Integer value) {
            addCriterion("v_day <>", value, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayGreaterThan(Integer value) {
            addCriterion("v_day >", value, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_day >=", value, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayLessThan(Integer value) {
            addCriterion("v_day <", value, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayLessThanOrEqualTo(Integer value) {
            addCriterion("v_day <=", value, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayIn(List<Integer> values) {
            addCriterion("v_day in", values, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayNotIn(List<Integer> values) {
            addCriterion("v_day not in", values, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayBetween(Integer value1, Integer value2) {
            addCriterion("v_day between", value1, value2, "vDay");
            return (Criteria) this;
        }

        public Criteria andVDayNotBetween(Integer value1, Integer value2) {
            addCriterion("v_day not between", value1, value2, "vDay");
            return (Criteria) this;
        }

        public Criteria andSyscreatedIsNull() {
            addCriterion("syscreated is null");
            return (Criteria) this;
        }

        public Criteria andSyscreatedIsNotNull() {
            addCriterion("syscreated is not null");
            return (Criteria) this;
        }

        public Criteria andSyscreatedEqualTo(Date value) {
            addCriterion("syscreated =", value, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedNotEqualTo(Date value) {
            addCriterion("syscreated <>", value, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedGreaterThan(Date value) {
            addCriterion("syscreated >", value, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("syscreated >=", value, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedLessThan(Date value) {
            addCriterion("syscreated <", value, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedLessThanOrEqualTo(Date value) {
            addCriterion("syscreated <=", value, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedIn(List<Date> values) {
            addCriterion("syscreated in", values, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedNotIn(List<Date> values) {
            addCriterion("syscreated not in", values, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedBetween(Date value1, Date value2) {
            addCriterion("syscreated between", value1, value2, "syscreated");
            return (Criteria) this;
        }

        public Criteria andSyscreatedNotBetween(Date value1, Date value2) {
            addCriterion("syscreated not between", value1, value2, "syscreated");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Integer value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Integer value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Integer value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Integer value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Integer value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Integer> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Integer> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Integer value1, Integer value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andDemoIsNull() {
            addCriterion("demo is null");
            return (Criteria) this;
        }

        public Criteria andDemoIsNotNull() {
            addCriterion("demo is not null");
            return (Criteria) this;
        }

        public Criteria andDemoEqualTo(String value) {
            addCriterion("demo =", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoNotEqualTo(String value) {
            addCriterion("demo <>", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoGreaterThan(String value) {
            addCriterion("demo >", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoGreaterThanOrEqualTo(String value) {
            addCriterion("demo >=", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoLessThan(String value) {
            addCriterion("demo <", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoLessThanOrEqualTo(String value) {
            addCriterion("demo <=", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoLike(String value) {
            addCriterion("demo like", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoNotLike(String value) {
            addCriterion("demo not like", value, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoIn(List<String> values) {
            addCriterion("demo in", values, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoNotIn(List<String> values) {
            addCriterion("demo not in", values, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoBetween(String value1, String value2) {
            addCriterion("demo between", value1, value2, "demo");
            return (Criteria) this;
        }

        public Criteria andDemoNotBetween(String value1, String value2) {
            addCriterion("demo not between", value1, value2, "demo");
            return (Criteria) this;
        }

        public Criteria andVImgIsNull() {
            addCriterion("v_img is null");
            return (Criteria) this;
        }

        public Criteria andVImgIsNotNull() {
            addCriterion("v_img is not null");
            return (Criteria) this;
        }

        public Criteria andVImgEqualTo(String value) {
            addCriterion("v_img =", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgNotEqualTo(String value) {
            addCriterion("v_img <>", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgGreaterThan(String value) {
            addCriterion("v_img >", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgGreaterThanOrEqualTo(String value) {
            addCriterion("v_img >=", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgLessThan(String value) {
            addCriterion("v_img <", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgLessThanOrEqualTo(String value) {
            addCriterion("v_img <=", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgLike(String value) {
            addCriterion("v_img like", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgNotLike(String value) {
            addCriterion("v_img not like", value, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgIn(List<String> values) {
            addCriterion("v_img in", values, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgNotIn(List<String> values) {
            addCriterion("v_img not in", values, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgBetween(String value1, String value2) {
            addCriterion("v_img between", value1, value2, "vImg");
            return (Criteria) this;
        }

        public Criteria andVImgNotBetween(String value1, String value2) {
            addCriterion("v_img not between", value1, value2, "vImg");
            return (Criteria) this;
        }

        public Criteria andStepImgIsNull() {
            addCriterion("step_img is null");
            return (Criteria) this;
        }

        public Criteria andStepImgIsNotNull() {
            addCriterion("step_img is not null");
            return (Criteria) this;
        }

        public Criteria andStepImgEqualTo(String value) {
            addCriterion("step_img =", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgNotEqualTo(String value) {
            addCriterion("step_img <>", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgGreaterThan(String value) {
            addCriterion("step_img >", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgGreaterThanOrEqualTo(String value) {
            addCriterion("step_img >=", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgLessThan(String value) {
            addCriterion("step_img <", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgLessThanOrEqualTo(String value) {
            addCriterion("step_img <=", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgLike(String value) {
            addCriterion("step_img like", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgNotLike(String value) {
            addCriterion("step_img not like", value, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgIn(List<String> values) {
            addCriterion("step_img in", values, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgNotIn(List<String> values) {
            addCriterion("step_img not in", values, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgBetween(String value1, String value2) {
            addCriterion("step_img between", value1, value2, "stepImg");
            return (Criteria) this;
        }

        public Criteria andStepImgNotBetween(String value1, String value2) {
            addCriterion("step_img not between", value1, value2, "stepImg");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNull() {
            addCriterion("play_count is null");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNotNull() {
            addCriterion("play_count is not null");
            return (Criteria) this;
        }

        public Criteria andPlayCountEqualTo(Integer value) {
            addCriterion("play_count =", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotEqualTo(Integer value) {
            addCriterion("play_count <>", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThan(Integer value) {
            addCriterion("play_count >", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_count >=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThan(Integer value) {
            addCriterion("play_count <", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThanOrEqualTo(Integer value) {
            addCriterion("play_count <=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountIn(List<Integer> values) {
            addCriterion("play_count in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotIn(List<Integer> values) {
            addCriterion("play_count not in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountBetween(Integer value1, Integer value2) {
            addCriterion("play_count between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotBetween(Integer value1, Integer value2) {
            addCriterion("play_count not between", value1, value2, "playCount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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