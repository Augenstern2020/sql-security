package com.sqldesign.sqlsec.model;

public class JobHunter {
    private int resumeId;
    private int uid;
    private String resume;

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "JobHunter{" +
                "resumeId=" + resumeId +
                ", uid=" + uid +
                ", resume='" + resume + '\'' +
                '}';
    }
}
