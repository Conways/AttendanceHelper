package com.conways.attendancehelper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.holder.AttItemHolder;
import com.conways.attendancehelper.model.AttendanceEntity;
import com.conways.attendancehelper.utils.TimeUtil;

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
        AttendanceEntity entity = list.get(position);
        holder.tvOn.setText(entity.getOnTime() == 0 ? "未打卡" : "上班时间：" + TimeUtil.getTimeFromTimeStamp
                (entity.getOnTime()));
        holder.tvOff.setText(entity.getOffTime() == 0 ? "未打卡" : "下班时间：" + TimeUtil
                .getTimeFromTimeStamp(entity
                        .getOffTime()));
        holder.tvDate.setText(entity.getData() == 0 ? "" : TimeUtil.getDateFromTimeStamp(entity
                .getData()) + " " + TimeUtil.getWeekDayFromTimeStamp(entity.getData()));
        holder.ivState.setImageResource(isNormal(entity) ? R.drawable.state_on : R.drawable.state_off);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private boolean isNormal(AttendanceEntity entity) {
        return false;
    }
}
