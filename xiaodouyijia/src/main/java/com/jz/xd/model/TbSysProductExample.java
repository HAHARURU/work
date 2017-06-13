package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSysProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysProductExample() {
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

        public Criteria andPTypeIsNull() {
            addCriterion("p_type is null");
            return (Criteria) this;
        }

        public Criteria andPTypeIsNotNull() {
            addCriterion("p_type is not null");
            return (Criteria) this;
        }

        public Criteria andPTypeEqualTo(Integer value) {
            addCriterion("p_type =", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotEqualTo(Integer value) {
            addCriterion("p_type <>", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeGreaterThan(Integer value) {
            addCriterion("p_type >", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_type >=", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLessThan(Integer value) {
            addCriterion("p_type <", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLessThanOrEqualTo(Integer value) {
            addCriterion("p_type <=", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeIn(List<Integer> values) {
            addCriterion("p_type in", values, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotIn(List<Integer> values) {
            addCriterion("p_type not in", values, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeBetween(Integer value1, Integer value2) {
            addCriterion("p_type between", value1, value2, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("p_type not between", value1, value2, "pType");
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

        public Criteria andPUnitIsNull() {
            addCriterion("p_unit is null");
            return (Criteria) this;
        }

        public Criteria andPUnitIsNotNull() {
            addCriterion("p_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPUnitEqualTo(Integer value) {
            addCriterion("p_unit =", value, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitNotEqualTo(Integer value) {
            addCriterion("p_unit <>", value, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitGreaterThan(Integer value) {
            addCriterion("p_unit >", value, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_unit >=", value, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitLessThan(Integer value) {
            addCriterion("p_unit <", value, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitLessThanOrEqualTo(Integer value) {
            addCriterion("p_unit <=", value, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitIn(List<Integer> values) {
            addCriterion("p_unit in", values, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitNotIn(List<Integer> values) {
            addCriterion("p_unit not in", values, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitBetween(Integer value1, Integer value2) {
            addCriterion("p_unit between", value1, value2, "pUnit");
            return (Criteria) this;
        }

        public Criteria andPUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("p_unit not between", value1, value2, "pUnit");
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

        public Criteria andImg1IsNull() {
            addCriterion("img_1 is null");
            return (Criteria) this;
        }

        public Criteria andImg1IsNotNull() {
            addCriterion("img_1 is not null");
            return (Criteria) this;
        }

        public Criteria andImg1EqualTo(String value) {
            addCriterion("img_1 =", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotEqualTo(String value) {
            addCriterion("img_1 <>", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1GreaterThan(String value) {
            addCriterion("img_1 >", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1GreaterThanOrEqualTo(String value) {
            addCriterion("img_1 >=", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1LessThan(String value) {
            addCriterion("img_1 <", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1LessThanOrEqualTo(String value) {
            addCriterion("img_1 <=", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1Like(String value) {
            addCriterion("img_1 like", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotLike(String value) {
            addCriterion("img_1 not like", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1In(List<String> values) {
            addCriterion("img_1 in", values, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotIn(List<String> values) {
            addCriterion("img_1 not in", values, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1Between(String value1, String value2) {
            addCriterion("img_1 between", value1, value2, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotBetween(String value1, String value2) {
            addCriterion("img_1 not between", value1, value2, "img1");
            return (Criteria) this;
        }

        public Criteria andImg2IsNull() {
            addCriterion("img_2 is null");
            return (Criteria) this;
        }

        public Criteria andImg2IsNotNull() {
            addCriterion("img_2 is not null");
            return (Criteria) this;
        }

        public Criteria andImg2EqualTo(String value) {
            addCriterion("img_2 =", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotEqualTo(String value) {
            addCriterion("img_2 <>", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2GreaterThan(String value) {
            addCriterion("img_2 >", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2GreaterThanOrEqualTo(String value) {
            addCriterion("img_2 >=", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2LessThan(String value) {
            addCriterion("img_2 <", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2LessThanOrEqualTo(String value) {
            addCriterion("img_2 <=", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2Like(String value) {
            addCriterion("img_2 like", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotLike(String value) {
            addCriterion("img_2 not like", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2In(List<String> values) {
            addCriterion("img_2 in", values, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotIn(List<String> values) {
            addCriterion("img_2 not in", values, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2Between(String value1, String value2) {
            addCriterion("img_2 between", value1, value2, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotBetween(String value1, String value2) {
            addCriterion("img_2 not between", value1, value2, "img2");
            return (Criteria) this;
        }

        public Criteria andImg3IsNull() {
            addCriterion("img_3 is null");
            return (Criteria) this;
        }

        public Criteria andImg3IsNotNull() {
            addCriterion("img_3 is not null");
            return (Criteria) this;
        }

        public Criteria andImg3EqualTo(String value) {
            addCriterion("img_3 =", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotEqualTo(String value) {
            addCriterion("img_3 <>", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3GreaterThan(String value) {
            addCriterion("img_3 >", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3GreaterThanOrEqualTo(String value) {
            addCriterion("img_3 >=", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3LessThan(String value) {
            addCriterion("img_3 <", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3LessThanOrEqualTo(String value) {
            addCriterion("img_3 <=", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3Like(String value) {
            addCriterion("img_3 like", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotLike(String value) {
            addCriterion("img_3 not like", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3In(List<String> values) {
            addCriterion("img_3 in", values, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotIn(List<String> values) {
            addCriterion("img_3 not in", values, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3Between(String value1, String value2) {
            addCriterion("img_3 between", value1, value2, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotBetween(String value1, String value2) {
            addCriterion("img_3 not between", value1, value2, "img3");
            return (Criteria) this;
        }

        public Criteria andPAgeIsNull() {
            addCriterion("p_age is null");
            return (Criteria) this;
        }

        public Criteria andPAgeIsNotNull() {
            addCriterion("p_age is not null");
            return (Criteria) this;
        }

        public Criteria andPAgeEqualTo(String value) {
            addCriterion("p_age =", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotEqualTo(String value) {
            addCriterion("p_age <>", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeGreaterThan(String value) {
            addCriterion("p_age >", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeGreaterThanOrEqualTo(String value) {
            addCriterion("p_age >=", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeLessThan(String value) {
            addCriterion("p_age <", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeLessThanOrEqualTo(String value) {
            addCriterion("p_age <=", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeLike(String value) {
            addCriterion("p_age like", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotLike(String value) {
            addCriterion("p_age not like", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeIn(List<String> values) {
            addCriterion("p_age in", values, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotIn(List<String> values) {
            addCriterion("p_age not in", values, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeBetween(String value1, String value2) {
            addCriterion("p_age between", value1, value2, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotBetween(String value1, String value2) {
            addCriterion("p_age not between", value1, value2, "pAge");
            return (Criteria) this;
        }

        public Criteria andPMonthIsNull() {
            addCriterion("p_month is null");
            return (Criteria) this;
        }

        public Criteria andPMonthIsNotNull() {
            addCriterion("p_month is not null");
            return (Criteria) this;
        }

        public Criteria andPMonthEqualTo(String value) {
            addCriterion("p_month =", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthNotEqualTo(String value) {
            addCriterion("p_month <>", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthGreaterThan(String value) {
            addCriterion("p_month >", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthGreaterThanOrEqualTo(String value) {
            addCriterion("p_month >=", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthLessThan(String value) {
            addCriterion("p_month <", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthLessThanOrEqualTo(String value) {
            addCriterion("p_month <=", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthLike(String value) {
            addCriterion("p_month like", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthNotLike(String value) {
            addCriterion("p_month not like", value, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthIn(List<String> values) {
            addCriterion("p_month in", values, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthNotIn(List<String> values) {
            addCriterion("p_month not in", values, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthBetween(String value1, String value2) {
            addCriterion("p_month between", value1, value2, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPMonthNotBetween(String value1, String value2) {
            addCriterion("p_month not between", value1, value2, "pMonth");
            return (Criteria) this;
        }

        public Criteria andPKindIsNull() {
            addCriterion("p_kind is null");
            return (Criteria) this;
        }

        public Criteria andPKindIsNotNull() {
            addCriterion("p_kind is not null");
            return (Criteria) this;
        }

        public Criteria andPKindEqualTo(String value) {
            addCriterion("p_kind =", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindNotEqualTo(String value) {
            addCriterion("p_kind <>", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindGreaterThan(String value) {
            addCriterion("p_kind >", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindGreaterThanOrEqualTo(String value) {
            addCriterion("p_kind >=", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindLessThan(String value) {
            addCriterion("p_kind <", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindLessThanOrEqualTo(String value) {
            addCriterion("p_kind <=", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindLike(String value) {
            addCriterion("p_kind like", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindNotLike(String value) {
            addCriterion("p_kind not like", value, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindIn(List<String> values) {
            addCriterion("p_kind in", values, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindNotIn(List<String> values) {
            addCriterion("p_kind not in", values, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindBetween(String value1, String value2) {
            addCriterion("p_kind between", value1, value2, "pKind");
            return (Criteria) this;
        }

        public Criteria andPKindNotBetween(String value1, String value2) {
            addCriterion("p_kind not between", value1, value2, "pKind");
            return (Criteria) this;
        }

        public Criteria andPSexIsNull() {
            addCriterion("p_sex is null");
            return (Criteria) this;
        }

        public Criteria andPSexIsNotNull() {
            addCriterion("p_sex is not null");
            return (Criteria) this;
        }

        public Criteria andPSexEqualTo(String value) {
            addCriterion("p_sex =", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotEqualTo(String value) {
            addCriterion("p_sex <>", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexGreaterThan(String value) {
            addCriterion("p_sex >", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexGreaterThanOrEqualTo(String value) {
            addCriterion("p_sex >=", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexLessThan(String value) {
            addCriterion("p_sex <", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexLessThanOrEqualTo(String value) {
            addCriterion("p_sex <=", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexLike(String value) {
            addCriterion("p_sex like", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotLike(String value) {
            addCriterion("p_sex not like", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexIn(List<String> values) {
            addCriterion("p_sex in", values, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotIn(List<String> values) {
            addCriterion("p_sex not in", values, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexBetween(String value1, String value2) {
            addCriterion("p_sex between", value1, value2, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotBetween(String value1, String value2) {
            addCriterion("p_sex not between", value1, value2, "pSex");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNull() {
            addCriterion("p_price is null");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNotNull() {
            addCriterion("p_price is not null");
            return (Criteria) this;
        }

        public Criteria andPPriceEqualTo(Integer value) {
            addCriterion("p_price =", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotEqualTo(Integer value) {
            addCriterion("p_price <>", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThan(Integer value) {
            addCriterion("p_price >", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_price >=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThan(Integer value) {
            addCriterion("p_price <", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThanOrEqualTo(Integer value) {
            addCriterion("p_price <=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceIn(List<Integer> values) {
            addCriterion("p_price in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotIn(List<Integer> values) {
            addCriterion("p_price not in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceBetween(Integer value1, Integer value2) {
            addCriterion("p_price between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("p_price not between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyIsNull() {
            addCriterion("p_price_boy is null");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyIsNotNull() {
            addCriterion("p_price_boy is not null");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyEqualTo(Integer value) {
            addCriterion("p_price_boy =", value, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyNotEqualTo(Integer value) {
            addCriterion("p_price_boy <>", value, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyGreaterThan(Integer value) {
            addCriterion("p_price_boy >", value, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_price_boy >=", value, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyLessThan(Integer value) {
            addCriterion("p_price_boy <", value, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyLessThanOrEqualTo(Integer value) {
            addCriterion("p_price_boy <=", value, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyIn(List<Integer> values) {
            addCriterion("p_price_boy in", values, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyNotIn(List<Integer> values) {
            addCriterion("p_price_boy not in", values, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyBetween(Integer value1, Integer value2) {
            addCriterion("p_price_boy between", value1, value2, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPriceBoyNotBetween(Integer value1, Integer value2) {
            addCriterion("p_price_boy not between", value1, value2, "pPriceBoy");
            return (Criteria) this;
        }

        public Criteria andPPrice1IsNull() {
            addCriterion("p_price_1 is null");
            return (Criteria) this;
        }

        public Criteria andPPrice1IsNotNull() {
            addCriterion("p_price_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPPrice1EqualTo(Integer value) {
            addCriterion("p_price_1 =", value, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1NotEqualTo(Integer value) {
            addCriterion("p_price_1 <>", value, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1GreaterThan(Integer value) {
            addCriterion("p_price_1 >", value, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1GreaterThanOrEqualTo(Integer value) {
            addCriterion("p_price_1 >=", value, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1LessThan(Integer value) {
            addCriterion("p_price_1 <", value, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1LessThanOrEqualTo(Integer value) {
            addCriterion("p_price_1 <=", value, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1In(List<Integer> values) {
            addCriterion("p_price_1 in", values, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1NotIn(List<Integer> values) {
            addCriterion("p_price_1 not in", values, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1Between(Integer value1, Integer value2) {
            addCriterion("p_price_1 between", value1, value2, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice1NotBetween(Integer value1, Integer value2) {
            addCriterion("p_price_1 not between", value1, value2, "pPrice1");
            return (Criteria) this;
        }

        public Criteria andPPrice2IsNull() {
            addCriterion("p_price_2 is null");
            return (Criteria) this;
        }

        public Criteria andPPrice2IsNotNull() {
            addCriterion("p_price_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPPrice2EqualTo(Integer value) {
            addCriterion("p_price_2 =", value, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2NotEqualTo(Integer value) {
            addCriterion("p_price_2 <>", value, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2GreaterThan(Integer value) {
            addCriterion("p_price_2 >", value, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2GreaterThanOrEqualTo(Integer value) {
            addCriterion("p_price_2 >=", value, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2LessThan(Integer value) {
            addCriterion("p_price_2 <", value, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2LessThanOrEqualTo(Integer value) {
            addCriterion("p_price_2 <=", value, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2In(List<Integer> values) {
            addCriterion("p_price_2 in", values, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2NotIn(List<Integer> values) {
            addCriterion("p_price_2 not in", values, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2Between(Integer value1, Integer value2) {
            addCriterion("p_price_2 between", value1, value2, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice2NotBetween(Integer value1, Integer value2) {
            addCriterion("p_price_2 not between", value1, value2, "pPrice2");
            return (Criteria) this;
        }

        public Criteria andPPrice3IsNull() {
            addCriterion("p_price_3 is null");
            return (Criteria) this;
        }

        public Criteria andPPrice3IsNotNull() {
            addCriterion("p_price_3 is not null");
            return (Criteria) this;
        }

        public Criteria andPPrice3EqualTo(Integer value) {
            addCriterion("p_price_3 =", value, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3NotEqualTo(Integer value) {
            addCriterion("p_price_3 <>", value, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3GreaterThan(Integer value) {
            addCriterion("p_price_3 >", value, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3GreaterThanOrEqualTo(Integer value) {
            addCriterion("p_price_3 >=", value, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3LessThan(Integer value) {
            addCriterion("p_price_3 <", value, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3LessThanOrEqualTo(Integer value) {
            addCriterion("p_price_3 <=", value, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3In(List<Integer> values) {
            addCriterion("p_price_3 in", values, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3NotIn(List<Integer> values) {
            addCriterion("p_price_3 not in", values, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3Between(Integer value1, Integer value2) {
            addCriterion("p_price_3 between", value1, value2, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andPPrice3NotBetween(Integer value1, Integer value2) {
            addCriterion("p_price_3 not between", value1, value2, "pPrice3");
            return (Criteria) this;
        }

        public Criteria andBestNewIsNull() {
            addCriterion("best_new is null");
            return (Criteria) this;
        }

        public Criteria andBestNewIsNotNull() {
            addCriterion("best_new is not null");
            return (Criteria) this;
        }

        public Criteria andBestNewEqualTo(Integer value) {
            addCriterion("best_new =", value, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewNotEqualTo(Integer value) {
            addCriterion("best_new <>", value, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewGreaterThan(Integer value) {
            addCriterion("best_new >", value, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("best_new >=", value, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewLessThan(Integer value) {
            addCriterion("best_new <", value, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewLessThanOrEqualTo(Integer value) {
            addCriterion("best_new <=", value, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewIn(List<Integer> values) {
            addCriterion("best_new in", values, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewNotIn(List<Integer> values) {
            addCriterion("best_new not in", values, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewBetween(Integer value1, Integer value2) {
            addCriterion("best_new between", value1, value2, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestNewNotBetween(Integer value1, Integer value2) {
            addCriterion("best_new not between", value1, value2, "bestNew");
            return (Criteria) this;
        }

        public Criteria andBestHotIsNull() {
            addCriterion("best_hot is null");
            return (Criteria) this;
        }

        public Criteria andBestHotIsNotNull() {
            addCriterion("best_hot is not null");
            return (Criteria) this;
        }

        public Criteria andBestHotEqualTo(Integer value) {
            addCriterion("best_hot =", value, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotNotEqualTo(Integer value) {
            addCriterion("best_hot <>", value, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotGreaterThan(Integer value) {
            addCriterion("best_hot >", value, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("best_hot >=", value, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotLessThan(Integer value) {
            addCriterion("best_hot <", value, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotLessThanOrEqualTo(Integer value) {
            addCriterion("best_hot <=", value, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotIn(List<Integer> values) {
            addCriterion("best_hot in", values, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotNotIn(List<Integer> values) {
            addCriterion("best_hot not in", values, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotBetween(Integer value1, Integer value2) {
            addCriterion("best_hot between", value1, value2, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBestHotNotBetween(Integer value1, Integer value2) {
            addCriterion("best_hot not between", value1, value2, "bestHot");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeIsNull() {
            addCriterion("buy_notice is null");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeIsNotNull() {
            addCriterion("buy_notice is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeEqualTo(String value) {
            addCriterion("buy_notice =", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeNotEqualTo(String value) {
            addCriterion("buy_notice <>", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeGreaterThan(String value) {
            addCriterion("buy_notice >", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_notice >=", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeLessThan(String value) {
            addCriterion("buy_notice <", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeLessThanOrEqualTo(String value) {
            addCriterion("buy_notice <=", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeLike(String value) {
            addCriterion("buy_notice like", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeNotLike(String value) {
            addCriterion("buy_notice not like", value, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeIn(List<String> values) {
            addCriterion("buy_notice in", values, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeNotIn(List<String> values) {
            addCriterion("buy_notice not in", values, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeBetween(String value1, String value2) {
            addCriterion("buy_notice between", value1, value2, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andBuyNoticeNotBetween(String value1, String value2) {
            addCriterion("buy_notice not between", value1, value2, "buyNotice");
            return (Criteria) this;
        }

        public Criteria andSortIndexIsNull() {
            addCriterion("sort_index is null");
            return (Criteria) this;
        }

        public Criteria andSortIndexIsNotNull() {
            addCriterion("sort_index is not null");
            return (Criteria) this;
        }

        public Criteria andSortIndexEqualTo(Integer value) {
            addCriterion("sort_index =", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotEqualTo(Integer value) {
            addCriterion("sort_index <>", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThan(Integer value) {
            addCriterion("sort_index >", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_index >=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThan(Integer value) {
            addCriterion("sort_index <", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThanOrEqualTo(Integer value) {
            addCriterion("sort_index <=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexIn(List<Integer> values) {
            addCriterion("sort_index in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotIn(List<Integer> values) {
            addCriterion("sort_index not in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexBetween(Integer value1, Integer value2) {
            addCriterion("sort_index between", value1, value2, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_index not between", value1, value2, "sortIndex");
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

        public Criteria andCourseNumIsNull() {
            addCriterion("course_num is null");
            return (Criteria) this;
        }

        public Criteria andCourseNumIsNotNull() {
            addCriterion("course_num is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNumEqualTo(Integer value) {
            addCriterion("course_num =", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumNotEqualTo(Integer value) {
            addCriterion("course_num <>", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumGreaterThan(Integer value) {
            addCriterion("course_num >", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_num >=", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumLessThan(Integer value) {
            addCriterion("course_num <", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumLessThanOrEqualTo(Integer value) {
            addCriterion("course_num <=", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumIn(List<Integer> values) {
            addCriterion("course_num in", values, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumNotIn(List<Integer> values) {
            addCriterion("course_num not in", values, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumBetween(Integer value1, Integer value2) {
            addCriterion("course_num between", value1, value2, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("course_num not between", value1, value2, "courseNum");
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