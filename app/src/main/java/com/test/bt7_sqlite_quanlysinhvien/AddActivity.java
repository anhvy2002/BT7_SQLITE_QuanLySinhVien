package com.test.bt7_sqlite_quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.test.bt7_sqlite_quanlysinhvien.dao.SinhVienDAO;
import com.test.bt7_sqlite_quanlysinhvien.model.SinhVien;

public class AddActivity extends AppCompatActivity {

    private EditText edtHoTen_361, edtDienThoai_361, edtEmail_361;
    private RadioGroup rgGioiTinh_361;
    private Button btnThem_361, btnThoat_361;
    private int gioitinh_361;
    private SinhVienDAO svDao_361;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        AnhXa();
        svDao_361 = new SinhVienDAO(AddActivity.this);
        rgGioiTinh_361.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam)
                    gioitinh_361 = 1;
                else
                    gioitinh_361 = 0;
            }
        });
        btnThem_361.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten_361 = edtHoTen_361.getText().toString();
                String dienthoai_361 = edtDienThoai_361.getText().toString();
                String email_361 = edtEmail_361.getText().toString();
                SinhVien sv_361 = new SinhVien(hoten_361, gioitinh_361,dienthoai_361,email_361);
                svDao_361.ThemSinhVien(sv_361);
            }
        });
        btnThoat_361.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void AnhXa(){
        edtHoTen_361 = (EditText) findViewById(R.id.edt_hoten);
        edtDienThoai_361 = (EditText) findViewById(R.id.edt_dienthoai);
        edtEmail_361 = (EditText) findViewById(R.id.edt_email);
        rgGioiTinh_361 = (RadioGroup) findViewById(R.id.rg_gioitinh);
        btnThem_361 = (Button) findViewById(R.id.bt_them);
        btnThoat_361 = (Button) findViewById(R.id.bt_thoat);
    }
}