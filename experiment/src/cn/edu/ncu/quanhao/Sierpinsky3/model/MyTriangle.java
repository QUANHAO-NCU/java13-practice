package cn.edu.ncu.quanhao.Sierpinsky3.model;

import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * 抽象模型 M
 * 记录三角形的坐标，层次
 */
public class MyTriangle {
    public double xTop, xRight, xLeft, yTop, yRight, yLeft;
    private Color[] colors;
    private int level;

    public MyTriangle(Color[] colors, int level, double xTop, double xLeft, double xRight,
                      double yTop, double yLeft, double yRight) {
        this.colors = colors;
        this.level = level;
        this.xTop = xTop;
        this.xLeft = xLeft;
        this.xRight = xRight;
        this.yTop = yTop;
        this.yLeft = yLeft;
        this.yRight = yRight;
    }

    public double[] getXPoints() {
        double[] x = {this.xTop, this.xRight, this.xLeft};
        return x;
    }

    public double[] getYPoints() {
        double[] y = {this.yTop, this.yRight, this.yLeft};
        return y;
    }

    public Color[] getColor() {

        return this.colors;
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

    public void setColor(Color[] colors) {
        this.colors = colors;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return Double.compare(that.xTop, xTop) == 0 &&
                Double.compare(that.xRight, xRight) == 0 &&
                Double.compare(that.xLeft, xLeft) == 0 &&
                Double.compare(that.yTop, yTop) == 0 &&
                Double.compare(that.yRight, yRight) == 0 &&
                Double.compare(that.yLeft, yLeft) == 0 &&
                level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xTop, xRight, xLeft, yTop, yRight, yLeft, level);
    }
}
