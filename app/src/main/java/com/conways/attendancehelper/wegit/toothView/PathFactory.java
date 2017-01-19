package com.conways.attendancehelper.wegit.toothView;

import android.graphics.Path;

/**
 * Created by Conways on 2017/1/19.
 */

public class PathFactory {
    
    private int offset;
    private int startX;
    private int startY;

    public PathFactory() {
    }

    public Path getBottomPathByType(int type, int lenth,int unitLenth,int offset){
        Path path=null;
        switch (type) {
            case SawtoothView.TYPE_CIRCLE:
                path=createBottomCircle(lenth,unitLenth);
                break;
            case SawtoothView.TYPE_TRIANGLE:
                path=createBottomtriangle(lenth,unitLenth);
                break;
            case SawtoothView.TYPE_RECTANGULAR:
                path=createBottomRectangular(lenth,unitLenth);
                break;
            case SawtoothView.TYPE_TRAPEZOIDAL:
                path= createBottomTrapezoidal(lenth,unitLenth);
                break;
            default:
                break;

        }
        return path;
    }

    public Path getTopPathByType(int type,int lenth,int unitLenth,int offset){

        Path path=null;
        switch (type) {
            case SawtoothView.TYPE_CIRCLE:
                path=createTopCircle(lenth,unitLenth);
                break;
            case SawtoothView.TYPE_TRIANGLE:
                path=createToptriangle(lenth,unitLenth);
                break;
            case SawtoothView.TYPE_RECTANGULAR:
                path=createTopRectangular(lenth,unitLenth);
                break;
            case SawtoothView.TYPE_TRAPEZOIDAL:
                path= createTopTrapezoidal(lenth,unitLenth);
                break;

            default:
                break;
        }
        return path;
    }

    private Path createToptriangle(int lenth,int unitLenth){
        Path  path=new Path();
        path.moveTo(startX,startY);

        return path;
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
    private Path createBottomtriangle(int lenth,int unitLenth){
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
