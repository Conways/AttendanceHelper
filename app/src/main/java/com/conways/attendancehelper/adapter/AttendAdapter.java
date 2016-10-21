package com.conways.attendancehelper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.conways.attendancehelper.holder.AttItemHolder;
import com.conways.attendancehelper.model.AttEntity;

import java.util.List;

/**
 * Created by John on 2016/10/21.
 */
public class AttendAdapter extends RecyclerView.Adapter<AttItemHolder> {

    private List<AttEntity> list;
    private Context context;

    public AttendAdapter(List<AttEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public AttItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AttItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
