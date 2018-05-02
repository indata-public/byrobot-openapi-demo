package com.indata.openapi.model;

/**
 * 任务
 */
public class TaskParamVO {
    private Integer taskId;

    public TaskParamVO(Integer taskId) {
        this.taskId = taskId;
    }

    public TaskParamVO() {
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
