package cn.edu.ncu.quanhao.Final.Third;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle implements Shape{
    /**
     * 默认等边三角形
     * */
    private double len;
    @Override
    public double area() {
        return len*Math.sqrt(3.0)/4.0*len;
    }

    @Override
    public double perimeter() {
        return 3*len;
    }

    public Triangle(double len) {
        this.len = len;
    }

    @Override
    public void drawShape(Canvas canvas) {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.setWidth(500);
        canvas.setHeight(500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillPolygon(new double[]{300,300-len/2,300+len/2},new double[]{0,len*Math.sqrt(3.0)/2.0,len*Math.sqrt(3.0)/2.0},3);
        gc.fillText("周长为："+perimeter()+"\n面积为："+area(),300,len*Math.sqrt(3.0)/2.0+20,500);
    }
}
