package com.indata.openapi.model;

import java.util.List;

/**
 * @author indata
 * @create 2018/2/5
 **/
public class CreateTaskVO {
    private Integer companyId;
    private String taskName;
    private Integer taskType;
    private String startDate;
    private String workingStartTime;
    private String workingEndTime;
    private List<Integer> userPhoneIds;
    private Integer robotDefId;
    private Integer sceneDefId;
    private Integer sceneRecordId;
    private String remark;
    private Integer smsType;
    private String smsCondition;
    private Integer smsTemplateId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getWorkingStartTime() {
        return workingStartTime;
    }

    public void setWorkingStartTime(String workingStartTime) {
        this.workingStartTime = workingStartTime;
    }

    public String getWorkingEndTime() {
        return workingEndTime;
    }

    public void setWorkingEndTime(String workingEndTime) {
        this.workingEndTime = workingEndTime;
    }

    public List<Integer> getUserPhoneIds() {
        return userPhoneIds;
    }

    public void setUserPhoneIds(List<Integer> userPhoneIds) {
        this.userPhoneIds = userPhoneIds;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSmsType() {
        return smsType;
    }

    public void setSmsType(Integer smsType) {
        this.smsType = smsType;
    }

    public String getSmsCondition() {
        return smsCondition;
    }

    public void setSmsCondition(String smsCondition) {
        this.smsCondition = smsCondition;
    }

    public Integer getSmsTemplateId() {
        return smsTemplateId;
    }

    public void setSmsTemplateId(Integer smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }

}
