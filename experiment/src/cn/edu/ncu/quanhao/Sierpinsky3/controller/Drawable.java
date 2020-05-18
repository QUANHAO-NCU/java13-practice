package cn.edu.ncu.quanhao.Sierpinsky3.controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Drawable {
    /**
     * 抽象接口实现多态性
     * */
    //void generate(int level, double maxLen,Color[] colors);

    default void drawShape(GraphicsContext gc, double[] xPoints, double[] yPoints, Color color) {
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(xPoints, yPoints, xPoints.length);//描边
        gc.setFill(color);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    default void drawEmpty(GraphicsContext gc, double[] xPoints, double[] yPoints, Color color) {
        gc.setStroke(Color.WHITE);
        gc.strokePolygon(xPoints, yPoints, xPoints.length);//描边
        gc.setFill(color);
        gc.fillPolygon(xPoints, yPoints, xPoints.length);
        gc.setStroke(Color.WHITE);
    }

}
