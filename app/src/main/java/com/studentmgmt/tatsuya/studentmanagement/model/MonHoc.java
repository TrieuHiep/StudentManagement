package com.studentmgmt.tatsuya.studentmanagement.model;

import java.io.Serializable;
import java.util.Objects;

public class MonHoc implements Serializable {
    private String maMH;
    private String tenMH;
    private int soTC;

    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, int soTC) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTC = soTC;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTC() {
        return soTC;
    }

    @Override
    public String toString() {
        return maMH + " - " + tenMH;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

}
