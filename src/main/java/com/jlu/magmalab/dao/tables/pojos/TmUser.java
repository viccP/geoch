/*
 * This file is generated by jOOQ.
*/
package com.jlu.magmalab.dao.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TmUser implements Serializable {

    private static final long serialVersionUID = -1667975359;

    private String    userId;
    private String    loginId;
    private String    password;
    private String    userName;
    private Integer   sex;
    private String    phoneNo;
    private String    memo;
    private Timestamp updTime;
    private Integer   pwdStatus;

    public TmUser() {}

    public TmUser(TmUser value) {
        this.userId = value.userId;
        this.loginId = value.loginId;
        this.password = value.password;
        this.userName = value.userName;
        this.sex = value.sex;
        this.phoneNo = value.phoneNo;
        this.memo = value.memo;
        this.updTime = value.updTime;
        this.pwdStatus = value.pwdStatus;
    }

    public TmUser(
        String    userId,
        String    loginId,
        String    password,
        String    userName,
        Integer   sex,
        String    phoneNo,
        String    memo,
        Timestamp updTime,
        Integer   pwdStatus
    ) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.phoneNo = phoneNo;
        this.memo = memo;
        this.updTime = updTime;
        this.pwdStatus = pwdStatus;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Timestamp getUpdTime() {
        return this.updTime;
    }

    public void setUpdTime(Timestamp updTime) {
        this.updTime = updTime;
    }

    public Integer getPwdStatus() {
        return this.pwdStatus;
    }

    public void setPwdStatus(Integer pwdStatus) {
        this.pwdStatus = pwdStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TmUser (");

        sb.append(userId);
        sb.append(", ").append(loginId);
        sb.append(", ").append(password);
        sb.append(", ").append(userName);
        sb.append(", ").append(sex);
        sb.append(", ").append(phoneNo);
        sb.append(", ").append(memo);
        sb.append(", ").append(updTime);
        sb.append(", ").append(pwdStatus);

        sb.append(")");
        return sb.toString();
    }
}
