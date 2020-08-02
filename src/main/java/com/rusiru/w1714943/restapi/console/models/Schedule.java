package com.rusiru.w1714943.restapi.console.models;

import java.sql.Date;
import java.util.Objects;

public class Schedule {
    private String cusName;
    private String phoneNo;
    public String NIC;
    private String licenceNo;
    private String plateNumber;
    private Date pickUp;
    private Date dropOff;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getPickUp() {
        return pickUp;
    }

    public void setPickUp(Date pickUp) {
        this.pickUp = pickUp;
    }

    public Date getDropOff() {
        return dropOff;
    }

    public void setDropOff(Date dropOff) {
        this.dropOff = dropOff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return cusName.equals(schedule.cusName) &&
                phoneNo.equals(schedule.phoneNo) &&
                NIC.equals(schedule.NIC) &&
                licenceNo.equals(schedule.licenceNo) &&
                plateNumber.equals(schedule.plateNumber) &&
                pickUp.equals(schedule.pickUp) &&
                dropOff.equals(schedule.dropOff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusName, phoneNo, NIC, licenceNo, plateNumber, pickUp, dropOff);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "cusName='" + cusName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", NIC='" + NIC + '\'' +
                ", licenceNo='" + licenceNo + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", pickUp=" + pickUp +
                ", dropOff=" + dropOff +
                '}';
    }
}

