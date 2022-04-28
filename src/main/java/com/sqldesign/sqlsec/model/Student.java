package com.sqldesign.sqlsec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("uid")
    private int uid;
    @JsonProperty("stuName")
    private String stuName;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("age")
    private int age;
    @JsonProperty("education")
    private String education;
    @JsonProperty("university")
    private String university;
    @JsonProperty("graduationTime")
    private String graduationTime;
    @JsonProperty("major")
    private String major;
    @JsonProperty("phone")
    private String phone;
    public int getUid() {
        return uid;
    }
    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public String getEducation() {
        return education;
    }
    public String getGraduationTime() {
        return graduationTime;
    }
    public String getMajor() {
        return major;
    }
    public String getPhone() {
        return phone;
    }
    public String getStuName() {
        return stuName;
    }
    public String getUniversity() {
        return university;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", education='" + education + '\'' +
                ", university='" + university + '\'' +
                ", graduationTime='" + graduationTime + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
