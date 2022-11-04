package com.test.bt7_sqlite_quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.bt7_sqlite_quanlysinhvien.R;
import com.test.bt7_sqlite_quanlysinhvien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> sinhVienList_361;
    private Context context_361;
    public SinhVienAdapter(Context context, List<SinhVien> list) {
        this.context_361 = context;
        this.sinhVienList_361 = list;
    }

    @Override

    public int getCount() {
        return sinhVienList_361.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder_361;
        if (view == null){
            viewHolder_361 = new ViewHolder();
            LayoutInflater inflater_361 = (LayoutInflater) context_361.getSystemService(context_361.LAYOUT_INFLATER_SERVICE);
            view = inflater_361.inflate(R.layout.list_item_sinhvien, null);
            viewHolder_361.tvMaSV_361 = view.findViewById(R.id.tv_masv);
            viewHolder_361.tvHoTen_361 = view.findViewById(R.id.tv_hoten);
            viewHolder_361.tvDienThoai_361 = view.findViewById(R.id.tv_dienthoai);
            viewHolder_361.tvEmail_361 = view.findViewById(R.id.tv_email);
            viewHolder_361.ivGioiTinh_361 = view.findViewById(R.id.iv_gioitinh);

            view.setTag(viewHolder_361);
        }
        else {
            viewHolder_361 = (ViewHolder) view.getTag();
        }
        SinhVien sv_361 = sinhVienList_361.get(i);
        viewHolder_361.tvMaSV_361.setText("Mã SV: "+sv_361.getMaSV());
        viewHolder_361.tvHoTen_361.setText("Họ tên: "+sv_361.getHoTen_361());
        viewHolder_361.tvDienThoai_361.setText("Điện thoại: "+sv_361.getDienThoai_361());
        viewHolder_361.tvEmail_361.setText("Email: "+sv_361.getEmail_361());
        if(sv_361.getGioiTinh_361()==0)
            viewHolder_361.ivGioiTinh_361.setImageResource(R.drawable.avatar_nu);
        else
            viewHolder_361.ivGioiTinh_361.setImageResource(R.drawable.avatar_nam);
        return view;
    }

    class ViewHolder{
        ImageView ivGioiTinh_361;
        TextView tvMaSV_361, tvHoTen_361, tvDienThoai_361, tvEmail_361;
    }
}
