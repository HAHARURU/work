package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSysBeanChangeRoleLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysBeanChangeRoleLogExample() {
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

        public Criteria andBcrIdIsNull() {
            addCriterion("bcr_id is null");
            return (Criteria) this;
        }

        public Criteria andBcrIdIsNotNull() {
            addCriterion("bcr_id is not null");
            return (Criteria) this;
        }

        public Criteria andBcrIdEqualTo(Integer value) {
            addCriterion("bcr_id =", value, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdNotEqualTo(Integer value) {
            addCriterion("bcr_id <>", value, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdGreaterThan(Integer value) {
            addCriterion("bcr_id >", value, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bcr_id >=", value, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdLessThan(Integer value) {
            addCriterion("bcr_id <", value, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdLessThanOrEqualTo(Integer value) {
            addCriterion("bcr_id <=", value, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdIn(List<Integer> values) {
            addCriterion("bcr_id in", values, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdNotIn(List<Integer> values) {
            addCriterion("bcr_id not in", values, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdBetween(Integer value1, Integer value2) {
            addCriterion("bcr_id between", value1, value2, "bcrId");
            return (Criteria) this;
        }

        public Criteria andBcrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bcr_id not between", value1, value2, "bcrId");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andBeanValOldIsNull() {
            addCriterion("bean_val_old is null");
            return (Criteria) this;
        }

        public Criteria andBeanValOldIsNotNull() {
            addCriterion("bean_val_old is not null");
            return (Criteria) this;
        }

        public Criteria andBeanValOldEqualTo(Integer value) {
            addCriterion("bean_val_old =", value, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldNotEqualTo(Integer value) {
            addCriterion("bean_val_old <>", value, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldGreaterThan(Integer value) {
            addCriterion("bean_val_old >", value, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldGreaterThanOrEqualTo(Integer value) {
            addCriterion("bean_val_old >=", value, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldLessThan(Integer value) {
            addCriterion("bean_val_old <", value, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldLessThanOrEqualTo(Integer value) {
            addCriterion("bean_val_old <=", value, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldIn(List<Integer> values) {
            addCriterion("bean_val_old in", values, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldNotIn(List<Integer> values) {
            addCriterion("bean_val_old not in", values, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_old between", value1, value2, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValOldNotBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_old not between", value1, value2, "beanValOld");
            return (Criteria) this;
        }

        public Criteria andBeanValNewIsNull() {
            addCriterion("bean_val_new is null");
            return (Criteria) this;
        }

        public Criteria andBeanValNewIsNotNull() {
            addCriterion("bean_val_new is not null");
            return (Criteria) this;
        }

        public Criteria andBeanValNewEqualTo(Integer value) {
            addCriterion("bean_val_new =", value, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewNotEqualTo(Integer value) {
            addCriterion("bean_val_new <>", value, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewGreaterThan(Integer value) {
            addCriterion("bean_val_new >", value, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("bean_val_new >=", value, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewLessThan(Integer value) {
            addCriterion("bean_val_new <", value, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewLessThanOrEqualTo(Integer value) {
            addCriterion("bean_val_new <=", value, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewIn(List<Integer> values) {
            addCriterion("bean_val_new in", values, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewNotIn(List<Integer> values) {
            addCriterion("bean_val_new not in", values, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_new between", value1, value2, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValNewNotBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_new not between", value1, value2, "beanValNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldIsNull() {
            addCriterion("bean_val_another_old is null");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldIsNotNull() {
            addCriterion("bean_val_another_old is not null");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldEqualTo(Integer value) {
            addCriterion("bean_val_another_old =", value, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldNotEqualTo(Integer value) {
            addCriterion("bean_val_another_old <>", value, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldGreaterThan(Integer value) {
            addCriterion("bean_val_another_old >", value, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldGreaterThanOrEqualTo(Integer value) {
            addCriterion("bean_val_another_old >=", value, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldLessThan(Integer value) {
            addCriterion("bean_val_another_old <", value, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldLessThanOrEqualTo(Integer value) {
            addCriterion("bean_val_another_old <=", value, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldIn(List<Integer> values) {
            addCriterion("bean_val_another_old in", values, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldNotIn(List<Integer> values) {
            addCriterion("bean_val_another_old not in", values, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_another_old between", value1, value2, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherOldNotBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_another_old not between", value1, value2, "beanValAnotherOld");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewIsNull() {
            addCriterion("bean_val_another_new is null");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewIsNotNull() {
            addCriterion("bean_val_another_new is not null");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewEqualTo(Integer value) {
            addCriterion("bean_val_another_new =", value, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewNotEqualTo(Integer value) {
            addCriterion("bean_val_another_new <>", value, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewGreaterThan(Integer value) {
            addCriterion("bean_val_another_new >", value, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("bean_val_another_new >=", value, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewLessThan(Integer value) {
            addCriterion("bean_val_another_new <", value, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewLessThanOrEqualTo(Integer value) {
            addCriterion("bean_val_another_new <=", value, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewIn(List<Integer> values) {
            addCriterion("bean_val_another_new in", values, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewNotIn(List<Integer> values) {
            addCriterion("bean_val_another_new not in", values, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_another_new between", value1, value2, "beanValAnotherNew");
            return (Criteria) this;
        }

        public Criteria andBeanValAnotherNewNotBetween(Integer value1, Integer value2) {
            addCriterion("bean_val_another_new not between", value1, value2, "beanValAnotherNew");
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