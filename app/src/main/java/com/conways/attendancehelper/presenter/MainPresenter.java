package com.conways.attendancehelper.presenter;

import android.content.Context;
import android.content.Intent;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.activity.CalendarActivity;
import com.conways.attendancehelper.db.dbmanager.DbManager;
import com.conways.attendancehelper.model.MainModel;
import com.conways.attendancehelper.db.dbEntity.AttendanceEntity;
import com.conways.attendancehelper.utils.TimeUtil;
import com.conways.attendancehelper.view.MainView;

import java.util.List;

/**
 * Created by John on 2016/10/21.
 */
public class MainPresenter {

    private MainView view;
    private Context context;
    private MainModel mainModel;


    public MainPresenter(MainView view, Context context) {
        this.view = view;
        this.context = context;
        mainModel = new MainModel();
    }

    public void action() {
        long now = System.currentTimeMillis();
        AttendanceEntity entity = mainModel.loadLastedData();
        if (null == entity || !TimeUtil.isSameDay(now, entity.getData())) {
            AttendanceEntity attendanceEntity = new AttendanceEntity();
            attendanceEntity.setData(now);
            attendanceEntity.setOnTime(now);
            if (mainModel.addData(attendanceEntity)) {
                view.update();
            } else {
                view.showMsg(R.string.app_name);
            }
        } else {
            entity.setOffTime(now);
            entity.setData(now);
            DbManager.getInstance().updateAttend(entity);
            view.update();
        }

    }


    public List<AttendanceEntity> getEntities() {
        return mainModel.loadAllData();
    }

    public void toCalendar() {
        Intent intent = new Intent();
        intent.setClass(context, CalendarActivity.class);
        context.startActivity(intent);
    }


}
