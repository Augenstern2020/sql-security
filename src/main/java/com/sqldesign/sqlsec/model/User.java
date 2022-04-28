package com.sqldesign.sqlsec.model;

import java.util.Date;

public class User {
    private int uid;
    private String username;
    private String passwd;
    private String email;
    private int loginTimes;
    private String userType;
    private String lastLoginTime;
    private int isAdmin;
    public void setEmpty(){
        setPasswd("");
        setLoginTimes(0);
        setUserType("");
        setIsAdmin(0);
        setLastLoginTime("");
        setEmail("");
    }
    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public int getLoginTimes() {
        return loginTimes;
    }

    public int getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setLoginTimes(int loginTimes) {
        this.loginTimes = loginTimes;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", email='" + email + '\'' +
                ", loginTimes=" + loginTimes +
                ", userType='" + userType + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
