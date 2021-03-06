package com.conways.attendancehelper.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.conways.attendancehelper.db.dbEntity.AttendanceEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ATTENDANCE_ENTITY".
*/
public class AttendanceEntityDao extends AbstractDao<AttendanceEntity, Long> {

    public static final String TABLENAME = "ATTENDANCE_ENTITY";

    /**
     * Properties of entity AttendanceEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property OnTime = new Property(1, Long.class, "onTime", false, "ON_TIME");
        public final static Property OffTime = new Property(2, Long.class, "offTime", false, "OFF_TIME");
        public final static Property Data = new Property(3, Long.class, "data", false, "DATA");
        public final static Property IsNormal = new Property(4, boolean.class, "isNormal", false, "IS_NORMAL");
    };


    public AttendanceEntityDao(DaoConfig config) {
        super(config);
    }
    
    public AttendanceEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ATTENDANCE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ON_TIME\" INTEGER," + // 1: onTime
                "\"OFF_TIME\" INTEGER," + // 2: offTime
                "\"DATA\" INTEGER," + // 3: data
                "\"IS_NORMAL\" INTEGER NOT NULL );"); // 4: isNormal
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ATTENDANCE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AttendanceEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long onTime = entity.getOnTime();
        if (onTime != null) {
            stmt.bindLong(2, onTime);
        }
 
        Long offTime = entity.getOffTime();
        if (offTime != null) {
            stmt.bindLong(3, offTime);
        }
 
        Long data = entity.getData();
        if (data != null) {
            stmt.bindLong(4, data);
        }
        stmt.bindLong(5, entity.getIsNormal() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AttendanceEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long onTime = entity.getOnTime();
        if (onTime != null) {
            stmt.bindLong(2, onTime);
        }
 
        Long offTime = entity.getOffTime();
        if (offTime != null) {
            stmt.bindLong(3, offTime);
        }
 
        Long data = entity.getData();
        if (data != null) {
            stmt.bindLong(4, data);
        }
        stmt.bindLong(5, entity.getIsNormal() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AttendanceEntity readEntity(Cursor cursor, int offset) {
        AttendanceEntity entity = new AttendanceEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // onTime
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // offTime
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // data
            cursor.getShort(offset + 4) != 0 // isNormal
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AttendanceEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOnTime(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setOffTime(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setData(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setIsNormal(cursor.getShort(offset + 4) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AttendanceEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AttendanceEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
