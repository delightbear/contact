package com.example.hb2013.contactapp.domain;

/**
 * Created by hb2013 on 2017-02-04.
 */

public class MemberBean {
    private String id;
    private String pass;
    private String name;

    public String getId() {  //get은 모두 리턴타입이다.  bean으로 싸서
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private String phone;
    private String addr;
    private String profile;



}
