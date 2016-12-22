package com.conways.attendancehelper.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.adapter.CalendarPageAdapter;
import com.conways.attendancehelper.fragment.CalendarPageFragment;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends FragmentActivity implements CalendarPageFragment.OnFragmentInteractionListener {
    private ViewPager viewPager;
    private CalendarPageAdapter calendarPageAdapter;
    private List<Fragment> list;

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
        viewPager = (ViewPager) this.findViewById(R.id.calendar_pager_grid);
    }

    private void update(long currentTime) {
        list.clear();
        list.add(CalendarPageFragment.newInstance(currentTime));
        list.add(CalendarPageFragment.newInstance(currentTime));
        list.add(CalendarPageFragment.newInstance(currentTime));
        if (null == calendarPageAdapter) {
            calendarPageAdapter = new CalendarPageAdapter(getSupportFragmentManager(), list);
            viewPager.setAdapter(calendarPageAdapter);
        } else {
            calendarPageAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
