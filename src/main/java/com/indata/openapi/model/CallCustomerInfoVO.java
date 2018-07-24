package com.indata.openapi.model;

import java.util.Collections;
import java.util.Map;


public class CallCustomerInfoVO {

    private Integer sceneId;

    private Integer sceneRecordId;

    private Integer robotDefId;

    private Integer smsTemplateId;
    /**
     * 客户id
     */
    private Integer customerId;
    /**
     * 客户手机号
     */
    private String mobile;
    /**
     * 公司Id
     * openApi确定调用外呼的公司需要
     */
    private Integer companyId;
    /**
     * 拨打电话的参数变量
     */
    private Map<String, String> variables = Collections.emptyMap();      

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Map<String, String> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, String> variables) {
        this.variables = variables;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getSceneRecordId() {
        return sceneRecordId;
    }

    public void setSceneRecordId(Integer sceneRecordId) {
        this.sceneRecordId = sceneRecordId;
    }

    public Integer getRobotDefId() {
        return robotDefId;
    }

    public void setRobotDefId(Integer robotDefId) {
        this.robotDefId = robotDefId;
    }

    public Integer getSmsTemplateId() {
        return smsTemplateId;
    }

    public void setSmsTemplateId(Integer smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }
}
