package sierpingsky.Entity;

import javafx.scene.paint.Color;

public class MyRectangle {
    public double X,Y,width,height;//获得初始点，长宽
    public double x0,x1,x2,x3,x4,x5,x6,x7;
    public double y0,y1,y2,y3,y4,y5,y6,y7;
    private int level;
    private Color color;
    public double minwidth,minheight;
    public MyRectangle(int level, Color color, double X, double Y, double width, double height) {
        this.level = level;
        this.color = color;
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
        //对x0-x7,y0-y7初始化 得到坐标点
        this.x0 = this.X;
        this.y0 = this.Y;
        this.x1 = this.X + this.width/3;
        this.y1 = this.Y;
        this.x2 = this.X + this.width*2/3;
        this.y2 = this.Y;
        this.x3 = this.X;
        this.y3 = this.Y + this.height/3;
        this.x4 = this.X + this.width*2/3;
        this.y4 = this.Y + this.height / 3;
        this.x5 = this.X;
        this.y5 = this.Y + this.height*2/3;
        this.x6 = this.X + this.width / 3;
        this.y6 = this.Y + this.height *2/3;
        this.x7 = this.X +this.width *2/3;
        this.y7 = this.Y + this.height *2/3;
        //得到小三角形长宽
        this.minwidth = this.width / 3;
        this.minheight = this.height / 3;
    }
    public int getLevel() {
        return this.level;
    }

    public Color getColor(){
        return this.color;
    }
    //获取小四边形位置信息
    public double[] r1() {
        double point[] = {this.x0, this.y0, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r2() {
        double point[] = {this.x1, this.y1, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r3() {
        double point[] = {this.x2, this.y2, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r4() {
        double point[] = {this.x3, this.y3, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r5() {
        double point[] = {this.x4, this.y4, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r6() {
        double point[] = {this.x5, this.y5, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r7() {
        double point[] = {this.x6, this.y6, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double[] r8() {
        double point[] = {this.x7, this.y7, this.minwidth, this.minheight, this.level};
        return point;
    }

    public double getCenterX() {
        return this.X + this.minwidth;
    }

    public double getCenterY() {
        return this.Y + this.minheight;
    }
    public MyRectangle(int level, Color color, double point[]) {
        this.level = level;
        this.color = color;
        this.X = point[0];
        this.Y = point[1];
        this.width = point[2];
        this.height = point[3];

        this.x0 = this.X;
        this.y0 = this.Y;
        this.x1 = this.X + this.width/3;
        this.y1 = this.Y;
        this.x2 = this.X + this.width*2/3;
        this.y2 = this.Y;
        this.x3 = this.X;
        this.y3 = this.Y + this.height/3;
        this.x4 = this.X + this.width*2/3;
        this.y4 = this.Y + this.height / 3;
        this.x5 = this.X;
        this.y5 = this.Y + this.height*2/3;
        this.x6 = this.X + this.width / 3;
        this.y6 = this.Y + this.height *2/3;
        this.x7 = this.X + this.width *2/3;
        this.y7 = this.Y + this.height *2/3;
        this.minwidth = this.width / 3;
        this.minheight = this.height / 3;
    }

}