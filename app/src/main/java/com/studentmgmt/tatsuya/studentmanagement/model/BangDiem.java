package com.studentmgmt.tatsuya.studentmanagement.model;

import java.io.Serializable;

public class BangDiem implements Serializable {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private int diem;

    public BangDiem() {
    }

    public BangDiem(SinhVien sinhVien, MonHoc monHoc, int diem) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
