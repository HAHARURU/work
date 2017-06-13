package com.jz.xd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutvideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutvideoExample() {
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

        public Criteria andOvidIsNull() {
            addCriterion("ovid is null");
            return (Criteria) this;
        }

        public Criteria andOvidIsNotNull() {
            addCriterion("ovid is not null");
            return (Criteria) this;
        }

        public Criteria andOvidEqualTo(Integer value) {
            addCriterion("ovid =", value, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidNotEqualTo(Integer value) {
            addCriterion("ovid <>", value, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidGreaterThan(Integer value) {
            addCriterion("ovid >", value, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ovid >=", value, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidLessThan(Integer value) {
            addCriterion("ovid <", value, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidLessThanOrEqualTo(Integer value) {
            addCriterion("ovid <=", value, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidIn(List<Integer> values) {
            addCriterion("ovid in", values, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidNotIn(List<Integer> values) {
            addCriterion("ovid not in", values, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidBetween(Integer value1, Integer value2) {
            addCriterion("ovid between", value1, value2, "ovid");
            return (Criteria) this;
        }

        public Criteria andOvidNotBetween(Integer value1, Integer value2) {
            addCriterion("ovid not between", value1, value2, "ovid");
            return (Criteria) this;
        }

        public Criteria andVourlIsNull() {
            addCriterion("vourl is null");
            return (Criteria) this;
        }

        public Criteria andVourlIsNotNull() {
            addCriterion("vourl is not null");
            return (Criteria) this;
        }

        public Criteria andVourlEqualTo(String value) {
            addCriterion("vourl =", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlNotEqualTo(String value) {
            addCriterion("vourl <>", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlGreaterThan(String value) {
            addCriterion("vourl >", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlGreaterThanOrEqualTo(String value) {
            addCriterion("vourl >=", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlLessThan(String value) {
            addCriterion("vourl <", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlLessThanOrEqualTo(String value) {
            addCriterion("vourl <=", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlLike(String value) {
            addCriterion("vourl like", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlNotLike(String value) {
            addCriterion("vourl not like", value, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlIn(List<String> values) {
            addCriterion("vourl in", values, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlNotIn(List<String> values) {
            addCriterion("vourl not in", values, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlBetween(String value1, String value2) {
            addCriterion("vourl between", value1, value2, "vourl");
            return (Criteria) this;
        }

        public Criteria andVourlNotBetween(String value1, String value2) {
            addCriterion("vourl not between", value1, value2, "vourl");
            return (Criteria) this;
        }

        public Criteria andVonameIsNull() {
            addCriterion("voname is null");
            return (Criteria) this;
        }

        public Criteria andVonameIsNotNull() {
            addCriterion("voname is not null");
            return (Criteria) this;
        }

        public Criteria andVonameEqualTo(String value) {
            addCriterion("voname =", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotEqualTo(String value) {
            addCriterion("voname <>", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameGreaterThan(String value) {
            addCriterion("voname >", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameGreaterThanOrEqualTo(String value) {
            addCriterion("voname >=", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameLessThan(String value) {
            addCriterion("voname <", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameLessThanOrEqualTo(String value) {
            addCriterion("voname <=", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameLike(String value) {
            addCriterion("voname like", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotLike(String value) {
            addCriterion("voname not like", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameIn(List<String> values) {
            addCriterion("voname in", values, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotIn(List<String> values) {
            addCriterion("voname not in", values, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameBetween(String value1, String value2) {
            addCriterion("voname between", value1, value2, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotBetween(String value1, String value2) {
            addCriterion("voname not between", value1, value2, "voname");
            return (Criteria) this;
        }

        public Criteria andVodurationIsNull() {
            addCriterion("voduration is null");
            return (Criteria) this;
        }

        public Criteria andVodurationIsNotNull() {
            addCriterion("voduration is not null");
            return (Criteria) this;
        }

        public Criteria andVodurationEqualTo(Integer value) {
            addCriterion("voduration =", value, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationNotEqualTo(Integer value) {
            addCriterion("voduration <>", value, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationGreaterThan(Integer value) {
            addCriterion("voduration >", value, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("voduration >=", value, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationLessThan(Integer value) {
            addCriterion("voduration <", value, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationLessThanOrEqualTo(Integer value) {
            addCriterion("voduration <=", value, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationIn(List<Integer> values) {
            addCriterion("voduration in", values, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationNotIn(List<Integer> values) {
            addCriterion("voduration not in", values, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationBetween(Integer value1, Integer value2) {
            addCriterion("voduration between", value1, value2, "voduration");
            return (Criteria) this;
        }

        public Criteria andVodurationNotBetween(Integer value1, Integer value2) {
            addCriterion("voduration not between", value1, value2, "voduration");
            return (Criteria) this;
        }

        public Criteria andVopalyIsNull() {
            addCriterion("vopaly is null");
            return (Criteria) this;
        }

        public Criteria andVopalyIsNotNull() {
            addCriterion("vopaly is not null");
            return (Criteria) this;
        }

        public Criteria andVopalyEqualTo(Integer value) {
            addCriterion("vopaly =", value, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyNotEqualTo(Integer value) {
            addCriterion("vopaly <>", value, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyGreaterThan(Integer value) {
            addCriterion("vopaly >", value, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyGreaterThanOrEqualTo(Integer value) {
            addCriterion("vopaly >=", value, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyLessThan(Integer value) {
            addCriterion("vopaly <", value, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyLessThanOrEqualTo(Integer value) {
            addCriterion("vopaly <=", value, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyIn(List<Integer> values) {
            addCriterion("vopaly in", values, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyNotIn(List<Integer> values) {
            addCriterion("vopaly not in", values, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyBetween(Integer value1, Integer value2) {
            addCriterion("vopaly between", value1, value2, "vopaly");
            return (Criteria) this;
        }

        public Criteria andVopalyNotBetween(Integer value1, Integer value2) {
            addCriterion("vopaly not between", value1, value2, "vopaly");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNull() {
            addCriterion("uploadTime is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("uploadTime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterion("uploadTime =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterion("uploadTime <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterion("uploadTime >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uploadTime >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(Date value) {
            addCriterion("uploadTime <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("uploadTime <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterion("uploadTime in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterion("uploadTime not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterion("uploadTime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("uploadTime not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andFkindIsNull() {
            addCriterion("fKind is null");
            return (Criteria) this;
        }

        public Criteria andFkindIsNotNull() {
            addCriterion("fKind is not null");
            return (Criteria) this;
        }

        public Criteria andFkindEqualTo(Integer value) {
            addCriterion("fKind =", value, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindNotEqualTo(Integer value) {
            addCriterion("fKind <>", value, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindGreaterThan(Integer value) {
            addCriterion("fKind >", value, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindGreaterThanOrEqualTo(Integer value) {
            addCriterion("fKind >=", value, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindLessThan(Integer value) {
            addCriterion("fKind <", value, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindLessThanOrEqualTo(Integer value) {
            addCriterion("fKind <=", value, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindIn(List<Integer> values) {
            addCriterion("fKind in", values, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindNotIn(List<Integer> values) {
            addCriterion("fKind not in", values, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindBetween(Integer value1, Integer value2) {
            addCriterion("fKind between", value1, value2, "fkind");
            return (Criteria) this;
        }

        public Criteria andFkindNotBetween(Integer value1, Integer value2) {
            addCriterion("fKind not between", value1, value2, "fkind");
            return (Criteria) this;
        }

        public Criteria andSkindIsNull() {
            addCriterion("sKind is null");
            return (Criteria) this;
        }

        public Criteria andSkindIsNotNull() {
            addCriterion("sKind is not null");
            return (Criteria) this;
        }

        public Criteria andSkindEqualTo(Integer value) {
            addCriterion("sKind =", value, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindNotEqualTo(Integer value) {
            addCriterion("sKind <>", value, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindGreaterThan(Integer value) {
            addCriterion("sKind >", value, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindGreaterThanOrEqualTo(Integer value) {
            addCriterion("sKind >=", value, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindLessThan(Integer value) {
            addCriterion("sKind <", value, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindLessThanOrEqualTo(Integer value) {
            addCriterion("sKind <=", value, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindIn(List<Integer> values) {
            addCriterion("sKind in", values, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindNotIn(List<Integer> values) {
            addCriterion("sKind not in", values, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindBetween(Integer value1, Integer value2) {
            addCriterion("sKind between", value1, value2, "skind");
            return (Criteria) this;
        }

        public Criteria andSkindNotBetween(Integer value1, Integer value2) {
            addCriterion("sKind not between", value1, value2, "skind");
            return (Criteria) this;
        }

        public Criteria andVopicIsNull() {
            addCriterion("vopic is null");
            return (Criteria) this;
        }

        public Criteria andVopicIsNotNull() {
            addCriterion("vopic is not null");
            return (Criteria) this;
        }

        public Criteria andVopicEqualTo(String value) {
            addCriterion("vopic =", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicNotEqualTo(String value) {
            addCriterion("vopic <>", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicGreaterThan(String value) {
            addCriterion("vopic >", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicGreaterThanOrEqualTo(String value) {
            addCriterion("vopic >=", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicLessThan(String value) {
            addCriterion("vopic <", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicLessThanOrEqualTo(String value) {
            addCriterion("vopic <=", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicLike(String value) {
            addCriterion("vopic like", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicNotLike(String value) {
            addCriterion("vopic not like", value, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicIn(List<String> values) {
            addCriterion("vopic in", values, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicNotIn(List<String> values) {
            addCriterion("vopic not in", values, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicBetween(String value1, String value2) {
            addCriterion("vopic between", value1, value2, "vopic");
            return (Criteria) this;
        }

        public Criteria andVopicNotBetween(String value1, String value2) {
            addCriterion("vopic not between", value1, value2, "vopic");
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