package com.studentmgmt.tatsuya.studentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.studentmgmt.tatsuya.studentmanagement.adapter.BDAdapter;
import com.studentmgmt.tatsuya.studentmanagement.dao.BangDiemDAO;
import com.studentmgmt.tatsuya.studentmanagement.dao.MonHocDAO;
import com.studentmgmt.tatsuya.studentmanagement.dao.SVDAO;
import com.studentmgmt.tatsuya.studentmanagement.daoimpl.BangDiemDAOImpl;
import com.studentmgmt.tatsuya.studentmanagement.daoimpl.MonHocDAOImpl;
import com.studentmgmt.tatsuya.studentmanagement.daoimpl.SinhVienDAOImpl;
import com.studentmgmt.tatsuya.studentmanagement.model.BangDiem;
import com.studentmgmt.tatsuya.studentmanagement.model.MonHoc;
import com.studentmgmt.tatsuya.studentmanagement.model.SinhVien;
import com.studentmgmt.tatsuya.studentmanagement.utils.SQLiteConnector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spnSV;
    private Spinner spnMH;
    private EditText txtScore;
    private Button btnAddScore;
    private ListView listViewBD;

    private SVDAO svdao;
    private MonHocDAO monHocDAO;
    private BangDiemDAO bangDiemDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.svdao = new SinhVienDAOImpl(new SQLiteConnector(this));
        this.monHocDAO = new MonHocDAOImpl(new SQLiteConnector(this));
        this.bangDiemDAO = new BangDiemDAOImpl(new SQLiteConnector(this));
        initCase();
        initComponents();
    }

    private void initComponents() {
        this.spnSV = super.findViewById(R.id.spinnerSV);
        this.spnMH = super.findViewById(R.id.spinnerMH);
        this.txtScore = super.findViewById(R.id.txtDiemSV);
        this.btnAddScore = super.findViewById(R.id.btnAddBD);
        this.listViewBD = super.findViewById(R.id.listBD);

        List<SinhVien> listSV = svdao.getAll();
        List<MonHoc> listMonHoc = monHocDAO.getAll();
        List<BangDiem> listBD = bangDiemDAO.getAll();

        ArrayAdapter<SinhVien> svAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listSV);
        svAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnSV.setAdapter(svAdapter);

        ArrayAdapter<MonHoc> mhAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listMonHoc);
        mhAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spnMH.setAdapter(mhAdapter);

        BDAdapter bdAdapter = new BDAdapter(this,R.layout.bd_line,listBD);
        this.listViewBD.setAdapter(bdAdapter);


        this.btnAddScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien targetSV = (SinhVien) spnSV.getSelectedItem();
                MonHoc monHoc = (MonHoc) spnMH.getSelectedItem();
                int score = Integer.parseInt(txtScore.getText().toString().trim());
                BangDiem bd = new BangDiem(targetSV, monHoc, score);
                bangDiemDAO.addBD(bd);
                for (BangDiem b : bangDiemDAO.getAll()) {
                    Log.e("BANGDIEM", b.getSinhVien().toString());
                    Log.e("BANGDIEM", b.getMonHoc().toString());
                    Log.e("BANGDIEM", b.getDiem() + "");
                }
                listViewBD.setAdapter(new BDAdapter(MainActivity.this,R.layout.bd_line, bangDiemDAO.getAll()));
            }
        });
    }

    private void initCase() {
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


        } catch (Exception e) {
            Toast.makeText(this, "records have already inserted", Toast.LENGTH_SHORT).show();
        }

        for (BangDiem bd : bangDiemDAO.getAll()) {
            Log.e("BANGDIEM", bd.getSinhVien().toString());
            Log.e("BANGDIEM", bd.getMonHoc().toString());
            Log.e("BANGDIEM", bd.getDiem() + "");
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
