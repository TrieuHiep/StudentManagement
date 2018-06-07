package com.studentmgmt.tatsuya.studentmanagement.daoimpl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import com.studentmgmt.tatsuya.studentmanagement.dao.MonHocDAO;
import com.studentmgmt.tatsuya.studentmanagement.model.MonHoc;
import com.studentmgmt.tatsuya.studentmanagement.model.SinhVien;
import com.studentmgmt.tatsuya.studentmanagement.utils.SQLiteConnector;

import java.util.ArrayList;
import java.util.List;

public class MonHocDAOImpl implements MonHocDAO {
    private SQLiteConnector connector;

    public MonHocDAOImpl(SQLiteConnector connector) {
        this.connector = connector;
    }

    @Override
    public void addMH(MonHoc monHoc) throws SQLiteException {
        SQLiteDatabase db = this.connector.getWritableDatabase();
        String sqlCommand = "INSERT INTO monhoc VALUES(?,?,?)";
        SQLiteStatement statement = db.compileStatement(sqlCommand);
        statement.bindString(1,monHoc.getMaMH());
        statement.bindString(2,monHoc.getTenMH());
        statement.bindLong(3,monHoc.getSoTC());
        statement.executeInsert();
        db.close();
    }

    @Override
    public void editMH(MonHoc monHoc) throws SQLiteException {

    }

    @Override
    public void deleteMH(MonHoc monHoc) throws SQLiteException {

    }

    @Override
    public List<MonHoc> getAll() throws SQLiteException {
        List<MonHoc> listMh = new ArrayList<>();
        String selectQuery = "SELECT  * FROM monhoc";
        SQLiteDatabase db = this.connector.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MonHoc mh = new MonHoc();
                mh.setMaMH(cursor.getString(0));
                mh.setTenMH(cursor.getString(1));
                mh.setSoTC(cursor.getInt(2));
                listMh.add(mh);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listMh;
    }
}
