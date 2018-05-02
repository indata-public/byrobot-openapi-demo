package com.indata.openapi.model;

import com.indata.openapi.model.NameValueBO;

import java.util.List;

/**
 * Created by 昌夜 on 17/10/26.
 */
public class DialedPhoneQuery {
    //任务id
    private Integer callJobId;
    //通话时长左值
    private Integer durationLeft;
    //通话时长右值
    private Integer durationRight;
    //通话轮次左值
    private Integer chatRoundLeft;
    //通话轮次右值
    private Integer chatRoundRight;
    //状态:0-已接听,1-拒接,2-无法接通,3-主叫号码不可用
    private Integer finishStatus;
    //分析结果
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
