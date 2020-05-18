package sierpingsky.Entity;

import javafx.scene.paint.Color;

public class MyTriangle {
    public double x0, x1, x2;
    public double y0, y1, y2;
    private int level;
    private Color color;
    public double[] x={x0,x1,x2};
    public double[] y={y0,y1,y2};
    public Color getColor(){return this.color;}
    public int getLevel(){return this.level;}
    public double[] getX(){return new double[]{x0,x1,x2};}
    public double[] getY(){return new double[]{y0,y1,y2};}


    public double getCenterX0() {
        return x0;
    }

    public double getCenterX1() {
        return (x0+x1)/2;
    }

    public double getCenterX2() {
        return (x0+x2)/2;
    }

    public double getCenterY0() {
        return (y1+y2)/2;
    }
    public double getCenterY1() {
        return (y0+y1)/2;
    }

    public double getCenterY2() {
        return (y0+y2) / 2;
    }


    MyTriangle(Color color, int level, double[] x, double[] y) {
        this.color = color;
        this.level = level;
        this.x = x;
        this.y = y;
        //对Center 初始化
        center3 = getCenter(this.x0, this.y0, this.x2, this.y2);
        center2 = getCenter(this.x2, this.y2, this.x1, this.y1);
        center1 = getCenter(this.x0, this.y0, this.x1, this.y1);
    }

    public MyTriangle(int level, Color color, double x0, double x1, double x2,
                      double y0, double y1, double y2) {
        this.level = level;
        this.color = color;
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y0 = y0;
        this.y1 = y1;
        this.y2 = y2;
        //对Center 初始化
        center3 = getCenter(this.x0, this.y0, this.x2, this.y2);
        center2 = getCenter(this.x2, this.y2, this.x1, this.y1);
        center1 = getCenter(this.x0, this.y0, this.x1, this.y1);
    }
    public double[] getCenter(double x1,double y1,double x2,double y2) {
        return new double[]{(x1+x2)/2,(y1+y2)/2};
    }

    public double[]center1=getCenter(x[0],y[0],x[1],y[1]);

    public double[]center2=getCenter(x[2],y[2],x[1],y[1]);

    public double[]center3=getCenter(x[0],y[0],x[2],y[2]);

    public double[] getCenterX() {
        double[] x = {
                (x1+x2)/2,
                (x0+x1)/2,
                (x0+x2)/2
        };
        return x;
    }

    public double[] getCenterY() {
        double[] y = {
                (y1+y2)/2,
                (y0+y1)/2,
                (y0+y2)/2
        };
        return y;
    }

}
