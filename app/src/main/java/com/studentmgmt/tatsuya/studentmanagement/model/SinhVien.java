package com.studentmgmt.tatsuya.studentmanagement.model;

import java.io.Serializable;
import java.util.Objects;

public class SinhVien implements Serializable {
    private int maSV;
    private String tenSV;
    private String email;

    public SinhVien() {
    }

    public SinhVien(int maSV, String tenSV, String email) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.email = email;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV=" + maSV +
                ", tenSV='" + tenSV + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
