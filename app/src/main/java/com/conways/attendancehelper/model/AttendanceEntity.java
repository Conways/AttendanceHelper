package com.conways.attendancehelper.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by John on 2016/10/24.
 */
@Entity
public class AttendanceEntity extends BaseEntity {
    @Id
    private Long id;
    private Long onTime;
    private Long offTime;
    private Long data;
    private boolean isNormal;
    public boolean getIsNormal() {
        return this.isNormal;
    }
    public void setIsNormal(boolean isNormal) {
        this.isNormal = isNormal;
    }
    public Long getData() {
        return this.data;
    }
    public void setData(Long data) {
        this.data = data;
    }
    public Long getOffTime() {
        return this.offTime;
    }
    public void setOffTime(Long offTime) {
        this.offTime = offTime;
    }
    public Long getOnTime() {
        return this.onTime;
    }
    public void setOnTime(Long onTime) {
        this.onTime = onTime;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1863429355)
    public AttendanceEntity(Long id, Long onTime, Long offTime, Long data,
            boolean isNormal) {
        this.id = id;
        this.onTime = onTime;
        this.offTime = offTime;
        this.data = data;
        this.isNormal = isNormal;
    }
    @Generated(hash = 1266809521)
    public AttendanceEntity() {
    }



}
