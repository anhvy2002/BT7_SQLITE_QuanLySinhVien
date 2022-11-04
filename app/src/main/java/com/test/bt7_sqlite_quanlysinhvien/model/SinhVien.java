package com.test.bt7_sqlite_quanlysinhvien.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int MaSV_361;
    private String HoTen_361;
    private int GioiTinh_361;
    private String DienThoai_361;
    private String Email_361;

    public SinhVien() {
    }

    public SinhVien(String hoTen, int gioiTinh, String dienThoai, String email) {
        HoTen_361 = hoTen;
        GioiTinh_361 = gioiTinh;
        DienThoai_361 = dienThoai;
        Email_361 = email;
    }

    public SinhVien(int maSV, String hoTen, int gioiTinh, String dienThoai, String email) {
        MaSV_361 = maSV;
        HoTen_361 = hoTen;
        GioiTinh_361 = gioiTinh;
        DienThoai_361 = dienThoai;
        Email_361 = email;
    }

    public int getMaSV() {
        return MaSV_361;
    }

    public void setMaSV(int maSV) {
        MaSV_361 = maSV;
    }

    public String getHoTen_361() {
        return HoTen_361;
    }

    public void setHoTen_361(String hoTen_361) {
        HoTen_361 = hoTen_361;
    }

    public int getGioiTinh_361() {
        return GioiTinh_361;
    }

    public void setGioiTinh_361(int gioiTinh_361) {
        GioiTinh_361 = gioiTinh_361;
    }

    public String getDienThoai_361() {
        return DienThoai_361;
    }

    public void setDienThoai_361(String dienThoai_361) {
        DienThoai_361 = dienThoai_361;
    }

    public String getEmail_361() {
        return Email_361;
    }

    public void setEmail_361(String email_361) {
        Email_361 = email_361;
    }
}
