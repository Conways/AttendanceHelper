package com.conways.attendancehelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.adapter.AttendAdapter;
import com.conways.attendancehelper.presenter.MainPresenter;
import com.conways.attendancehelper.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter mainPresenter;
    private RecyclerView rvAttend;
    private TextView tvState;
    private FrameLayout flAction;
    private ImageView ivCalendar;
    private AttendAdapter attendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        update();
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fl:
                mainPresenter.action();
                break;
            case R.id.calendar:
                mainPresenter.toCalendar();
                break;
            default:
                break;


        }
    }

    private void init() {
        mainPresenter = new MainPresenter(this, this);
        rvAttend = (RecyclerView) this.findViewById(R.id.rv);
        rvAttend.setLayoutManager(new LinearLayoutManager(this));
        tvState = (TextView) this.findViewById(R.id.action);
        flAction = (FrameLayout) this.findViewById(R.id.fl);
        flAction.setOnClickListener(this);
        ivCalendar=(ImageView)this.findViewById(R.id.calendar);
        ivCalendar.setOnClickListener(this);
        ivCalendar.setVisibility(View.GONE);

    }

    @Override
    public void update() {
        if (null == attendAdapter) {
            attendAdapter = new AttendAdapter(mainPresenter.getEntities(), this);
            rvAttend.setAdapter(attendAdapter);
        } else {
            mainPresenter.getEntities();
            attendAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void setState(String state, boolean isOn) {
        if (isOn) {
            tvState.setText(state);
            flAction.setEnabled(true);
        } else {
            tvState.setText(state);
            flAction.setEnabled(true);
        }
    }

    @Override
    public void showMsg(int StringId) {

    }

    @Override
    public void showDialog() {

    }
}
