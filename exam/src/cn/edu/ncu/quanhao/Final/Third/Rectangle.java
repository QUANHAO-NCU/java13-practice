package cn.edu.ncu.quanhao.Final.Third;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Shape{
    private double width;
    private double height;
    @Override
    public double area() {
        return width*height;
    }

    @Override
    public double perimeter() {
        return 2*(width+height);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape(Canvas canvas) {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.setWidth(500);
        canvas.setHeight(500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillPolygon(new double[]{(500-width)/2.0,(500-width)/2.0+width,(500-width)/2.0+width,(500-width)/2.0},new double[]{(500-height)/2.0,(500-height)/2.0,(500-height)/2.0+height,(500-height)/2.0+height},4);
        gc.fillText("周长为："+perimeter()+"\n面积为："+area(),(500-width)/2.0,(500-height)/2.0+height+20,500);
    }
}
