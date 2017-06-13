package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSysOgAddExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysOgAddExample() {
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

        public Criteria andROgIdIsNull() {
            addCriterion("r_og_id is null");
            return (Criteria) this;
        }

        public Criteria andROgIdIsNotNull() {
            addCriterion("r_og_id is not null");
            return (Criteria) this;
        }

        public Criteria andROgIdEqualTo(Integer value) {
            addCriterion("r_og_id =", value, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdNotEqualTo(Integer value) {
            addCriterion("r_og_id <>", value, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdGreaterThan(Integer value) {
            addCriterion("r_og_id >", value, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_og_id >=", value, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdLessThan(Integer value) {
            addCriterion("r_og_id <", value, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_og_id <=", value, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdIn(List<Integer> values) {
            addCriterion("r_og_id in", values, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdNotIn(List<Integer> values) {
            addCriterion("r_og_id not in", values, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdBetween(Integer value1, Integer value2) {
            addCriterion("r_og_id between", value1, value2, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_og_id not between", value1, value2, "rOgId");
            return (Criteria) this;
        }

        public Criteria andROgNameIsNull() {
            addCriterion("r_og_name is null");
            return (Criteria) this;
        }

        public Criteria andROgNameIsNotNull() {
            addCriterion("r_og_name is not null");
            return (Criteria) this;
        }

        public Criteria andROgNameEqualTo(String value) {
            addCriterion("r_og_name =", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameNotEqualTo(String value) {
            addCriterion("r_og_name <>", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameGreaterThan(String value) {
            addCriterion("r_og_name >", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_og_name >=", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameLessThan(String value) {
            addCriterion("r_og_name <", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameLessThanOrEqualTo(String value) {
            addCriterion("r_og_name <=", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameLike(String value) {
            addCriterion("r_og_name like", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameNotLike(String value) {
            addCriterion("r_og_name not like", value, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameIn(List<String> values) {
            addCriterion("r_og_name in", values, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameNotIn(List<String> values) {
            addCriterion("r_og_name not in", values, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameBetween(String value1, String value2) {
            addCriterion("r_og_name between", value1, value2, "rOgName");
            return (Criteria) this;
        }

        public Criteria andROgNameNotBetween(String value1, String value2) {
            addCriterion("r_og_name not between", value1, value2, "rOgName");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNumIsNull() {
            addCriterion("p_id_num is null");
            return (Criteria) this;
        }

        public Criteria andPIdNumIsNotNull() {
            addCriterion("p_id_num is not null");
            return (Criteria) this;
        }

        public Criteria andPIdNumEqualTo(Integer value) {
            addCriterion("p_id_num =", value, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumNotEqualTo(Integer value) {
            addCriterion("p_id_num <>", value, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumGreaterThan(Integer value) {
            addCriterion("p_id_num >", value, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id_num >=", value, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumLessThan(Integer value) {
            addCriterion("p_id_num <", value, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumLessThanOrEqualTo(Integer value) {
            addCriterion("p_id_num <=", value, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumIn(List<Integer> values) {
            addCriterion("p_id_num in", values, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumNotIn(List<Integer> values) {
            addCriterion("p_id_num not in", values, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumBetween(Integer value1, Integer value2) {
            addCriterion("p_id_num between", value1, value2, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdNumNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id_num not between", value1, value2, "pIdNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddIsNull() {
            addCriterion("p_id_add is null");
            return (Criteria) this;
        }

        public Criteria andPIdAddIsNotNull() {
            addCriterion("p_id_add is not null");
            return (Criteria) this;
        }

        public Criteria andPIdAddEqualTo(Integer value) {
            addCriterion("p_id_add =", value, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddNotEqualTo(Integer value) {
            addCriterion("p_id_add <>", value, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddGreaterThan(Integer value) {
            addCriterion("p_id_add >", value, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id_add >=", value, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddLessThan(Integer value) {
            addCriterion("p_id_add <", value, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddLessThanOrEqualTo(Integer value) {
            addCriterion("p_id_add <=", value, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddIn(List<Integer> values) {
            addCriterion("p_id_add in", values, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddNotIn(List<Integer> values) {
            addCriterion("p_id_add not in", values, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddBetween(Integer value1, Integer value2) {
            addCriterion("p_id_add between", value1, value2, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id_add not between", value1, value2, "pIdAdd");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumIsNull() {
            addCriterion("p_id_add_num is null");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumIsNotNull() {
            addCriterion("p_id_add_num is not null");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumEqualTo(Integer value) {
            addCriterion("p_id_add_num =", value, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumNotEqualTo(Integer value) {
            addCriterion("p_id_add_num <>", value, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumGreaterThan(Integer value) {
            addCriterion("p_id_add_num >", value, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id_add_num >=", value, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumLessThan(Integer value) {
            addCriterion("p_id_add_num <", value, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumLessThanOrEqualTo(Integer value) {
            addCriterion("p_id_add_num <=", value, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumIn(List<Integer> values) {
            addCriterion("p_id_add_num in", values, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumNotIn(List<Integer> values) {
            addCriterion("p_id_add_num not in", values, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumBetween(Integer value1, Integer value2) {
            addCriterion("p_id_add_num between", value1, value2, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andPIdAddNumNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id_add_num not between", value1, value2, "pIdAddNum");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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