package com.indata.openapi.model;

import java.util.List;

/**
 * Created by 昌夜 on 17/10/26.
 */
public class DialedPhoneQuery {
    private Integer callJobId;
    private Integer chatRoundLeft;
    private Integer chatRoundRight;
    private Integer durationLeft;
    private Integer durationRight;
    private Integer finishStatus;

    private List<NameValueBO> resultQueryList;

    public Integer getCallJobId() {
        return callJobId;
    }

    public void setCallJobId(Integer callJobId) {
        this.callJobId = callJobId;
    }

    public Integer getChatRoundLeft() {
        return chatRoundLeft;
    }

    public void setChatRoundLeft(Integer chatRoundLeft) {
        this.chatRoundLeft = chatRoundLeft;
    }

    public Integer getChatRoundRight() {
        return chatRoundRight;
    }

    public void setChatRoundRight(Integer chatRoundRight) {
        this.chatRoundRight = chatRoundRight;
    }

    public Integer getDurationLeft() {
        return durationLeft;
    }

    public void setDurationLeft(Integer durationLeft) {
        this.durationLeft = durationLeft;
    }

    public Integer getDurationRight() {
        return durationRight;
    }

    public void setDurationRight(Integer durationRight) {
        this.durationRight = durationRight;
    }

    public List<NameValueBO> getResultQueryList() {
        return resultQueryList;
    }

    public void setResultQueryList(List<NameValueBO> resultQueryList) {
        this.resultQueryList = resultQueryList;
    }

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }
}
