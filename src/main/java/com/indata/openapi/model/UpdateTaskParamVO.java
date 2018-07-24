package com.indata.openapi.model;

/**
 *@author indata
 */
public class UpdateTaskParamVO {
    /**
     * 公司id
     */
    private Integer companyId;
    /**
     * 任务id
     */
    private Integer taskId;

    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 修改的并发数
     */
    private Integer concurrencyQuota;
    /**
     * 任务的主叫类型
     */
    private Integer callType;
    /**
     * 主叫号码id
     */
    private String userPhoneIds;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getConcurrencyQuota() {
        return concurrencyQuota;
    }

    public void setConcurrencyQuota(Integer concurrencyQuota) {
        this.concurrencyQuota = concurrencyQuota;
    }

    public Integer getCallType() {
        return callType;
    }

    public void setCallType(Integer callType) {
        this.callType = callType;
    }

    public String getUserPhoneIds() {
        return userPhoneIds;
    }

    public void setUserPhoneIds(String userPhoneIds) {
        this.userPhoneIds = userPhoneIds;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
