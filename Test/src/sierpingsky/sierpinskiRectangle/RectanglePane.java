package sierpingsky.sierpinskiRectangle;

import sierpingsky.Entity.MyRectangle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class RectanglePane extends Pane {
    public Canvas canvas;
    public GraphicsContext gc;
    private MyRectangle myRectangle;
    private DrawRectangle drawRectangle = new DrawRectangle();
    private MyRectangle getMyRectangle;
    public int level;
    private int size = 1;


    RectanglePane(int level) {
        this.level = level;
        canvas = new Canvas(800,800);
        this.gc = canvas.getGraphicsContext2D();
        generate(level);
        getChildren().add(canvas);
    }

    public void generate(int level) {
        MyStackR stack=new MyStackR((int)Math.pow(3.0,this.level)+1);
        MyRectangle myRectangle = new MyRectangle(0, Color.WHITE, 50, 50,600,600);
        stack.push(myRectangle);
        int l = 0;
        do {
            myRectangle = stack.pop();
            l = myRectangle.getLevel();
            l++;
            MyRectangle myRectangle1 = new MyRectangle(l, Color.BLACK, myRectangle.r1());
            MyRectangle myRectangle2 = new MyRectangle(l, Color.BLACK, myRectangle.r2());
            MyRectangle myRectangle3 = new MyRectangle(l, Color.BLACK, myRectangle.r3());
            MyRectangle myRectangle4 = new MyRectangle(l, Color.BLACK, myRectangle.r4());
            MyRectangle myRectangle5 = new MyRectangle(l, Color.BLACK, myRectangle.r5());
            MyRectangle myRectangle6 = new MyRectangle(l, Color.BLACK, myRectangle.r6());
            MyRectangle myRectangle7 = new MyRectangle(l, Color.BLACK, myRectangle.r7());
            MyRectangle myRectangle8 = new MyRectangle(l, Color.BLACK, myRectangle.r8());
            drawRectangle.DrawShape(gc, myRectangle);
            drawRectangle.DrawShape(gc, myRectangle1);
            drawRectangle.DrawShape(gc, myRectangle2);
            drawRectangle.DrawShape(gc, myRectangle3);
            drawRectangle.DrawShape(gc, myRectangle4);
            drawRectangle.DrawShape(gc, myRectangle5);
            drawRectangle.DrawShape(gc, myRectangle6);
            drawRectangle.DrawShape(gc, myRectangle7);
            drawRectangle.DrawShape(gc, myRectangle8);
            drawRectangle.DrawCenter(gc, myRectangle);
            if (l < this.level) {
                stack.push(myRectangle1);
                stack.push(myRectangle2);
                stack.push(myRectangle3);
                stack.push(myRectangle4);
                stack.push(myRectangle5);
                stack.push(myRectangle6);
                stack.push(myRectangle7);
                stack.push(myRectangle8);
            }

        } while (!stack.isEmpty());
    }
}
