package com.conways.attendancehelper.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.adapter.CalendarPageAdapter;
import com.conways.attendancehelper.fragment.BaseFragment;
import com.conways.attendancehelper.fragment.CalendarPageFragment;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends FragmentActivity {
    private ViewPager viewPager;
    private CalendarPageAdapter calendarPageAdapter;
    private List<BaseFragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initData();
        initView();
        update(System.currentTimeMillis());
    }

    private void initData() {
        list = new ArrayList<>();
    }

    private void initView() {
        viewPager = (ViewPager) this.findViewById(R.id.vp);
    }

    private void update(long currentTime) {
        list.clear();
        list.add(new CalendarPageFragment());
        list.add(new CalendarPageFragment());
        list.add(new CalendarPageFragment());
        if (null == calendarPageAdapter) {
            calendarPageAdapter = new CalendarPageAdapter(getSupportFragmentManager(), list);
            viewPager.setAdapter(calendarPageAdapter);
        } else {
            calendarPageAdapter.notifyDataSetChanged();
        }
    }

}
