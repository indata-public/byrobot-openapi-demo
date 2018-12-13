package com.indata.openapi.model;

/**
 *@author indata
 */
public class UpdateTaskParamVO {

    /**
     * 任务Id
     */
    private Integer taskId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务类型
     */
    private Integer taskType;
    /**
     * 外呼号码列表
     */
    private String userPhoneIds;
    /**
     * 外呼类型
     */
    private Integer callType;
    /**
     * 并发数(AI坐席数)
     */
    private Integer concurrencyQuota;
    /**
     * 并发数
     */
    private Integer concurrencyPhone;
    /**
     * 公司ID
     */
    private Integer companyId;
    /**
     * 外呼开始日期
     */
    private String startDate;
    /**
     * 任务开始时间
     */
    private String workingStartTime;
    /**
     * 任务结束时间
     */
    private String workingEndTime;
    /**
     * 任务午休开始时间
     */
    private String breakStartTime;
    /**
     * 任务午休结束时间
     */
    private String breakEndTime;
    /**
     * 是否重拨
     */
    private Boolean repeatCall;
    /**
     * 号码重播状态
     */
    private String repeatCallPhoneStatus;
    /**
     * 重播次数
     */
    private Integer repeatCallTimes;
    /**
     * 重播意向等级
     */
    private Integer repeatCallInterval;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public String getUserPhoneIds() {
        return userPhoneIds;
    }

    public void setUserPhoneIds(String userPhoneIds) {
        this.userPhoneIds = userPhoneIds;
    }

    public Integer getCallType() {
        return callType;
    }

    public void setCallType(Integer callType) {
        this.callType = callType;
    }

    public Integer getConcurrencyQuota() {
        return concurrencyQuota;
    }

    public void setConcurrencyQuota(Integer concurrencyQuota) {
        this.concurrencyQuota = concurrencyQuota;
    }

    public Integer getConcurrencyPhone() {
        return concurrencyPhone;
    }

    public void setConcurrencyPhone(Integer concurrencyPhone) {
        this.concurrencyPhone = concurrencyPhone;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public String getBreakStartTime() {
        return breakStartTime;
    }

    public void setBreakStartTime(String breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public String getBreakEndTime() {
        return breakEndTime;
    }

    public void setBreakEndTime(String breakEndTime) {
        this.breakEndTime = breakEndTime;
    }

    public Boolean getRepeatCall() {
        return repeatCall;
    }

    public void setRepeatCall(Boolean repeatCall) {
        this.repeatCall = repeatCall;
    }

    public String getRepeatCallPhoneStatus() {
        return repeatCallPhoneStatus;
    }

    public void setRepeatCallPhoneStatus(String repeatCallPhoneStatus) {
        this.repeatCallPhoneStatus = repeatCallPhoneStatus;
    }

    public Integer getRepeatCallTimes() {
        return repeatCallTimes;
    }

    public void setRepeatCallTimes(Integer repeatCallTimes) {
        this.repeatCallTimes = repeatCallTimes;
    }

    public Integer getRepeatCallInterval() {
        return repeatCallInterval;
    }

    public void setRepeatCallInterval(Integer repeatCallInterval) {
        this.repeatCallInterval = repeatCallInterval;
    }
}
