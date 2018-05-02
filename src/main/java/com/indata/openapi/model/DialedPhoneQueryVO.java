package com.indata.openapi.model;

import com.indata.openapi.model.DialedPhoneQuery;

/**
 * Created by 昌夜 on 17/10/26.
 */
public class DialedPhoneQueryVO extends DialedPhoneQuery {
    private Integer pageNum = 1;

    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
