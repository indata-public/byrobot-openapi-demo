package com.indata.openapi.model;


import java.util.List;

/**
 * 向任务中导入客户实体类
 */
public class ImportTaskCustomerVO {
    //公司id
    private Integer companyId;

    //任务id
    private Integer TaskId;

    //是否强制获取客户
    Integer forceTransferCustomer;

    //是否加密
    boolean encryptionPhone;

    //是否是https
    Integer isHttps;

    //导入的客户信息
    private List<CustomerInfoExtVO> customerInfoList;

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
