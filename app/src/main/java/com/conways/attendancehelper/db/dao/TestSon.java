package com.conways.attendancehelper.db.dao;

/**
 * Created by Conways on 2017/1/11.
 */

public class TestSon {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestSon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
