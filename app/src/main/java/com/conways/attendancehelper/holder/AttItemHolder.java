package com.conways.attendancehelper.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.conways.attendancehelper.R;

/**
 * Created by John on 2016/10/21.
 */
public class AttItemHolder extends RecyclerView.ViewHolder {

    public ImageView ivState;
    public TextView tvOn;
    public TextView tvOff;
    public TextView tvDate;

    public AttItemHolder(View itemView) {
        super(itemView);
        init(itemView);
    }

    private void init(View itemView) {
        ivState=(ImageView)itemView.findViewById(R.id.item_attend_state);
        tvOn=(TextView)itemView.findViewById(R.id.item_attend_on);
        tvOff=(TextView)itemView.findViewById(R.id.item_attend_off);
        tvDate=(TextView)itemView.findViewById(R.id.item_attend_date);
    }
}
