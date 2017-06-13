package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbROrderGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbROrderGoodsExample() {
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(Integer value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(Integer value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(Integer value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(Integer value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(Integer value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<Integer> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<Integer> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(Integer value1, Integer value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(Integer value1, Integer value2) {
            addCriterion("o_id not between", value1, value2, "oId");
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

        public Criteria andPPriceIsNull() {
            addCriterion("P_price is null");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNotNull() {
            addCriterion("P_price is not null");
            return (Criteria) this;
        }

        public Criteria andPPriceEqualTo(Integer value) {
            addCriterion("P_price =", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotEqualTo(Integer value) {
            addCriterion("P_price <>", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThan(Integer value) {
            addCriterion("P_price >", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("P_price >=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThan(Integer value) {
            addCriterion("P_price <", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThanOrEqualTo(Integer value) {
            addCriterion("P_price <=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceIn(List<Integer> values) {
            addCriterion("P_price in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotIn(List<Integer> values) {
            addCriterion("P_price not in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceBetween(Integer value1, Integer value2) {
            addCriterion("P_price between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("P_price not between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andLargMenNumIsNull() {
            addCriterion("larg_men_num is null");
            return (Criteria) this;
        }

        public Criteria andLargMenNumIsNotNull() {
            addCriterion("larg_men_num is not null");
            return (Criteria) this;
        }

        public Criteria andLargMenNumEqualTo(Integer value) {
            addCriterion("larg_men_num =", value, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumNotEqualTo(Integer value) {
            addCriterion("larg_men_num <>", value, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumGreaterThan(Integer value) {
            addCriterion("larg_men_num >", value, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("larg_men_num >=", value, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumLessThan(Integer value) {
            addCriterion("larg_men_num <", value, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumLessThanOrEqualTo(Integer value) {
            addCriterion("larg_men_num <=", value, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumIn(List<Integer> values) {
            addCriterion("larg_men_num in", values, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumNotIn(List<Integer> values) {
            addCriterion("larg_men_num not in", values, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumBetween(Integer value1, Integer value2) {
            addCriterion("larg_men_num between", value1, value2, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andLargMenNumNotBetween(Integer value1, Integer value2) {
            addCriterion("larg_men_num not between", value1, value2, "largMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumIsNull() {
            addCriterion("small_men_num is null");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumIsNotNull() {
            addCriterion("small_men_num is not null");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumEqualTo(Integer value) {
            addCriterion("small_men_num =", value, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumNotEqualTo(Integer value) {
            addCriterion("small_men_num <>", value, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumGreaterThan(Integer value) {
            addCriterion("small_men_num >", value, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("small_men_num >=", value, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumLessThan(Integer value) {
            addCriterion("small_men_num <", value, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumLessThanOrEqualTo(Integer value) {
            addCriterion("small_men_num <=", value, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumIn(List<Integer> values) {
            addCriterion("small_men_num in", values, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumNotIn(List<Integer> values) {
            addCriterion("small_men_num not in", values, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumBetween(Integer value1, Integer value2) {
            addCriterion("small_men_num between", value1, value2, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andSmallMenNumNotBetween(Integer value1, Integer value2) {
            addCriterion("small_men_num not between", value1, value2, "smallMenNum");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
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

        public Criteria andSendNumIsNull() {
            addCriterion("send_num is null");
            return (Criteria) this;
        }

        public Criteria andSendNumIsNotNull() {
            addCriterion("send_num is not null");
            return (Criteria) this;
        }

        public Criteria andSendNumEqualTo(Integer value) {
            addCriterion("send_num =", value, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumNotEqualTo(Integer value) {
            addCriterion("send_num <>", value, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumGreaterThan(Integer value) {
            addCriterion("send_num >", value, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_num >=", value, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumLessThan(Integer value) {
            addCriterion("send_num <", value, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumLessThanOrEqualTo(Integer value) {
            addCriterion("send_num <=", value, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumIn(List<Integer> values) {
            addCriterion("send_num in", values, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumNotIn(List<Integer> values) {
            addCriterion("send_num not in", values, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumBetween(Integer value1, Integer value2) {
            addCriterion("send_num between", value1, value2, "sendNum");
            return (Criteria) this;
        }

        public Criteria andSendNumNotBetween(Integer value1, Integer value2) {
            addCriterion("send_num not between", value1, value2, "sendNum");
            return (Criteria) this;
        }

        public Criteria andCPriceIsNull() {
            addCriterion("c_price is null");
            return (Criteria) this;
        }

        public Criteria andCPriceIsNotNull() {
            addCriterion("c_price is not null");
            return (Criteria) this;
        }

        public Criteria andCPriceEqualTo(Integer value) {
            addCriterion("c_price =", value, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceNotEqualTo(Integer value) {
            addCriterion("c_price <>", value, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceGreaterThan(Integer value) {
            addCriterion("c_price >", value, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_price >=", value, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceLessThan(Integer value) {
            addCriterion("c_price <", value, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceLessThanOrEqualTo(Integer value) {
            addCriterion("c_price <=", value, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceIn(List<Integer> values) {
            addCriterion("c_price in", values, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceNotIn(List<Integer> values) {
            addCriterion("c_price not in", values, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceBetween(Integer value1, Integer value2) {
            addCriterion("c_price between", value1, value2, "cPrice");
            return (Criteria) this;
        }

        public Criteria andCPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("c_price not between", value1, value2, "cPrice");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
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