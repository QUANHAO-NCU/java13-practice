package cn.edu.ncu.quanhao.Final.Third;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square implements Shape{
    private double len;
    @Override
    public double area() {
        return len*len;
    }

    @Override
    public double perimeter() {
        return 4*len;
    }

    public Square(double len) {
        this.len = len;
    }

    @Override
    public void drawShape(Canvas canvas) {
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.setWidth(500);
        canvas.setHeight(500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[]{(500-len)/2.0,(500-len)/2.0+len,(500-len)/2.0+len,(500-len)/2.0},new double[]{(500-len)/2,(500-len)/2,(500-len)/2+len,(500-len)/2+len},4);
        gc.fillText("周长为："+perimeter()+"\n面积为："+area(),(500-len)/2.0,(500-len)/2+len+20,500);
    }
}
