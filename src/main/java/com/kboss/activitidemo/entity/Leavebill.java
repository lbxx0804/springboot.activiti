package com.kboss.activitidemo.entity;

import java.util.Date;

public class Leavebill {
    private Integer id;

    private String applyusername;

    private Date applydate;

    private String reason;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyusername() {
        return applyusername;
    }

    public void setApplyusername(String applyusername) {
        this.applyusername = applyusername;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}