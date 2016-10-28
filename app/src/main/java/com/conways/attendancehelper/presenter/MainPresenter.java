package com.conways.attendancehelper.presenter;

import android.content.Context;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.db.DbManager;
import com.conways.attendancehelper.model.AttendanceEntity;
import com.conways.attendancehelper.utils.TimeUtil;
import com.conways.attendancehelper.view.MainView;

/**
 * Created by John on 2016/10/21.
 */
public class MainPresenter {

    private MainView view;
    private Context context;


    public MainPresenter(MainView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void action() {
        long now = System.currentTimeMillis();

        AttendanceEntity entity = DbManager.getInstance().getLastAttend();
        if (null == entity || !TimeUtil.isSameDay(now, entity.getData())) {
            AttendanceEntity attendanceEntity = new AttendanceEntity();
            attendanceEntity.setData(now);
            attendanceEntity.setOnTime(now);
            if (DbManager.getInstance().addAttendace(attendanceEntity)) {
                view.update();
            } else {
                view.showMsg(R.string.app_name);
            }
            return;
        }

        if (TimeUtil.isSameDay(now, entity.getData())) {
            entity.setOffTime(now);
            entity.setData(now);
            DbManager.getInstance().updateAttend(entity);
            view.update();
            return;
        }


    }


}
