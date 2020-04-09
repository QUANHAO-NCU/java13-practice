package cn.edu.ncu.quanhao.SierpinskiRectangle;

import javafx.scene.paint.Color;

public class MyRectangle {
    double X, Y, width, height, level;
    double SubUpLeftX, SubUpCenterX, SubUpRightX, SubCenterLeftX, SubCenterRightX, SubDownLeftX, SubDownCenterX, SubDownRightX;
    double SubUpLeftY, SubUpCenterY, SubUpRightY, SubCenterLeftY, SubCenterRightY, SubDownLeftY, SubDownCenterY, SubDownRightY;
    double SubWidth, SubHeight;
    Color color;

    MyRectangle(double X, double Y, double width, double height, double level, Color color) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
        this.level = level;
        this.color = color;
        CalParameters();//计算子矩形的坐标参数
    }

    MyRectangle(double[] data, double level,Color color) {
        this.X = data[0];
        this.Y = data[1];
        this.width = data[2];
        this.height = data[3];
        this.level = level;
        this.color = color;
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

    public double getEmptyRX() {
        return this.X + this.SubWidth;
    }

    public double getEmptyRY() {
        return this.Y + this.SubHeight;
    }

    public double getLevel() {
        return this.level;
    }

}
