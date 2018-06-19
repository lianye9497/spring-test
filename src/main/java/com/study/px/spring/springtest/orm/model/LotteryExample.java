package com.study.px.spring.springtest.orm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LotteryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryExample() {
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

        public Criteria andTicketNumberIsNull() {
            addCriterion("ticket_number is null");
            return (Criteria) this;
        }

        public Criteria andTicketNumberIsNotNull() {
            addCriterion("ticket_number is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNumberEqualTo(String value) {
            addCriterion("ticket_number =", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberNotEqualTo(String value) {
            addCriterion("ticket_number <>", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberGreaterThan(String value) {
            addCriterion("ticket_number >", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_number >=", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberLessThan(String value) {
            addCriterion("ticket_number <", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberLessThanOrEqualTo(String value) {
            addCriterion("ticket_number <=", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberLike(String value) {
            addCriterion("ticket_number like", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberNotLike(String value) {
            addCriterion("ticket_number not like", value, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberIn(List<String> values) {
            addCriterion("ticket_number in", values, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberNotIn(List<String> values) {
            addCriterion("ticket_number not in", values, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberBetween(String value1, String value2) {
            addCriterion("ticket_number between", value1, value2, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andTicketNumberNotBetween(String value1, String value2) {
            addCriterion("ticket_number not between", value1, value2, "ticketNumber");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdIsNull() {
            addCriterion("lottery_type_id is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdIsNotNull() {
            addCriterion("lottery_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdEqualTo(Integer value) {
            addCriterion("lottery_type_id =", value, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdNotEqualTo(Integer value) {
            addCriterion("lottery_type_id <>", value, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdGreaterThan(Integer value) {
            addCriterion("lottery_type_id >", value, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_type_id >=", value, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdLessThan(Integer value) {
            addCriterion("lottery_type_id <", value, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_type_id <=", value, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdIn(List<Integer> values) {
            addCriterion("lottery_type_id in", values, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdNotIn(List<Integer> values) {
            addCriterion("lottery_type_id not in", values, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("lottery_type_id between", value1, value2, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_type_id not between", value1, value2, "lotteryTypeId");
            return (Criteria) this;
        }

        public Criteria andParPriceIsNull() {
            addCriterion("par_price is null");
            return (Criteria) this;
        }

        public Criteria andParPriceIsNotNull() {
            addCriterion("par_price is not null");
            return (Criteria) this;
        }

        public Criteria andParPriceEqualTo(BigDecimal value) {
            addCriterion("par_price =", value, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceNotEqualTo(BigDecimal value) {
            addCriterion("par_price <>", value, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceGreaterThan(BigDecimal value) {
            addCriterion("par_price >", value, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("par_price >=", value, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceLessThan(BigDecimal value) {
            addCriterion("par_price <", value, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("par_price <=", value, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceIn(List<BigDecimal> values) {
            addCriterion("par_price in", values, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceNotIn(List<BigDecimal> values) {
            addCriterion("par_price not in", values, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("par_price between", value1, value2, "parPrice");
            return (Criteria) this;
        }

        public Criteria andParPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("par_price not between", value1, value2, "parPrice");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoIsNull() {
            addCriterion("lottery_photo is null");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoIsNotNull() {
            addCriterion("lottery_photo is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoEqualTo(String value) {
            addCriterion("lottery_photo =", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoNotEqualTo(String value) {
            addCriterion("lottery_photo <>", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoGreaterThan(String value) {
            addCriterion("lottery_photo >", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_photo >=", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoLessThan(String value) {
            addCriterion("lottery_photo <", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoLessThanOrEqualTo(String value) {
            addCriterion("lottery_photo <=", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoLike(String value) {
            addCriterion("lottery_photo like", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoNotLike(String value) {
            addCriterion("lottery_photo not like", value, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoIn(List<String> values) {
            addCriterion("lottery_photo in", values, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoNotIn(List<String> values) {
            addCriterion("lottery_photo not in", values, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoBetween(String value1, String value2) {
            addCriterion("lottery_photo between", value1, value2, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andLotteryPhotoNotBetween(String value1, String value2) {
            addCriterion("lottery_photo not between", value1, value2, "lotteryPhoto");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Boolean value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Boolean value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Boolean value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Boolean value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Boolean value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Boolean> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Boolean> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Boolean value1, Boolean value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIsNull() {
            addCriterion("settlement_status is null");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIsNotNull() {
            addCriterion("settlement_status is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusEqualTo(Boolean value) {
            addCriterion("settlement_status =", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotEqualTo(Boolean value) {
            addCriterion("settlement_status <>", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusGreaterThan(Boolean value) {
            addCriterion("settlement_status >", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("settlement_status >=", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLessThan(Boolean value) {
            addCriterion("settlement_status <", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("settlement_status <=", value, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusIn(List<Boolean> values) {
            addCriterion("settlement_status in", values, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotIn(List<Boolean> values) {
            addCriterion("settlement_status not in", values, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("settlement_status between", value1, value2, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andSettlementStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("settlement_status not between", value1, value2, "settlementStatus");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdIsNull() {
            addCriterion("lottery_window_id is null");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdIsNotNull() {
            addCriterion("lottery_window_id is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdEqualTo(Integer value) {
            addCriterion("lottery_window_id =", value, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdNotEqualTo(Integer value) {
            addCriterion("lottery_window_id <>", value, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdGreaterThan(Integer value) {
            addCriterion("lottery_window_id >", value, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_window_id >=", value, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdLessThan(Integer value) {
            addCriterion("lottery_window_id <", value, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_window_id <=", value, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdIn(List<Integer> values) {
            addCriterion("lottery_window_id in", values, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdNotIn(List<Integer> values) {
            addCriterion("lottery_window_id not in", values, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdBetween(Integer value1, Integer value2) {
            addCriterion("lottery_window_id between", value1, value2, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andLotteryWindowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_window_id not between", value1, value2, "lotteryWindowId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Integer value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Integer value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Integer value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Integer value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Integer> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Integer> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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