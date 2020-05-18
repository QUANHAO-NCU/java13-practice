package sierpingsky.sierpinskiRectangle;

import sierpingsky.Entity.MyRectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawRectangle {
    public void DrawShape(GraphicsContext gc, MyRectangle Rectangle) {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(Rectangle.X, Rectangle.Y, Rectangle.width, Rectangle.height);
        gc.setFill(Rectangle.getColor());
        gc.fillRect(Rectangle.X, Rectangle.Y, Rectangle.width, Rectangle.height);
        gc.setStroke(Color.BLACK);
    }
    public void DrawCenter(GraphicsContext gc, MyRectangle Rectangle){
        gc.strokeRect(Rectangle.getCenterX(), Rectangle.getCenterY(), Rectangle.minwidth, Rectangle.minheight);
        gc.setFill(Color.WHITE);
        gc.fillRect(Rectangle.getCenterX(), Rectangle.getCenterY(), Rectangle.minwidth, Rectangle.minheight);
    }
}
