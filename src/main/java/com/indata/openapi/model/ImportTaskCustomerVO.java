package com.indata.openapi.model;


import com.indata.openapi.model.CustomerInfoExtVO;

import java.util.List;

/**
 * 向任务中导入客户
 * Created by 昌夜 on 18/2/3.
 */
public class ImportTaskCustomerVO {
    //公司id
    private Integer companyId;
    //任务id
    private Integer TaskId;

    Integer forceTransferCustomer;
    //客户信息

    boolean encryptionPhone;

    Integer isHttps;

    public Integer getIsHttps() {
        return isHttps;
    }

    public void setIsHttps(Integer isHttps) {
        this.isHttps = isHttps;
    }

    public boolean isEncryptionPhone() {
        return encryptionPhone;
    }

    public void setEncryptionPhone(boolean encryptionPhone) {
        this.encryptionPhone = encryptionPhone;
    }

    public Integer getForceTransferCustomer() {
        return forceTransferCustomer;
    }

    public void setForceTransferCustomer(Integer forceTransferCustomer) {
        this.forceTransferCustomer = forceTransferCustomer;
    }

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
