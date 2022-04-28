package com.sqldesign.sqlsec.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

public class Company {
    @JsonProperty("uid")
    private int uid;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("companyIntro")
    private String companyIntro;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("principal")
    private String principal;
    public int getUid() {
        return uid;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getPrincipal() {
        return principal;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPrincipal(String principal) {
        this.principal = principal;
    }
    public String getCompanyIntro() {
        return companyIntro;
    }
    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    @Override
    public String toString() {
        return "Company{" +
                "uid=" + uid +
                ", companyName='" + companyName + '\'' +
                ", companyIntro='" + companyIntro + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", principal='" + principal + '\'' +
                '}';
    }
}
