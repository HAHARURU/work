package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSysUBeanDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysUBeanDetailExample() {
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(Integer value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(Integer value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(Integer value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(Integer value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(Integer value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(Integer value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<Integer> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<Integer> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(Integer value1, Integer value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(Integer value1, Integer value2) {
            addCriterion("action not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andDescribebeanIsNull() {
            addCriterion("describeBean is null");
            return (Criteria) this;
        }

        public Criteria andDescribebeanIsNotNull() {
            addCriterion("describeBean is not null");
            return (Criteria) this;
        }

        public Criteria andDescribebeanEqualTo(String value) {
            addCriterion("describeBean =", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanNotEqualTo(String value) {
            addCriterion("describeBean <>", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanGreaterThan(String value) {
            addCriterion("describeBean >", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanGreaterThanOrEqualTo(String value) {
            addCriterion("describeBean >=", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanLessThan(String value) {
            addCriterion("describeBean <", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanLessThanOrEqualTo(String value) {
            addCriterion("describeBean <=", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanLike(String value) {
            addCriterion("describeBean like", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanNotLike(String value) {
            addCriterion("describeBean not like", value, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanIn(List<String> values) {
            addCriterion("describeBean in", values, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanNotIn(List<String> values) {
            addCriterion("describeBean not in", values, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanBetween(String value1, String value2) {
            addCriterion("describeBean between", value1, value2, "describebean");
            return (Criteria) this;
        }

        public Criteria andDescribebeanNotBetween(String value1, String value2) {
            addCriterion("describeBean not between", value1, value2, "describebean");
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

        public Criteria andIncomePayIsNull() {
            addCriterion("income_pay is null");
            return (Criteria) this;
        }

        public Criteria andIncomePayIsNotNull() {
            addCriterion("income_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIncomePayEqualTo(Integer value) {
            addCriterion("income_pay =", value, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayNotEqualTo(Integer value) {
            addCriterion("income_pay <>", value, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayGreaterThan(Integer value) {
            addCriterion("income_pay >", value, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayGreaterThanOrEqualTo(Integer value) {
            addCriterion("income_pay >=", value, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayLessThan(Integer value) {
            addCriterion("income_pay <", value, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayLessThanOrEqualTo(Integer value) {
            addCriterion("income_pay <=", value, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayIn(List<Integer> values) {
            addCriterion("income_pay in", values, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayNotIn(List<Integer> values) {
            addCriterion("income_pay not in", values, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayBetween(Integer value1, Integer value2) {
            addCriterion("income_pay between", value1, value2, "incomePay");
            return (Criteria) this;
        }

        public Criteria andIncomePayNotBetween(Integer value1, Integer value2) {
            addCriterion("income_pay not between", value1, value2, "incomePay");
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