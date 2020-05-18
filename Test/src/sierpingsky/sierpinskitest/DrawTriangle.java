package sierpingsky.sierpinskitest;

import sierpingsky.Entity.MyTriangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class DrawTriangle {
    public void drawShape(GraphicsContext gc, MyTriangle triangle){
        gc.setStroke(Color.WHITE);
        gc.strokePolygon(new double[]{
                        triangle.getX()[0],
                        triangle.getX()[1],
                        triangle.getX()[2]},
                new double[]{
                        triangle.getY()[0],
                        triangle.getY()[1],
                        triangle.getY()[2]
                },3);
        gc.setFill(triangle.getColor());
        gc.fillPolygon(
                new double[]{
                        triangle.getX()[0],
                        triangle.getX()[1],
                        triangle.getX()[2]},
                new double[]{
                        triangle.getY()[0],
                        triangle.getY()[1],
                        triangle.getY()[2]
                },3);
    }
    public void drawCenters(GraphicsContext gc, MyTriangle triangle){
        gc.setStroke(Color.WHITE);
        gc.strokePolygon(new double[]{
                        triangle.center1[0],
                        triangle.center2[0],
                        triangle.center3[0]},
                new double[]{
                        triangle.center1[1],
                        triangle.center2[1],
                        triangle.center3[1]
                },3);
        gc.setFill(Color.BLACK);
        gc.fillPolygon(new double[]{
                        triangle.center1[0],
                        triangle.center2[0],
                        triangle.center3[0]},
                new double[]{
                        triangle.center1[1],
                        triangle.center2[1],
                        triangle.center3[1]
                },3);
    }
}
