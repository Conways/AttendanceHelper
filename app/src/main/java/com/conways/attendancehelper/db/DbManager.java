package com.conways.attendancehelper.db;

import android.content.Context;

import com.conways.attendancehelper.db.dao.AttendanceEntityDao;
import com.conways.attendancehelper.db.dao.DaoMaster;
import com.conways.attendancehelper.db.dao.DaoSession;
import com.conways.attendancehelper.model.entity.AttendanceEntity;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by John on 2016/10/24.
 */
public class DbManager {

    private static DbManager instance;
    private AttendanceEntityDao dao;
    private String dbName = "attendance_helper_db";

    private DbManager() {

    }

    public static DbManager getInstance() {
        if (null == instance) {
            synchronized (DbManager.class) {
                if (null == instance) {
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }

    /**
     * 此方法一定要在用之前使用，强烈建议放在applacation初始化
     *
     * @param context
     */
    public void init(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, dbName);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getAttendanceEntityDao();
    }

    /**
     * 插入一条数据
     *
     * @param attEntity
     * @return
     */
    public boolean addAttendace(AttendanceEntity attEntity) {
        check();
        return dao.insert(attEntity) != -1;
    }

    /**
     * 按页获取数据
     *
     * @param page 查询页数
     * @param num  每页条数
     * @return
     */
    public List<AttendanceEntity> getAttends(int page, int num) {
        check();
        return dao.queryBuilder().orderDesc(AttendanceEntityDao.Properties.Data).offset(page * num)
                .limit(num).list();
    }

    /**
     * 获取所有的数据
     *
     * @return
     */
    public List<AttendanceEntity> getAllAttends() {
        check();
        return dao.queryBuilder().orderDesc(AttendanceEntityDao.Properties.Data).list();
    }


    /**
     * 获取最近一次插入的数据
     *
     * @return
     */
    public AttendanceEntity getLastAttend() {
        check();
        QueryBuilder queryBuilder = dao.queryBuilder().orderDesc(AttendanceEntityDao.Properties
                .Data).limit(1);
        List<AttendanceEntity> list = queryBuilder.list();
        AttendanceEntity attendanceEntity = list.size() > 0 ? list.get(0) : null;
        return attendanceEntity;
    }

    /**
     * 修改一条数据
     *
     * @param entity
     */
    public void updateAttend(AttendanceEntity entity) {
        check();
        dao.update(entity);
    }

    private void check() {
        if (null == dao)
            throw new NullPointerException("please init DbManager first,suggest call init(Context" +
                    " context)" + " in applacation oncreate!!!");
    }
}
