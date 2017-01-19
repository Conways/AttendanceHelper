package com.conways.attendancehelper.wegit.toothView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.conways.attendancehelper.R;
import com.conways.attendancehelper.utils.DensityUtil;


/**
 * Created by Conways on 2017/1/18.
 */

public class SawtoothView extends View{

    //三角形
    public static final int TYPE_TRIANGLE=0;
    //圆形
    public static final int TYPE_CIRCLE=1;
    //矩形
    public static final int TYPE_RECTANGULAR=2;
    //梯形
    public static final int TYPE_TRAPEZOIDAL=3;


    //朝上
    public static final int LOCATION_TOP=4;
    //下
    public static final int LOCATION_BOTTOM=5;


    private int location;
    private int toothType=TYPE_TRIANGLE;
    private int color;

    private int unitLenth;
    private int offSet;


    private int mWith;
    private int mHeight;

    private Path path;
    private Paint paint;




    public SawtoothView(Context context) {
        super(context);
        init();
    }

    public SawtoothView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
        init();
    }

    public SawtoothView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
        init();
    }

    private void initAttrs(Context context, AttributeSet attrs){
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.tooth_view, 0, 0);
        location=t.getInt(R.styleable.tooth_view_location,LOCATION_BOTTOM);
        toothType=t.getInt(R.styleable.tooth_view_type,TYPE_CIRCLE);
        color=t.getColor(R.styleable.tooth_view_tooth_color,0xff000000);
    }

    private void init(){
        unitLenth=DensityUtil.dip2px(getContext(),8);
        offSet=DensityUtil.dip2px(getContext(),8);
        path=new Path();
        paint=new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureMode=MeasureSpec.getMode(heightMeasureSpec);
        if (widthMeasureMode==MeasureSpec.EXACTLY) {
            mWith=MeasureSpec.getSize(widthMeasureSpec);
        }else{
            mWith= DensityUtil.dip2px(getContext(),480);
        }
        if (heightMeasureMode==MeasureSpec.AT_MOST) {
            mHeight=MeasureSpec.getSize(heightMeasureSpec);
        }else{
            mHeight=DensityUtil.dip2px(getContext(),100);
        }
        setMeasuredDimension(mWith, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (toothType) {
            case TYPE_TRIANGLE:
                if (location==LOCATION_TOP){
                    createToptriangle();
                }else{
                    createBottomtriangle();
                }
                break;
            case TYPE_CIRCLE:
                break;
            case TYPE_RECTANGULAR:
                break;
            case TYPE_TRAPEZOIDAL:
                break;

            default:
                break;
        }

        canvas.drawPath(path,paint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }



    private void createToptriangle(){
        path.reset();
        path.moveTo(0,mHeight);
        path.lineTo(offSet,mHeight);
        int tempLenth=2*offSet;
        while (tempLenth+unitLenth<=mWith){
            path.lineTo(tempLenth-offSet+unitLenth/2,0);
            path.lineTo(tempLenth-offSet+unitLenth,mHeight);
            tempLenth+=unitLenth;
        }
        path.lineTo(mWith,mHeight);
        path.close();
    }

    private void createBottomtriangle(){
        path.reset();
        path.moveTo(0,0);
        path.lineTo(offSet,0);
        int tempLenth=2*offSet;
        while (tempLenth+unitLenth<=mWith){
            path.lineTo(tempLenth-offSet+unitLenth/2,mHeight);
            path.lineTo(tempLenth-offSet+unitLenth,0);
            tempLenth+=unitLenth;
        }
        path.lineTo(mWith,0);
        path.close();
    }



    private Path createTopCircle(int lenth,int unitLenth){
        Path  path=new Path();
        return path;
    }
    private Path createTopRectangular(int lenth,int unitLenth){
        Path  path=new Path();
        return path;
    }
    private Path createTopTrapezoidal(int lenth, int unitLenth){
        Path  path=new Path();
        return path;
    }

    private Path createBottomCircle(int lenth,int unitLenth){
        Path  path=new Path();
        return path;
    }
    private Path createBottomRectangular(int lenth,int unitLenth){
        Path  path=new Path();
        return path;
    }
    private Path createBottomTrapezoidal(int lenth, int unitLenth){
        Path  path=new Path();
        return path;
    }

}
