package cn.edu.ncu.quanhao.CaesarCode.Sierpinski;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * 视图模型 V
 * 根据三角形信息绘制三角形
 */

public class DrawTriangle {
    public void fillTriangle(GraphicsContext gc, MyTriangle triangle) {
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(new double[]{
                        triangle.xTop,
                        triangle.xLeft,
                        triangle.xRight},
                new double[]{
                        triangle.yTop,
                        triangle.yLeft,
                        triangle.yRight
                },3);
        //根据传入的三角形信息绘制指定的三角形
        gc.setFill(triangle.getColor());//获取填充该三角形的颜色
        gc.fillPolygon(
                new double[]{
                        triangle.xTop,
                        triangle.xLeft,
                        triangle.xRight},
                new double[]{
                        triangle.yTop,
                        triangle.yLeft,
                        triangle.yRight
                },3);
    }
    public void drawEmptyCenter(GraphicsContext gc,MyTriangle triangle){
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(new double[]{
                        triangle.getCenterXRight(),
                        triangle.getCenterXLeft(),
                        triangle.xTop},
                new double[]{
                        triangle.getCenterYRight(),
                        triangle.getCenterYLeft(),
                        triangle.getCenterYDown()
                },3);
        gc.setFill(Color.WHITE);
        gc.fillPolygon(new double[]{
                        triangle.getCenterXRight(),
                        triangle.getCenterXLeft(),
                        triangle.xTop},
                new double[]{
                        triangle.getCenterYRight(),
                        triangle.getCenterYLeft(),
                        triangle.getCenterYDown()
                },3);
    }

}
