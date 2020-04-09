package cn.edu.ncu.quanhao.SierpinskiRectangle;

public class MyRectangle {
    double X, Y, width, height;
    double SubUpLeftX, SubUpCenterX, SubUpRightX, SubCenterLeftX, SubCenterRightX, SubDownLeftX, SubDownCenterX, SubDownRightX;
    double SubUpLeftY, SubUpCenterY, SubUpRightY, SubCenterLeftY, SubCenterRightY, SubDownLeftY, SubDownCenterY, SubDownRightY;
    double SubWidth,SubHeight;
    MyRectangle(double X, double Y, double width, double height) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
        CalParameters();//计算子矩形的坐标参数
    }

    MyRectangle(double[] points, double width, double height) {
        this.X = points[0];
        this.Y = points[1];
        this.width = width;
        this.height = height;
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
        this.SubWidth = this.width/3;
        this.SubHeight = this.height/3;
    }
}
