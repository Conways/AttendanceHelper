package com.conways.attendancehelper;

import android.app.Application;

import com.conways.attendancehelper.db.dbmanager.DbManager;
import com.conways.attendancehelper.db.dbmanager.TestDbManager;

/**
 * Created by John on 2016/10/20.
 */
public class AttHelperApplacation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initDb();
    }

    private void initDb() {
        DbManager.getInstance().init(this);
        TestDbManager.getInstance().init(this);
    }
}
