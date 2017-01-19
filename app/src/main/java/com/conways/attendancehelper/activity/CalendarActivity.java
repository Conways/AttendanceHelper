package com.conways.attendancehelper.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.adapter.CalendarPageAdapter;
import com.conways.attendancehelper.db.dao.TestSon;
import com.conways.attendancehelper.db.dbEntity.TestEntity;
import com.conways.attendancehelper.db.dbmanager.TestDbManager;
import com.conways.attendancehelper.fragment.BaseFragment;
import com.conways.attendancehelper.fragment.CalendarPageFragment;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends FragmentActivity {

    private Toolbar toolbar;
    private ImageView iv;
    private TextView tv;

    private ViewPager viewPager;
    private CalendarPageAdapter calendarPageAdapter;
    private List<BaseFragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initTitle();
        initData();
        initView();
//        update(System.currentTimeMillis());
    }

    private void initTitle(){
        toolbar=(Toolbar)this.findViewById(R.id.toolbar);
        toolbar.setTitle("Title");
        toolbar.setSubtitle("subTitle");
    }

    private void initData() {
        list = new ArrayList<>();
    }

    private void initView() {
//        viewPager = (ViewPager) this.findViewById(R.id.vp);
//        iv=(ImageView)this.findViewById(R.id.iv);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TestEntity entity=new TestEntity();
//                entity.setName(System.currentTimeMillis()+"");
//                TestSon testSon=new TestSon();
//                testSon.setName("son");
//                testSon.setId(System.currentTimeMillis());
//                boolean has=TestDbManager.getInstance().addAttendace(entity);
//                if (has){
//                    Toast.makeText(CalendarActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(CalendarActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        tv=(TextView)this.findViewById(R.id.tv);
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv.setText(TestDbManager.getInstance().getAllAttends().toString());
//            }
//        });

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
