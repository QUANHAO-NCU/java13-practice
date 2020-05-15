package cn.edu.ncu.quanhao.CaesarCode.SierpinskiRectangle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 视图模型 V
 * 根据三角形信息绘制矩形
 */
public class DrawRectangle {
    public void drawRectangle(GraphicsContext gc, MyRectangle Rectangle) {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(Rectangle.X, Rectangle.Y, Rectangle.width, Rectangle.height);//描边
        gc.setFill(Rectangle.color);
        gc.fillRect(Rectangle.X, Rectangle.Y, Rectangle.width, Rectangle.height);
        gc.setStroke(Color.BLACK);
    }
    public void drawEmpty(GraphicsContext gc, MyRectangle Rectangle){
        gc.strokeRect(Rectangle.getEmptyRX(), Rectangle.getEmptyRY(), Rectangle.SubWidth, Rectangle.SubHeight);
        gc.setFill(Color.WHITE);
        gc.fillRect(Rectangle.getEmptyRX(), Rectangle.getEmptyRY(), Rectangle.SubWidth, Rectangle.SubHeight);
    }
}
