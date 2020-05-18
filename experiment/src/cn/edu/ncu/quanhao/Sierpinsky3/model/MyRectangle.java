package cn.edu.ncu.quanhao.Sierpinsky3.model;

import javafx.scene.paint.Color;

import java.util.Objects;

public class MyRectangle {
    private double X, Y, width, height, level;
    private double SubUpLeftX, SubUpCenterX, SubUpRightX, SubCenterLeftX, SubCenterRightX, SubDownLeftX, SubDownCenterX, SubDownRightX;
    double SubUpLeftY, SubUpCenterY, SubUpRightY, SubCenterLeftY, SubCenterRightY, SubDownLeftY, SubDownCenterY, SubDownRightY;
    double SubWidth, SubHeight;
    private Color[] colors;

    public MyRectangle(double X, double Y, double width, double height, double level, Color[] colors) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
        this.level = level;
        this.colors = colors;
        CalParameters();//计算子矩形的坐标参数
    }

    public MyRectangle(double[] data, double level, Color[] colors) {
        this.X = data[0];
        this.Y = data[1];
        this.width = data[2];
        this.height = data[3];
        this.level = level;
        this.colors = colors;
        CalParameters();//计算子矩形的坐标参数
    }

    public void CalParameters() {
        //
        this.SubUpLeftX = this.X;
        this.SubUpLeftY = this.Y;
        //
        this.SubUpCenterX = this.X + this.width / 3;
        this.SubUpCenterY = this.Y;
        //
        this.SubUpRightX = this.X + this.width / 3 * 2;
        this.SubUpRightY = this.Y;
        //
        this.SubCenterLeftX = this.X;
        this.SubCenterLeftY = this.Y + this.height / 3;
        //
        this.SubCenterRightX = this.X + this.width / 3 * 2;
        this.SubCenterRightY = this.Y + this.height / 3;
        //
        this.SubDownLeftX = this.X;
        this.SubDownLeftY = this.Y + this.height / 3 * 2;
        //
        this.SubDownCenterX = this.X + this.width / 3;
        this.SubDownCenterY = this.Y + this.height / 3 * 2;
        //
        this.SubDownRightX = this.X + this.width / 3 * 2;
        this.SubDownRightY = this.Y + this.height / 3 * 2;
        //
        this.SubWidth = this.width / 3;
        this.SubHeight = this.height / 3;
    }

    public double[] getUpRightREC() {
        double[] data = {this.SubUpRightX, this.SubUpRightY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getUpCenterREC() {
        double[] data = {this.SubUpCenterX, this.SubUpCenterY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getUpLeftREC() {
        double[] data = {this.SubUpLeftX, this.SubUpLeftY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getCenterRightREC() {
        double[] data = {this.SubCenterRightX, this.SubCenterLeftY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getCenterLeftREC() {
        double[] data = {this.SubCenterLeftX, this.SubCenterLeftY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getDownRightREC() {
        double[] data = {this.SubDownRightX, this.SubDownRightY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getDownCenterREC() {
        double[] data = {this.SubDownCenterX, this.SubDownCenterY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }

    public double[] getDownLeftREC() {
        double[] data = {this.SubDownLeftX, this.SubDownLeftY, this.SubWidth, this.SubHeight, this.level};
        return data;
    }
    public double[] getXPoints(){
        double[] data = {this.X,this.X+this.width,this.X+this.width,this.X};
        return data;
    }
    public double[] getYPoints(){
        double[] data = {this.Y,this.Y,this.Y+this.height,this.Y+this.height};
        return data;
    }
    public double[] getEmptyXPoints() {
        double[] data = {this.X+this.SubWidth,this.X+this.SubWidth*2,this.X+this.SubWidth*2,this.X+this.SubWidth};
        return data;
    }

    public double[] getEmptyYPoints() {
        double[] data = {this.Y+this.SubHeight,this.Y+this.SubHeight,this.Y+this.SubHeight*2,this.Y+this.SubHeight*2};
        return data;
    }

    public double getLevel() {
        return this.level;
    }

    public Color[] getColor() {
        return this.colors;
    }
    public void setColor(Color[] colors) {
        this.colors = colors;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyRectangle that = (MyRectangle) o;
        return Double.compare(that.X, X) == 0 &&
                Double.compare(that.Y, Y) == 0 &&
                Double.compare(that.width, width) == 0 &&
                Double.compare(that.height, height) == 0 &&
                Double.compare(that.level, level) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y, width, height, level);
    }
}
