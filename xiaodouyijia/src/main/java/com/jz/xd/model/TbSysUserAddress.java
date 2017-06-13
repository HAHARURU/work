package com.jz.xd.model;

import java.util.Date;

public class TbSysUserAddress {
    private Integer id;

    private Integer addressId;

    private Integer uid;

    private String receivedPerson;

    private String receivedPersonPhone;

    private String province;

    private String city;

    private String area;

    private String address;

    private Date syscreated;

    private Integer active;

    private String demo;

    private Boolean defaultAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getReceivedPerson() {
        return receivedPerson;
    }

    public void setReceivedPerson(String receivedPerson) {
        this.receivedPerson = receivedPerson == null ? null : receivedPerson.trim();
    }

    public String getReceivedPersonPhone() {
        return receivedPersonPhone;
    }

    public void setReceivedPersonPhone(String receivedPersonPhone) {
        this.receivedPersonPhone = receivedPersonPhone == null ? null : receivedPersonPhone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
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

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}