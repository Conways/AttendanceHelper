package com.conways.attendancehelper.db.dbmanager;

import android.content.Context;

import com.conways.attendancehelper.db.dao.DaoMaster;
import com.conways.attendancehelper.db.dao.DaoSession;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by Conways on 2017/1/11.
 */

public  class BaseManager {

    private String dbName = "attendance_helper_db";
    protected DaoSession daoSession;

    public BaseManager() {
    }

    protected void init(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, dbName);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession= daoMaster.newSession();
    }

    protected void check(AbstractDao dao) {
        if (null == dao)
            throw new NullPointerException("please init Manager first,suggest call init(Context" +
                    " context)" + " in applacation oncreate!!!");
    }

}
