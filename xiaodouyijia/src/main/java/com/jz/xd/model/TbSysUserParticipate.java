package com.jz.xd.model;

import java.util.Date;

public class TbSysUserParticipate {
    private Integer id;

    private String uBoyName;

    private String sex;

    private String phone;

    private String age;

    private String city;

    private String area;

    private String address;

    private Date syscreated;

    private Integer active;

    private String demo;

    private String adultName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuBoyName() {
        return uBoyName;
    }

    public void setuBoyName(String uBoyName) {
        this.uBoyName = uBoyName == null ? null : uBoyName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getSyscreated() {
        return syscreated;
    }

    public void setSyscreated(Date syscreated) {
        this.syscreated = syscreated;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }

    public String getAdultName() {
        return adultName;
    }

    public void setAdultName(String adultName) {
        this.adultName = adultName == null ? null : adultName.trim();
    }
}