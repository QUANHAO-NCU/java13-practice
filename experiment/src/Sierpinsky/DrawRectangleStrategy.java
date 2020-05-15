package Sierpinsky;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Stack;


public class DrawRectangleStrategy extends Pane implements Strategy{
    public Canvas canvas;
    public GraphicsContext gc;
    private MyRectangle myRectangle;
    public double level;
    private double MaxLen;

    @Override
    public void initial(int level,Color[] colors) {
        this.level = level;
        this.MaxLen = 600;
        canvas = new Canvas(800,600);
        this.gc = canvas.getGraphicsContext2D();
        generate(level, MaxLen,colors);
        getChildren().add(canvas);
    }

    @Override
    public Pane returnPane() {
        return this;
    }

    @Override
    public void generate(int level, double maxLen,Color[] colors) {
        Stack<MyRectangle> stack = new Stack<>();
        myRectangle = new MyRectangle(50, 50, maxLen, maxLen, 0, Color.WHITE);
        stack.push(myRectangle);
        double l = 0;
        do {
            myRectangle = stack.pop();
            l = myRectangle.getLevel();
            l++;
            MyRectangle RUL = new MyRectangle(myRectangle.getUpLeftREC(), l,colors[0]);
            MyRectangle RUC = new MyRectangle(myRectangle.getUpCenterREC(), l,colors[1]);
            MyRectangle RUR = new MyRectangle(myRectangle.getUpRightREC(), l,colors[2]);
            MyRectangle RCL = new MyRectangle(myRectangle.getCenterLeftREC(), l,colors[3]);
            MyRectangle RCR = new MyRectangle(myRectangle.getCenterRightREC(),l, colors[4]);
            MyRectangle RDL = new MyRectangle(myRectangle.getDownLeftREC(), l,colors[5]);
            MyRectangle RDC = new MyRectangle(myRectangle.getDownCenterREC(), l,colors[6]);
            MyRectangle RDR = new MyRectangle(myRectangle.getDownRightREC(), l,colors[7]);

            drawShape(this.gc, myRectangle.getXPoints(),myRectangle.getYPoints(),myRectangle.getColor());
            drawShape(this.gc, RUL.getXPoints(),RUL.getYPoints(),RUL.getColor());
            drawShape(this.gc, RUC.getXPoints(),RUC.getYPoints(),RUC.getColor());
            drawShape(this.gc, RUR.getXPoints(),RUR.getYPoints(),RUR.getColor());
            drawShape(this.gc, RCL.getXPoints(),RCL.getYPoints(),RCL.getColor());
            drawShape(this.gc, RCR.getXPoints(),RCR.getYPoints(),RCR.getColor());
            drawShape(this.gc, RDL.getXPoints(),RDL.getYPoints(),RDL.getColor());
            drawShape(this.gc, RDC.getXPoints(),RDC.getYPoints(),RDC.getColor());
            drawShape(this.gc, RDR.getXPoints(),RDR.getYPoints(),RDR.getColor());
            drawEmpty(this.gc,myRectangle.getEmptyXPoints(),myRectangle.getEmptyYPoints(),colors[8]);
            if (l < this.level) {
                stack.push(RUL);
                stack.push(RUC);
                stack.push(RUR);
                stack.push(RCL);
                stack.push(RCR);
                stack.push(RDL);
                stack.push(RDC);
                stack.push(RDR);
            }
        } while (!stack.isEmpty());

    }


}
