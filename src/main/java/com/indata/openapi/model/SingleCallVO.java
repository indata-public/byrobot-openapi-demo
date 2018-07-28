package com.indata.openapi.model;

import java.util.Map;

/**
 * 通过手机号单次电话外呼实体类
 * @author 数心科技
 */
public class SingleCallVO {


    /**
     * 机器人id
     */
    private Integer robotDefId;
    /**
     * 场景实例id
     */
    private Integer sceneDefId;
    /**
     * 场景录音id
     */
    private Integer sceneRecordId;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 客户名称
     */
    private String userName;
    /**
     * 变量
     */
    private Map<String, String> variables;
    /**
     * 公司Id
     */
    private Integer companyId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getRobotDefId() {
        return robotDefId;
    }

    public void setRobotDefId(Integer robotDefId) {
        this.robotDefId = robotDefId;
    }

    public Integer getSceneDefId() {
        return sceneDefId;
    }

    public void setSceneDefId(Integer sceneDefId) {
        this.sceneDefId = sceneDefId;
    }

    public Integer getSceneRecordId() {
        return sceneRecordId;
    }

    public void setSceneRecordId(Integer sceneRecordId) {
        this.sceneRecordId = sceneRecordId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Map<String, String> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, String> variables) {
        this.variables = variables;
    }
}
