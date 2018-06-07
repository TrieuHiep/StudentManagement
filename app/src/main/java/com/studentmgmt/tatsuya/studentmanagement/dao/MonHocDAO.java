package com.studentmgmt.tatsuya.studentmanagement.dao;

import android.database.sqlite.SQLiteException;
import com.studentmgmt.tatsuya.studentmanagement.model.MonHoc;

import java.util.List;

public interface MonHocDAO {
    public abstract void addMH(MonHoc monHoc) throws SQLiteException;
    public abstract void editMH(MonHoc monHoc) throws SQLiteException;
    public abstract void deleteMH(MonHoc monHoc) throws SQLiteException;
    public abstract List<MonHoc> getAll() throws SQLiteException;
}
