package com.studentmgmt.tatsuya.studentmanagement.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLiteConnector extends SQLiteOpenHelper {
    private static final String dbName = "scoremgmt";
    private Context context;

    public SQLiteConnector(Context context) {
        super(context, dbName, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateSinhVien = "CREATE TABLE sinhvien " +
                "( " +
                "masv INTEGER PRIMARY KEY, " +
                "tensv TEXT, " +
                "email TEXT " +
                ")";

        String sqlCreateMonHoc = "CREATE TABLE monhoc " +
                "( " +
                "mamh TEXT PRIMARY KEY, " +
                "tenmh TEXT, " +
                "sotc INTEGER " +
                ")";

        String sqlCreateBangDiem = "CREATE TABLE bangdiem " +
                "(" +
                "masv INTEGER, " +
                "mamh TEXT, " +
                "diem INTEGER, " +
                "FOREIGN KEY (masv) REFERENCES sinhvien(masv) , " +
                "FOREIGN KEY (mamh) REFERENCES monhoc(mamh), " +
                "PRIMARY KEY (masv, mamh)" +
                ")";
        db.execSQL(sqlCreateSinhVien);
        db.execSQL(sqlCreateMonHoc);
        db.execSQL(sqlCreateBangDiem);
        Toast.makeText(context, "create successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
