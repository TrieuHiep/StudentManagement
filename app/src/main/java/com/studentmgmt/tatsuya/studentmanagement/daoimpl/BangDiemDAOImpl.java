package com.studentmgmt.tatsuya.studentmanagement.daoimpl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import com.studentmgmt.tatsuya.studentmanagement.dao.BangDiemDAO;
import com.studentmgmt.tatsuya.studentmanagement.model.BangDiem;
import com.studentmgmt.tatsuya.studentmanagement.model.MonHoc;
import com.studentmgmt.tatsuya.studentmanagement.model.SinhVien;
import com.studentmgmt.tatsuya.studentmanagement.utils.SQLiteConnector;

import java.util.ArrayList;
import java.util.List;

public class BangDiemDAOImpl implements BangDiemDAO {
    private SQLiteConnector connector;

    public BangDiemDAOImpl(SQLiteConnector connector) {
        this.connector = connector;
    }

    @Override
    public void addBD(BangDiem bangDiem) throws SQLiteException {
        SQLiteDatabase db = this.connector.getWritableDatabase();
        String sqlCommand = "INSERT INTO bangdiem VALUES(?,?,?)";
        SQLiteStatement statement = db.compileStatement(sqlCommand);
        statement.bindLong(1, bangDiem.getSinhVien().getMaSV());
        statement.bindString(2, bangDiem.getMonHoc().getMaMH());
        statement.bindLong(3, bangDiem.getDiem());
        statement.executeInsert();
        db.close();
    }

    @Override
    public void editBD(BangDiem bangDiem) throws SQLiteException {

    }

    @Override
    public void deleteBD(BangDiem bangDiem) throws SQLiteException {

    }

    @Override
    public List<BangDiem> getAll() throws SQLiteException {
        List<BangDiem> listBD = new ArrayList<>();
        String selectQuery = "SELECT  * FROM bangdiem, sinhvien, monhoc WHERE bangdiem.masv = sinhvien.masv AND bangdiem.mamh = monhoc.mamh";
        SQLiteDatabase db = this.connector.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BangDiem bd = new BangDiem();

                SinhVien sv = new SinhVien();
                sv.setMaSV(cursor.getInt(cursor.getColumnIndex("masv")));
                sv.setTenSV(cursor.getString(cursor.getColumnIndex("tensv")));
                sv.setEmail(cursor.getString(cursor.getColumnIndex("email")));

                MonHoc monHoc = new MonHoc();
                monHoc.setMaMH(cursor.getString(cursor.getColumnIndex("mamh")));
                monHoc.setTenMH(cursor.getString(cursor.getColumnIndex("tenmh")));
                monHoc.setSoTC(cursor.getInt(cursor.getColumnIndex("sotc")));

                bd.setSinhVien(sv);
                bd.setMonHoc(monHoc);
                bd.setDiem(cursor.getInt(cursor.getColumnIndex("diem")));
                listBD.add(bd);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listBD;
    }
}
