package com.indata.openapi.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户信息实体类
 **/
public class CustomerInfoExtVO {
    //姓名
    private String name;
    //手机号
    private String phone;

    //客户额外信息，如果话术中包含变量，则需要在properties中加上此字段，map的key和话术中的变量保持一致
    private Map<String, String> properties = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
