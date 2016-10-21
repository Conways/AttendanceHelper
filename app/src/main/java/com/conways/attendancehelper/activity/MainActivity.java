package com.conways.attendancehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void init() {

    }

    @Override
    public void setState(String state) {

    }
}
