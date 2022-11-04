package com.test.bt7_sqlite_quanlysinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.bt7_sqlite_quanlysinhvien.database.DbHelper;
import com.test.bt7_sqlite_quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private DbHelper csdl_361;
    public SinhVienDAO(Context context) {
        csdl_361 = new DbHelper(context);
    }
    //lấy tất cả sv
    public List<SinhVien> TatCaSinhVien(){
        String sql_361 = "SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList_361 = new ArrayList<SinhVien>();
        SQLiteDatabase database_361 = csdl_361.getReadableDatabase();
        Cursor cursor_361 = database_361.rawQuery(sql_361,null);
        cursor_361.moveToFirst();
        while (!cursor_361.isAfterLast()){
            int masv_361 = cursor_361.getInt(0);
            String hoten_361 = cursor_361.getString(1);
            int gioitinh_361 = cursor_361.getInt(2);
            String dienthoai_361 = cursor_361.getString(3);
            String email_361 = cursor_361.getString(4);
            SinhVien sv_361 = new SinhVien(masv_361,hoten_361,gioitinh_361,dienthoai_361,email_361);
            sinhVienList_361.add(sv_361);
            cursor_361.moveToNext();
        }
        return sinhVienList_361;
    }
    //thêm
    public void ThemSinhVien(SinhVien sv){
        SQLiteDatabase database_361 = csdl_361.getWritableDatabase();
        ContentValues values_361 = new ContentValues();
        values_361.put("HoTen",sv.getHoTen_361());
        values_361.put("GioiTinh",sv.getGioiTinh_361());
        values_361.put("DienThoai",sv.getDienThoai_361());
        values_361.put("Email",sv.getEmail_361());
        database_361.insert("SinhVien","",values_361);
    }
    //cập nhật
    public void CapNhatSinhVien(SinhVien sv){
        SQLiteDatabase database_361 = csdl_361.getWritableDatabase();
        ContentValues values_361 = new ContentValues();
        values_361.put("HoTen",sv.getHoTen_361());
        values_361.put("DienThoai",sv.getDienThoai_361());
        values_361.put("Email",sv.getEmail_361());
        values_361.put("GioiTinh",sv.getGioiTinh_361());
        String masv = String.valueOf(sv.getMaSV());
        String thamso[]={masv};
        database_361.update("SinhVien", values_361,"MaSV=?",thamso);
    }

}
