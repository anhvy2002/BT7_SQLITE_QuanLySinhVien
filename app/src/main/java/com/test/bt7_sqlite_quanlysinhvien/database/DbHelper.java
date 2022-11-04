package com.test.bt7_sqlite_quanlysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "QLSinhVien.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate_361 = "CREATE TABLE IF NOT EXISTS "+
                "SinhVien(MaSV INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "HoTen NVARCHAR(200), "+
                "GioiTinh INTEGER, "+
                "DienThoai varchar(13), "+
                "Email VARCHAR(200))";
        sqLiteDatabase.execSQL(sqlSVCreate_361);
        String sqlInsert1_361 = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES ('Đang Thi Anh Vy','0','0332455684','anhvy@gmail.com')";
        String sqlInsert2_361 = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES ('Mai Thi Nga','0','0484842128','nga123@gmail.com')";
        String sqlInsert3_361 = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES ('Nguyen Van Hung','1','0948221318','nguyenhung@gmail.com')";
        sqLiteDatabase.execSQL(sqlInsert1_361);
        sqLiteDatabase.execSQL(sqlInsert2_361);
        sqLiteDatabase.execSQL(sqlInsert3_361);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
