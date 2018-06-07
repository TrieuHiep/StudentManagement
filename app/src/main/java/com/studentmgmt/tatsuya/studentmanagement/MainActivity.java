package com.studentmgmt.tatsuya.studentmanagement;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.studentmgmt.tatsuya.studentmanagement.dao.BangDiemDAO;
import com.studentmgmt.tatsuya.studentmanagement.dao.MonHocDAO;
import com.studentmgmt.tatsuya.studentmanagement.dao.SVDAO;
import com.studentmgmt.tatsuya.studentmanagement.daoimpl.BangDiemDAOImpl;
import com.studentmgmt.tatsuya.studentmanagement.daoimpl.MonHocDAOImpl;
import com.studentmgmt.tatsuya.studentmanagement.daoimpl.StudentDAOImpl;
import com.studentmgmt.tatsuya.studentmanagement.model.BangDiem;
import com.studentmgmt.tatsuya.studentmanagement.model.MonHoc;
import com.studentmgmt.tatsuya.studentmanagement.model.SinhVien;
import com.studentmgmt.tatsuya.studentmanagement.utils.SQLiteConnector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SVDAO svdao = new StudentDAOImpl(new SQLiteConnector(this));
        MonHocDAO monHocDAO = new MonHocDAOImpl(new SQLiteConnector(this));
        BangDiemDAO bangDiemDAO = new BangDiemDAOImpl(new SQLiteConnector(this));


        try {
            svdao.addSV(new SinhVien(1, "Nam", "nam@gmail.com"));
            svdao.addSV(new SinhVien(2, "Hiep", "hiep@gmail.com"));
            svdao.addSV(new SinhVien(3, "Thanh", "thanh@gmail.com"));

            monHocDAO.addMH(new MonHoc("MH1", "Java", 3));
            monHocDAO.addMH(new MonHoc("MH2", "C++", 3));
            monHocDAO.addMH(new MonHoc("MH3", "Physics", 4));

            for (SinhVien sv : svdao.getAll()) {
                Log.e("SINHVIEN", sv.toString());
            }
            for (MonHoc monHoc : monHocDAO.getAll()) {
                Log.e("MONHOC", monHoc.toString());
            }

            SinhVien sv = new SinhVien(2, "Hiep", "hiep@gmail.com");
            MonHoc monHoc = new MonHoc("MH1", "Java", 3);
            BangDiem bangDiem = new BangDiem(sv, monHoc, 10);
            bangDiemDAO.addBD(bangDiem);

            for (BangDiem bd : bangDiemDAO.getAll()) {
                Log.e("BANGDIEM", bd.getSinhVien().toString());
                Log.e("BANGDIEM", bd.getMonHoc().toString());
                Log.e("BANGDIEM", bd.getDiem() + "");
            }
        } catch (Exception e) {
            Toast.makeText(this, "records have already inserted", Toast.LENGTH_SHORT).show();
        }


        /*
        exception case

         */
        try {
            SinhVien sv = new SinhVien(2, "Hiep", "hiep@gmail.com");
            MonHoc mh = new MonHoc("MH69", "XXX", 3);
            BangDiem bangDiemEX = new BangDiem(sv, mh, 10);
            bangDiemDAO.addBD(bangDiemEX);
        } catch (Exception ex) {
            Toast.makeText(this, "can not insert this record", Toast.LENGTH_SHORT).show();
        }

    }
}
