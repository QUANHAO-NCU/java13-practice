package cn.edu.ncu.quanhao.Sierpinski;

import javafx.scene.paint.Color;

/**
 * 抽象模型 M
 * 记录三角形的坐标，层次
 */
public class MyTriangle {
    double xTop, xRight, xLeft, yTop, yRight, yLeft;
    double[] x = {this.xTop,this.xRight, this.xLeft};//三角形的X坐标
    double[] y = {this.yTop, this.yRight, this.yLeft};//三角形的Y坐标
    private Color color;
    private int level;

    public double[] getX() {

        return this.x;
    }

    public double[] getY() {
        return this.y;
    }

    public Color getColor() {
        return this.color;
    }

    public int getLevel() {
        return this.level;
    }

    public double getCenterXRight() {
        //返回该三角形右边的中点左边坐标
        return (this.xRight + this.xTop) / 2;
    }

    public double getCenterXLeft() {
        //返回该三角形右边的中点左边坐标
        return (this.xLeft + this.xTop) / 2;
    }

    public double getCenterXTop() {
        //返回该三角形中点坐标
        return this.xTop;
    }

    public double getCenterYRight() {
        //返回该三角形右边中点的坐标
        return (this.yRight + this.yTop) / 2;
    }

    public double getCenterYLeft() {
        //返回该三角形左边中点的坐标
        return (this.yLeft + this.yTop) / 2;
    }

    public double getCenterYDown() {
        //返回该三角形下面的坐标
        return (this.yLeft + this.yRight) / 2;
    }

    MyTriangle(Color color, int level, double[] x, double[] y) {
        this.color = color;
        this.level = level;
        this.x = x;
        this.y = y;
    }

    MyTriangle(Color color, int level, double xTop, double xLeft, double xRight,
               double yTop, double yLeft, double yRight) {
        this.color = color;
        this.level = level;
        this.xTop = xTop;
        this.xLeft = xLeft;
        this.xRight = xRight;
        this.yTop = yTop;
        this.yLeft = yLeft;
        this.yRight = yRight;
    }

    public double[] getCenterX() {
        double[] x = {
                (this.xLeft + this.xTop) / 2,
                (this.xTop),
                (this.xTop + this.xRight) / 2
        };
        return x;
    }

    public double[] getCenterY() {
        double[] y = {
                (this.yTop + this.yLeft) / 2,
                (this.yLeft + this.yRight) / 2,
                (this.yTop + this.yRight) / 2
        };
        return y;
    }
}
