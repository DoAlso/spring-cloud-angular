package com.cloud.configservice.model;

import java.util.ArrayList;
import java.util.List;

public class EnvExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table env
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table env
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table env
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public EnvExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table env
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table env
     *
     * @mbg.generated
     */
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameIsNull() {
            addCriterion("config_server_name is null");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameIsNotNull() {
            addCriterion("config_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameEqualTo(String value) {
            addCriterion("config_server_name =", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameNotEqualTo(String value) {
            addCriterion("config_server_name <>", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameGreaterThan(String value) {
            addCriterion("config_server_name >", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("config_server_name >=", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameLessThan(String value) {
            addCriterion("config_server_name <", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameLessThanOrEqualTo(String value) {
            addCriterion("config_server_name <=", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameLike(String value) {
            addCriterion("config_server_name like", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameNotLike(String value) {
            addCriterion("config_server_name not like", value, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameIn(List<String> values) {
            addCriterion("config_server_name in", values, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameNotIn(List<String> values) {
            addCriterion("config_server_name not in", values, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameBetween(String value1, String value2) {
            addCriterion("config_server_name between", value1, value2, "configServerName");
            return (Criteria) this;
        }

        public Criteria andConfigServerNameNotBetween(String value1, String value2) {
            addCriterion("config_server_name not between", value1, value2, "configServerName");
            return (Criteria) this;
        }

        public Criteria andContextPathIsNull() {
            addCriterion("context_path is null");
            return (Criteria) this;
        }

        public Criteria andContextPathIsNotNull() {
            addCriterion("context_path is not null");
            return (Criteria) this;
        }

        public Criteria andContextPathEqualTo(String value) {
            addCriterion("context_path =", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathNotEqualTo(String value) {
            addCriterion("context_path <>", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathGreaterThan(String value) {
            addCriterion("context_path >", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathGreaterThanOrEqualTo(String value) {
            addCriterion("context_path >=", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathLessThan(String value) {
            addCriterion("context_path <", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathLessThanOrEqualTo(String value) {
            addCriterion("context_path <=", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathLike(String value) {
            addCriterion("context_path like", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathNotLike(String value) {
            addCriterion("context_path not like", value, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathIn(List<String> values) {
            addCriterion("context_path in", values, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathNotIn(List<String> values) {
            addCriterion("context_path not in", values, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathBetween(String value1, String value2) {
            addCriterion("context_path between", value1, value2, "contextPath");
            return (Criteria) this;
        }

        public Criteria andContextPathNotBetween(String value1, String value2) {
            addCriterion("context_path not between", value1, value2, "contextPath");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressIsNull() {
            addCriterion("registry_address is null");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressIsNotNull() {
            addCriterion("registry_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressEqualTo(String value) {
            addCriterion("registry_address =", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressNotEqualTo(String value) {
            addCriterion("registry_address <>", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressGreaterThan(String value) {
            addCriterion("registry_address >", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("registry_address >=", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressLessThan(String value) {
            addCriterion("registry_address <", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressLessThanOrEqualTo(String value) {
            addCriterion("registry_address <=", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressLike(String value) {
            addCriterion("registry_address like", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressNotLike(String value) {
            addCriterion("registry_address not like", value, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressIn(List<String> values) {
            addCriterion("registry_address in", values, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressNotIn(List<String> values) {
            addCriterion("registry_address not in", values, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressBetween(String value1, String value2) {
            addCriterion("registry_address between", value1, value2, "registryAddress");
            return (Criteria) this;
        }

        public Criteria andRegistryAddressNotBetween(String value1, String value2) {
            addCriterion("registry_address not between", value1, value2, "registryAddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table env
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table env
     *
     * @mbg.generated
     */
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