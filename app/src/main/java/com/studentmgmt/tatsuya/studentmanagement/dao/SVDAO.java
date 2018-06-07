package com.studentmgmt.tatsuya.studentmanagement.dao;

import android.database.sqlite.SQLiteException;
import com.studentmgmt.tatsuya.studentmanagement.model.SinhVien;

import java.util.List;

public interface SVDAO {

    public abstract void addSV(SinhVien sinhVien) throws SQLiteException;

    public abstract boolean editSV(SinhVien sinhVien) throws SQLiteException;

    public abstract boolean deleteSV(SinhVien sinhVien) throws SQLiteException;

    public abstract List<SinhVien> getAll() throws SQLiteException;
}
