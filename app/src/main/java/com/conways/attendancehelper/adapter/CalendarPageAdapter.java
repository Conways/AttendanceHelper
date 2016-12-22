package com.conways.attendancehelper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.conways.attendancehelper.fragment.BaseFragment;

import java.util.List;

/**
 * Created by John on 2016/12/22.
 */

public class CalendarPageAdapter extends FragmentPagerAdapter {


    private List<BaseFragment> list;

    public CalendarPageAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
