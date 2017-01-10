package com.conways.attendancehelper.model;

import com.conways.attendancehelper.db.DbManager;
import com.conways.attendancehelper.db.dbEntity.AttendanceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2016/12/22.
 */

public class MainModel {

    public MainModel() {
    }

    private List<AttendanceEntity> list;


    public List<AttendanceEntity> loadAllData() {
        if (null == list) {
            list = new ArrayList<>();
        }
        list.clear();
        list.addAll(DbManager.getInstance().getAllAttends());
        return list;
    }


    public AttendanceEntity loadLastedData() {
        return DbManager.getInstance().getLastAttend();
    }


    public boolean addData(AttendanceEntity attendanceEntity) {
        return false;
    }


}
