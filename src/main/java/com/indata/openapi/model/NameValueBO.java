package com.indata.openapi.model;

/**
 * 分析结果
 * Created by 昌夜 on 17/10/19.
 */
public class NameValueBO {
    //客户意向等级
    private String name;
    //客户意向等级的值
    private String value;
    public NameValueBO() {
    }

    public NameValueBO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
