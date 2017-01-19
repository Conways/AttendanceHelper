package com.conways.attendancehelper.db.dbEntity;


import com.conways.attendancehelper.db.dao.MyPropertyConverter;
import com.conways.attendancehelper.db.dao.TestSon;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Conways on 2017/1/11.
 */
@Entity
public class TestEntity extends BaseEntity{
    @Id
    private long id;
    private String name;
    @Convert(converter = MyPropertyConverter.class,columnType = String.class)
    private TestSon son;
//    private TestWife wife;

    public TestSon getSon() {
        return this.son;
    }

    public void setSon(TestSon son) {
        this.son = son;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Generated(hash = 489719173)
    public TestEntity(long id, String name, TestSon son) {
        this.id = id;
        this.name = name;
        this.son = son;
    }

    @Generated(hash = 1020448049)
    public TestEntity() {
    }


    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", son=" + son +
                '}';
    }
}
