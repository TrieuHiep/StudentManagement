package com.studentmgmt.tatsuya.studentmanagement.daoimpl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import com.studentmgmt.tatsuya.studentmanagement.dao.SVDAO;
import com.studentmgmt.tatsuya.studentmanagement.model.SinhVien;
import com.studentmgmt.tatsuya.studentmanagement.utils.SQLiteConnector;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements SVDAO {
    private SQLiteConnector connector;

    public StudentDAOImpl(SQLiteConnector connector) {
        this.connector = connector;
    }

    @Override
    public void addSV(SinhVien sinhVien) throws SQLiteException {
        SQLiteDatabase db = this.connector.getWritableDatabase();
        String sqlCommand = "INSERT INTO sinhvien VALUES(?,?,?)";
        SQLiteStatement statement = db.compileStatement(sqlCommand);
        statement.bindLong(1, sinhVien.getMaSV());
        statement.bindString(2, sinhVien.getTenSV());
        statement.bindString(3, sinhVien.getEmail());
        statement.executeInsert();
        db.close();
    }

    @Override
    public boolean editSV(SinhVien sinhVien) throws SQLiteException {
        return false;
    }

    @Override
    public boolean deleteSV(SinhVien sinhVien) throws SQLiteException {
        return false;
    }

    @Override
    public List<SinhVien> getAll() throws SQLiteException {
        List<SinhVien> listSV = new ArrayList<>();
        String selectQuery = "SELECT  * FROM sinhvien";
        SQLiteDatabase db = this.connector.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
                sv.setMaSV(cursor.getInt(0));
                sv.setTenSV(cursor.getString(1));
                sv.setEmail(cursor.getString(2));
                listSV.add(sv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listSV;
    }
}
