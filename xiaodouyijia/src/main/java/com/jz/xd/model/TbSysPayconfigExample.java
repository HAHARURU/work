package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSysPayconfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysPayconfigExample() {
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

        public Criteria andPaysIdIsNull() {
            addCriterion("pays_id is null");
            return (Criteria) this;
        }

        public Criteria andPaysIdIsNotNull() {
            addCriterion("pays_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaysIdEqualTo(Integer value) {
            addCriterion("pays_id =", value, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdNotEqualTo(Integer value) {
            addCriterion("pays_id <>", value, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdGreaterThan(Integer value) {
            addCriterion("pays_id >", value, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pays_id >=", value, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdLessThan(Integer value) {
            addCriterion("pays_id <", value, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdLessThanOrEqualTo(Integer value) {
            addCriterion("pays_id <=", value, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdIn(List<Integer> values) {
            addCriterion("pays_id in", values, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdNotIn(List<Integer> values) {
            addCriterion("pays_id not in", values, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdBetween(Integer value1, Integer value2) {
            addCriterion("pays_id between", value1, value2, "paysId");
            return (Criteria) this;
        }

        public Criteria andPaysIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pays_id not between", value1, value2, "paysId");
            return (Criteria) this;
        }

        public Criteria andWxAppidIsNull() {
            addCriterion("wx_appid is null");
            return (Criteria) this;
        }

        public Criteria andWxAppidIsNotNull() {
            addCriterion("wx_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWxAppidEqualTo(String value) {
            addCriterion("wx_appid =", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotEqualTo(String value) {
            addCriterion("wx_appid <>", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidGreaterThan(String value) {
            addCriterion("wx_appid >", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_appid >=", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidLessThan(String value) {
            addCriterion("wx_appid <", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidLessThanOrEqualTo(String value) {
            addCriterion("wx_appid <=", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidLike(String value) {
            addCriterion("wx_appid like", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotLike(String value) {
            addCriterion("wx_appid not like", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidIn(List<String> values) {
            addCriterion("wx_appid in", values, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotIn(List<String> values) {
            addCriterion("wx_appid not in", values, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidBetween(String value1, String value2) {
            addCriterion("wx_appid between", value1, value2, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotBetween(String value1, String value2) {
            addCriterion("wx_appid not between", value1, value2, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxMachidIsNull() {
            addCriterion("wx_machid is null");
            return (Criteria) this;
        }

        public Criteria andWxMachidIsNotNull() {
            addCriterion("wx_machid is not null");
            return (Criteria) this;
        }

        public Criteria andWxMachidEqualTo(String value) {
            addCriterion("wx_machid =", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidNotEqualTo(String value) {
            addCriterion("wx_machid <>", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidGreaterThan(String value) {
            addCriterion("wx_machid >", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_machid >=", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidLessThan(String value) {
            addCriterion("wx_machid <", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidLessThanOrEqualTo(String value) {
            addCriterion("wx_machid <=", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidLike(String value) {
            addCriterion("wx_machid like", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidNotLike(String value) {
            addCriterion("wx_machid not like", value, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidIn(List<String> values) {
            addCriterion("wx_machid in", values, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidNotIn(List<String> values) {
            addCriterion("wx_machid not in", values, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidBetween(String value1, String value2) {
            addCriterion("wx_machid between", value1, value2, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxMachidNotBetween(String value1, String value2) {
            addCriterion("wx_machid not between", value1, value2, "wxMachid");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyIsNull() {
            addCriterion("wx_pay_key is null");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyIsNotNull() {
            addCriterion("wx_pay_key is not null");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyEqualTo(String value) {
            addCriterion("wx_pay_key =", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyNotEqualTo(String value) {
            addCriterion("wx_pay_key <>", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyGreaterThan(String value) {
            addCriterion("wx_pay_key >", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyGreaterThanOrEqualTo(String value) {
            addCriterion("wx_pay_key >=", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyLessThan(String value) {
            addCriterion("wx_pay_key <", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyLessThanOrEqualTo(String value) {
            addCriterion("wx_pay_key <=", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyLike(String value) {
            addCriterion("wx_pay_key like", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyNotLike(String value) {
            addCriterion("wx_pay_key not like", value, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyIn(List<String> values) {
            addCriterion("wx_pay_key in", values, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyNotIn(List<String> values) {
            addCriterion("wx_pay_key not in", values, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyBetween(String value1, String value2) {
            addCriterion("wx_pay_key between", value1, value2, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andWxPayKeyNotBetween(String value1, String value2) {
            addCriterion("wx_pay_key not between", value1, value2, "wxPayKey");
            return (Criteria) this;
        }

        public Criteria andAliAppidIsNull() {
            addCriterion("ali_appid is null");
            return (Criteria) this;
        }

        public Criteria andAliAppidIsNotNull() {
            addCriterion("ali_appid is not null");
            return (Criteria) this;
        }

        public Criteria andAliAppidEqualTo(String value) {
            addCriterion("ali_appid =", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidNotEqualTo(String value) {
            addCriterion("ali_appid <>", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidGreaterThan(String value) {
            addCriterion("ali_appid >", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidGreaterThanOrEqualTo(String value) {
            addCriterion("ali_appid >=", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidLessThan(String value) {
            addCriterion("ali_appid <", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidLessThanOrEqualTo(String value) {
            addCriterion("ali_appid <=", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidLike(String value) {
            addCriterion("ali_appid like", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidNotLike(String value) {
            addCriterion("ali_appid not like", value, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidIn(List<String> values) {
            addCriterion("ali_appid in", values, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidNotIn(List<String> values) {
            addCriterion("ali_appid not in", values, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidBetween(String value1, String value2) {
            addCriterion("ali_appid between", value1, value2, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliAppidNotBetween(String value1, String value2) {
            addCriterion("ali_appid not between", value1, value2, "aliAppid");
            return (Criteria) this;
        }

        public Criteria andAliPidIsNull() {
            addCriterion("ali_pid is null");
            return (Criteria) this;
        }

        public Criteria andAliPidIsNotNull() {
            addCriterion("ali_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAliPidEqualTo(String value) {
            addCriterion("ali_pid =", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidNotEqualTo(String value) {
            addCriterion("ali_pid <>", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidGreaterThan(String value) {
            addCriterion("ali_pid >", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidGreaterThanOrEqualTo(String value) {
            addCriterion("ali_pid >=", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidLessThan(String value) {
            addCriterion("ali_pid <", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidLessThanOrEqualTo(String value) {
            addCriterion("ali_pid <=", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidLike(String value) {
            addCriterion("ali_pid like", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidNotLike(String value) {
            addCriterion("ali_pid not like", value, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidIn(List<String> values) {
            addCriterion("ali_pid in", values, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidNotIn(List<String> values) {
            addCriterion("ali_pid not in", values, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidBetween(String value1, String value2) {
            addCriterion("ali_pid between", value1, value2, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPidNotBetween(String value1, String value2) {
            addCriterion("ali_pid not between", value1, value2, "aliPid");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyIsNull() {
            addCriterion("ali_public_key is null");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyIsNotNull() {
            addCriterion("ali_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyEqualTo(String value) {
            addCriterion("ali_public_key =", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyNotEqualTo(String value) {
            addCriterion("ali_public_key <>", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyGreaterThan(String value) {
            addCriterion("ali_public_key >", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ali_public_key >=", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyLessThan(String value) {
            addCriterion("ali_public_key <", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("ali_public_key <=", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyLike(String value) {
            addCriterion("ali_public_key like", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyNotLike(String value) {
            addCriterion("ali_public_key not like", value, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyIn(List<String> values) {
            addCriterion("ali_public_key in", values, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyNotIn(List<String> values) {
            addCriterion("ali_public_key not in", values, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyBetween(String value1, String value2) {
            addCriterion("ali_public_key between", value1, value2, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPublicKeyNotBetween(String value1, String value2) {
            addCriterion("ali_public_key not between", value1, value2, "aliPublicKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyIsNull() {
            addCriterion("ali_private_key is null");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyIsNotNull() {
            addCriterion("ali_private_key is not null");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyEqualTo(String value) {
            addCriterion("ali_private_key =", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyNotEqualTo(String value) {
            addCriterion("ali_private_key <>", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyGreaterThan(String value) {
            addCriterion("ali_private_key >", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ali_private_key >=", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyLessThan(String value) {
            addCriterion("ali_private_key <", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("ali_private_key <=", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyLike(String value) {
            addCriterion("ali_private_key like", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyNotLike(String value) {
            addCriterion("ali_private_key not like", value, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyIn(List<String> values) {
            addCriterion("ali_private_key in", values, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyNotIn(List<String> values) {
            addCriterion("ali_private_key not in", values, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyBetween(String value1, String value2) {
            addCriterion("ali_private_key between", value1, value2, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAliPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("ali_private_key not between", value1, value2, "aliPrivateKey");
            return (Criteria) this;
        }

        public Criteria andCUnionCardIsNull() {
            addCriterion("c_union_card is null");
            return (Criteria) this;
        }

        public Criteria andCUnionCardIsNotNull() {
            addCriterion("c_union_card is not null");
            return (Criteria) this;
        }

        public Criteria andCUnionCardEqualTo(String value) {
            addCriterion("c_union_card =", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardNotEqualTo(String value) {
            addCriterion("c_union_card <>", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardGreaterThan(String value) {
            addCriterion("c_union_card >", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardGreaterThanOrEqualTo(String value) {
            addCriterion("c_union_card >=", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardLessThan(String value) {
            addCriterion("c_union_card <", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardLessThanOrEqualTo(String value) {
            addCriterion("c_union_card <=", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardLike(String value) {
            addCriterion("c_union_card like", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardNotLike(String value) {
            addCriterion("c_union_card not like", value, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardIn(List<String> values) {
            addCriterion("c_union_card in", values, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardNotIn(List<String> values) {
            addCriterion("c_union_card not in", values, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardBetween(String value1, String value2) {
            addCriterion("c_union_card between", value1, value2, "cUnionCard");
            return (Criteria) this;
        }

        public Criteria andCUnionCardNotBetween(String value1, String value2) {
            addCriterion("c_union_card not between", value1, value2, "cUnionCard");
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

        public Criteria andUIdEqualTo(String value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(String value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(String value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(String value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(String value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(String value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLike(String value) {
            addCriterion("u_id like", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotLike(String value) {
            addCriterion("u_id not like", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<String> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<String> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(String value1, String value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(String value1, String value2) {
            addCriterion("u_id not between", value1, value2, "uId");
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