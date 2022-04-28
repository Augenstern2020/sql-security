package com.sqldesign.sqlsec.model;

import java.util.Date;

public class Recruitment {
    private int recruitId;
    private int uid;
    private String position;
    private int peopleNum;
    private String requirement;
    private String postTime;

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPosition(String postion) {
        this.position = postion;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public int getUid() {
        return uid;
    }

    public String getPosition() {
        return position;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getPostTime() {
        return postTime;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "recruitId=" + recruitId +
                ", uid=" + uid +
                ", position='" + position + '\'' +
                ", peopleNum=" + peopleNum +
                ", requirement='" + requirement + '\'' +
                ", postTime='" + postTime + '\'' +
                '}';
    }
}
