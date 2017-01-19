package com.conways.attendancehelper.db.dao;

import com.conways.attendancehelper.utils.StringUtil;
import com.google.gson.Gson;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by Conways on 2017/1/11.
 */

public class MyPropertyConverter implements PropertyConverter<TestSon,String> {
    @Override
    public TestSon convertToEntityProperty(String databaseValue) {
        TestSon son=null;
        if (StringUtil.isEmpty(databaseValue)){
            return null;
        }
        try {
            son= new Gson().fromJson(databaseValue,TestSon.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return son;
    }

    @Override
    public String convertToDatabaseValue(TestSon entityProperty) {
        if (null==entityProperty){
            return "";
        }
        return new Gson().toJson(entityProperty);
    }
}
