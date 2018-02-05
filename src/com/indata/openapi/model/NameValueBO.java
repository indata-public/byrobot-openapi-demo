package com.indata.openapi.model;

/**
 * Created by 昌夜 on 17/10/19.
 */
public class NameValueBO {
    private String name;

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
