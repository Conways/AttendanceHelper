package com.conways.attendancehelper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.holder.AttItemHolder;
import com.conways.attendancehelper.model.AttendanceEntity;

import java.util.List;

/**
 * Created by John on 2016/10/21.
 */
public class AttendAdapter extends RecyclerView.Adapter<AttItemHolder> {

    private List<AttendanceEntity> list;
    private Context context;

    public AttendAdapter(List<AttendanceEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public AttItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_attend, parent, false);
        return new AttItemHolder(v);
    }

    @Override
    public void onBindViewHolder(AttItemHolder holder, int position) {
        holder.tvDate.setText("xxxx-xx-xx");
        holder.tvOn.setText(list.get(position).getId()+"");
        holder.tvOff.setText("Off");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
