package com.conways.attendancehelper.db.dbmanager;

import android.content.Context;

import com.conways.attendancehelper.db.dao.AttendanceEntityDao;
import com.conways.attendancehelper.db.dao.TestEntityDao;
import com.conways.attendancehelper.db.dbEntity.AttendanceEntity;
import com.conways.attendancehelper.db.dbEntity.TestEntity;

import java.util.List;

/**
 * Created by Conways on 2017/1/11.
 */

public class TestDbManager extends BaseManager{

    private static TestDbManager instance;
    private TestEntityDao dao;


    private TestDbManager() {

    }

    public static TestDbManager getInstance() {
        if (null == instance) {
            synchronized (TestDbManager.class) {
                if (null == instance) {
                    instance = new TestDbManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context){
        super.init(context);
        dao =daoSession.getTestEntityDao();
    }

    /**
     * 插入一条数据
     * @param testEntity
     * @return
     */
    public boolean addAttendace(TestEntity testEntity) {
        check(dao);
        return dao.insert(testEntity) != -1;
    }


    /**
     * 获取所有的数据
     *
     * @return
     */
    public List<TestEntity> getAllAttends() {
        check(dao);
        return dao.queryBuilder().orderDesc(TestEntityDao.Properties.Id).list();
    }
}
