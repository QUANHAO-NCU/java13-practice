package cn.edu.ncu.quanhao.SierpinskiRectangle;

import cn.edu.ncu.quanhao.Sierpinski.DrawTriangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Stack;

/**
 * 控制模型C
 * 塞尔平斯基矩形最终在这里控制绘画
 */
public class DrawingControl extends Pane {
    public Canvas canvas;
    public GraphicsContext gc;
    private MyRectangle myRectangle;
    private DrawRectangle dr = new DrawRectangle();
    public double level;
    private double MaxLen;

    DrawingControl(double level, double MaxLen) {
        this.level = level;
        this.MaxLen = MaxLen;
        canvas = new Canvas(MaxLen + 50 * 2, MaxLen + 50 * 2);
        this.gc = canvas.getGraphicsContext2D();
        generate(level, MaxLen);
        getChildren().add(canvas);
    }

    private void generate(double level, double maxLen) {
        System.out.println("Start Drawing!");
        Stack<MyRectangle> stack = new Stack<>();
        myRectangle = new MyRectangle(50, 50, this.MaxLen, this.MaxLen, 0, Color.WHITE);
        stack.push(myRectangle);
        double l = 0;
        do {
            myRectangle = stack.pop();
            l = myRectangle.getLevel();
            l++;
            MyRectangle RUL = new MyRectangle(myRectangle.getUpLeftREC(), l,Color.RED);
            MyRectangle RUC = new MyRectangle(myRectangle.getUpCenterREC(), l,Color.ORANGE);
            MyRectangle RUR = new MyRectangle(myRectangle.getUpRightREC(), l,Color.YELLOW);
            MyRectangle RCL = new MyRectangle(myRectangle.getCenterLeftREC(), l,Color.GREEN);
            MyRectangle RCR = new MyRectangle(myRectangle.getCenterRightREC(),l, Color.BLUE);
            MyRectangle RDL = new MyRectangle(myRectangle.getDownLeftREC(), l,Color.BLUE);
            MyRectangle RDC = new MyRectangle(myRectangle.getDownCenterREC(), l,Color.PURPLE);
            MyRectangle RDR = new MyRectangle(myRectangle.getDownRightREC(), l,Color.GOLD);

            dr.drawRectangle(this.gc, myRectangle);
            dr.drawRectangle(this.gc, RUL);
            dr.drawRectangle(this.gc, RUC);
            dr.drawRectangle(this.gc, RUR);
            dr.drawRectangle(this.gc, RCL);
            dr.drawRectangle(this.gc, RCR);
            dr.drawRectangle(this.gc, RDL);
            dr.drawRectangle(this.gc, RDC);
            dr.drawRectangle(this.gc, RDR);
            dr.drawEmpty(this.gc,myRectangle);
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
        System.out.println("Drawing done!");
    }
}
