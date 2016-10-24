package com.conways.attendancehelper.presenter;

import android.content.Context;

import com.conways.attendancehelper.db.DbManager;
import com.conways.attendancehelper.model.AttendanceEntity;
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
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setData(now);
        attendanceEntity.setOnTime(now);
        attendanceEntity.setOffTime(now);
//        attendanceEntity.setIsNormal();
        if (DbManager.getInstance().addAttendace(attendanceEntity)) {
            view.update();
        }

    }

}
