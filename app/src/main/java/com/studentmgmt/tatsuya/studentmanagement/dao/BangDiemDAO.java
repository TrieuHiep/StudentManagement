package com.studentmgmt.tatsuya.studentmanagement.dao;

import android.database.sqlite.SQLiteException;
import com.studentmgmt.tatsuya.studentmanagement.model.BangDiem;
import com.studentmgmt.tatsuya.studentmanagement.model.MonHoc;

import java.util.List;

public interface BangDiemDAO {
    public abstract void addBD(BangDiem bangDiem) throws SQLiteException;
    public abstract void editBD(BangDiem bangDiem) throws SQLiteException;
    public abstract void deleteBD(BangDiem bangDiem) throws SQLiteException;
    public abstract List<BangDiem> getAll() throws SQLiteException;
}
