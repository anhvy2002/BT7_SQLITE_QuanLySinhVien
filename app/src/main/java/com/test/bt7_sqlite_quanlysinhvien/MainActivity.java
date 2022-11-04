package com.test.bt7_sqlite_quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.bt7_sqlite_quanlysinhvien.adapter.SinhVienAdapter;
import com.test.bt7_sqlite_quanlysinhvien.dao.SinhVienDAO;
import com.test.bt7_sqlite_quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvSinhVien_361;
    private List<SinhVien> sinhVienList_361;
    private SinhVienAdapter adapter_361;
    private SinhVienDAO svDao_361;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien_361 = (ListView) findViewById(R.id.lv_sinhvien);
        sinhVienList_361 = new ArrayList<SinhVien>();
        svDao_361 = new SinhVienDAO(MainActivity.this);
        sinhVienList_361 = svDao_361.TatCaSinhVien();

        adapter_361 = new SinhVienAdapter(getApplicationContext(), sinhVienList_361);
        lvSinhVien_361.setAdapter(adapter_361);
        SuKien_ListView();
    }

    private void SuKien_ListView() {
        lvSinhVien_361.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = sinhVienList_361.get(i);
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("DULIEU", sv);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_them){
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }
        if (id == R.id.menu_thoat)
            finish();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList_361.clear();
        sinhVienList_361.addAll(svDao_361.TatCaSinhVien());
        adapter_361.notifyDataSetChanged();
    }

}