package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSysUBeanDiscountpageRuleLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysUBeanDiscountpageRuleLogExample() {
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

        public Criteria andBdcIdIsNull() {
            addCriterion("bdc_id is null");
            return (Criteria) this;
        }

        public Criteria andBdcIdIsNotNull() {
            addCriterion("bdc_id is not null");
            return (Criteria) this;
        }

        public Criteria andBdcIdEqualTo(Integer value) {
            addCriterion("bdc_id =", value, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdNotEqualTo(Integer value) {
            addCriterion("bdc_id <>", value, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdGreaterThan(Integer value) {
            addCriterion("bdc_id >", value, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bdc_id >=", value, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdLessThan(Integer value) {
            addCriterion("bdc_id <", value, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdLessThanOrEqualTo(Integer value) {
            addCriterion("bdc_id <=", value, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdIn(List<Integer> values) {
            addCriterion("bdc_id in", values, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdNotIn(List<Integer> values) {
            addCriterion("bdc_id not in", values, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdBetween(Integer value1, Integer value2) {
            addCriterion("bdc_id between", value1, value2, "bdcId");
            return (Criteria) this;
        }

        public Criteria andBdcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bdc_id not between", value1, value2, "bdcId");
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

        public Criteria andDiscountpageValOldIsNull() {
            addCriterion("discountpage_val_old is null");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldIsNotNull() {
            addCriterion("discountpage_val_old is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldEqualTo(Integer value) {
            addCriterion("discountpage_val_old =", value, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldNotEqualTo(Integer value) {
            addCriterion("discountpage_val_old <>", value, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldGreaterThan(Integer value) {
            addCriterion("discountpage_val_old >", value, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldGreaterThanOrEqualTo(Integer value) {
            addCriterion("discountpage_val_old >=", value, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldLessThan(Integer value) {
            addCriterion("discountpage_val_old <", value, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldLessThanOrEqualTo(Integer value) {
            addCriterion("discountpage_val_old <=", value, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldIn(List<Integer> values) {
            addCriterion("discountpage_val_old in", values, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldNotIn(List<Integer> values) {
            addCriterion("discountpage_val_old not in", values, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldBetween(Integer value1, Integer value2) {
            addCriterion("discountpage_val_old between", value1, value2, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValOldNotBetween(Integer value1, Integer value2) {
            addCriterion("discountpage_val_old not between", value1, value2, "discountpageValOld");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewIsNull() {
            addCriterion("discountpage_val_new is null");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewIsNotNull() {
            addCriterion("discountpage_val_new is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewEqualTo(Integer value) {
            addCriterion("discountpage_val_new =", value, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewNotEqualTo(Integer value) {
            addCriterion("discountpage_val_new <>", value, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewGreaterThan(Integer value) {
            addCriterion("discountpage_val_new >", value, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("discountpage_val_new >=", value, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewLessThan(Integer value) {
            addCriterion("discountpage_val_new <", value, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewLessThanOrEqualTo(Integer value) {
            addCriterion("discountpage_val_new <=", value, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewIn(List<Integer> values) {
            addCriterion("discountpage_val_new in", values, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewNotIn(List<Integer> values) {
            addCriterion("discountpage_val_new not in", values, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewBetween(Integer value1, Integer value2) {
            addCriterion("discountpage_val_new between", value1, value2, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andDiscountpageValNewNotBetween(Integer value1, Integer value2) {
            addCriterion("discountpage_val_new not between", value1, value2, "discountpageValNew");
            return (Criteria) this;
        }

        public Criteria andMoneyOldIsNull() {
            addCriterion("money_old is null");
            return (Criteria) this;
        }

        public Criteria andMoneyOldIsNotNull() {
            addCriterion("money_old is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyOldEqualTo(Integer value) {
            addCriterion("money_old =", value, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldNotEqualTo(Integer value) {
            addCriterion("money_old <>", value, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldGreaterThan(Integer value) {
            addCriterion("money_old >", value, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_old >=", value, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldLessThan(Integer value) {
            addCriterion("money_old <", value, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldLessThanOrEqualTo(Integer value) {
            addCriterion("money_old <=", value, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldIn(List<Integer> values) {
            addCriterion("money_old in", values, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldNotIn(List<Integer> values) {
            addCriterion("money_old not in", values, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldBetween(Integer value1, Integer value2) {
            addCriterion("money_old between", value1, value2, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyOldNotBetween(Integer value1, Integer value2) {
            addCriterion("money_old not between", value1, value2, "moneyOld");
            return (Criteria) this;
        }

        public Criteria andMoneyNewIsNull() {
            addCriterion("money_new is null");
            return (Criteria) this;
        }

        public Criteria andMoneyNewIsNotNull() {
            addCriterion("money_new is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyNewEqualTo(Integer value) {
            addCriterion("money_new =", value, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewNotEqualTo(Integer value) {
            addCriterion("money_new <>", value, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewGreaterThan(Integer value) {
            addCriterion("money_new >", value, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_new >=", value, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewLessThan(Integer value) {
            addCriterion("money_new <", value, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewLessThanOrEqualTo(Integer value) {
            addCriterion("money_new <=", value, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewIn(List<Integer> values) {
            addCriterion("money_new in", values, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewNotIn(List<Integer> values) {
            addCriterion("money_new not in", values, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewBetween(Integer value1, Integer value2) {
            addCriterion("money_new between", value1, value2, "moneyNew");
            return (Criteria) this;
        }

        public Criteria andMoneyNewNotBetween(Integer value1, Integer value2) {
            addCriterion("money_new not between", value1, value2, "moneyNew");
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