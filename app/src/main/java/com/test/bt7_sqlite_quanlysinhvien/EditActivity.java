package com.test.bt7_sqlite_quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.test.bt7_sqlite_quanlysinhvien.dao.SinhVienDAO;
import com.test.bt7_sqlite_quanlysinhvien.model.SinhVien;

public class EditActivity extends AppCompatActivity {
    private EditText edtHoTen_361, edtDienThoai_361, edtEmail_361;
    private RadioGroup rgGioiTinh_361;
    private Button btnLuu_361, btnThoat_361;
    private RadioButton rbNam_361, rbNu_361;
    int gioitinh_361;
    private SinhVienDAO svDao_361;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        svDao_361 = new SinhVienDAO(EditActivity.this);

        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien)intent.getSerializableExtra("DULIEU");

        AnhXa();

        edtHoTen_361.setText(sinhVien.getHoTen_361());
        edtDienThoai_361.setText(sinhVien.getDienThoai_361());
        edtEmail_361.setText(sinhVien.getEmail_361());
        if(sinhVien.getGioiTinh_361()==1) {
            rbNam_361.setChecked(true);
            gioitinh_361 = 1;
        }
        else {
            rbNu_361.setChecked(true);
            gioitinh_361 = 0;
        }

        btnThoat_361.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rgGioiTinh_361.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam)
                    gioitinh_361 = 1;
                else
                    gioitinh_361 = 0;
            }
        });

        btnLuu_361.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhVien.setHoTen_361(edtHoTen_361.getText().toString());
                sinhVien.setDienThoai_361(edtDienThoai_361.getText().toString());
                sinhVien.setEmail_361(edtEmail_361.getText().toString());
                sinhVien.setGioiTinh_361(gioitinh_361);
                svDao_361.CapNhatSinhVien(sinhVien);
            }
        });
    }

    private void AnhXa() {
        edtHoTen_361 = (EditText) findViewById(R.id.edt_hoten);
        edtDienThoai_361 = (EditText) findViewById(R.id.edt_dienthoai);
        edtEmail_361 = (EditText) findViewById(R.id.edt_email);
        rgGioiTinh_361 = (RadioGroup) findViewById(R.id.rg_gioitinh);
        rbNam_361 = (RadioButton) findViewById(R.id.rb_nam);
        rbNu_361 = (RadioButton) findViewById(R.id.rb_nu);
        btnLuu_361 = (Button) findViewById(R.id.bt_luu);
        btnThoat_361 = (Button) findViewById(R.id.bt_thoat);
    }
}