package com.indata.openapi.model;


import java.util.List;

/**
 * Created by 昌夜 on 18/2/3.
 */
public class ImportTaskCustomerVO {
    private Integer companyId;
    private Integer TaskId;
    private List<CustomerInfoExtVO> customerInfoList;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTaskId() {
        return TaskId;
    }

    public void setTaskId(Integer taskId) {
        TaskId = taskId;
    }

    public List<CustomerInfoExtVO> getCustomerInfoList() {
        return customerInfoList;
    }

    public void setCustomerInfoList(List<CustomerInfoExtVO> customerInfoList) {
        this.customerInfoList = customerInfoList;
    }
}
