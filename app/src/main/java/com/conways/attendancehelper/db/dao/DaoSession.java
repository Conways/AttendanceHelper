package com.conways.attendancehelper.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.conways.attendancehelper.model.entity.AttendanceEntity;

import com.conways.attendancehelper.db.dao.AttendanceEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig attendanceEntityDaoConfig;

    private final AttendanceEntityDao attendanceEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        attendanceEntityDaoConfig = daoConfigMap.get(AttendanceEntityDao.class).clone();
        attendanceEntityDaoConfig.initIdentityScope(type);

        attendanceEntityDao = new AttendanceEntityDao(attendanceEntityDaoConfig, this);

        registerDao(AttendanceEntity.class, attendanceEntityDao);
    }
    
    public void clear() {
        attendanceEntityDaoConfig.getIdentityScope().clear();
    }

    public AttendanceEntityDao getAttendanceEntityDao() {
        return attendanceEntityDao;
    }

}
