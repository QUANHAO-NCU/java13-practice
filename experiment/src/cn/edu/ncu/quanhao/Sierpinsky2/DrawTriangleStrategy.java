package cn.edu.ncu.quanhao.Sierpinsky2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Stack;


public class DrawTriangleStrategy extends Pane implements Strategy {
    private Canvas canvas;
    private int level;
    private double maxSideLen;//这里决定塞尔平斯基三角形的最大边长
    public GraphicsContext gc;
    public MyTriangle myTriangle;
    private double margin = 10.0;

    @Override
    public void initial(int level,Color[] colors) {
        this.level = level;
        this.maxSideLen = 600;
        canvas = new Canvas(800,600);
        this.gc = canvas.getGraphicsContext2D();
        generate(level, maxSideLen,colors);
        getChildren().add(canvas);
    }

    @Override
    public Pane returnPane() {
        return this;
    }

    @Override
    public void generate(int level, double maxSideLen,Color[] colors) {
        Stack<MyTriangle> stack = new Stack<>();
        myTriangle = new MyTriangle(Color.WHITE, 0,
                margin + maxSideLen / 2,
                margin,
                margin + maxSideLen,
                margin,
                margin + (maxSideLen / 2) * Math.sqrt(2.0),
                margin + (maxSideLen / 2) * Math.sqrt(2.0));
        stack.push(myTriangle);

        int l = 0;
        do {
            myTriangle = stack.pop();
            l = myTriangle.getLevel();
            l++;
            MyTriangle tTop = new MyTriangle(colors[0], l,
                    myTriangle.xTop, myTriangle.getCenterXLeft(), myTriangle.getCenterXRight(),
                    myTriangle.yTop, myTriangle.getCenterYLeft(), myTriangle.getCenterYRight());
            MyTriangle tLeft = new MyTriangle(colors[1], l,
                    myTriangle.getCenterXLeft(), myTriangle.xLeft, myTriangle.getCenterXTop(),
                    myTriangle.getCenterYLeft(), myTriangle.yLeft, myTriangle.getCenterYDown());
            MyTriangle tRight = new MyTriangle(colors[2], l,
                    myTriangle.getCenterXRight(), myTriangle.xTop, myTriangle.xRight,
                    myTriangle.getCenterYRight(), myTriangle.getCenterYDown(), myTriangle.getCenterYDown()
            );
            drawShape(this.gc, myTriangle.getXPoints(),myTriangle.getYPoints(),myTriangle.getColor());
            drawShape(this.gc, tTop.getXPoints(),tTop.getYPoints(),tTop.getColor());
            drawShape(this.gc, tLeft.getXPoints(),tLeft.getYPoints(),tLeft.getColor());
            drawShape(this.gc, tRight.getXPoints(),tRight.getYPoints(),tRight.getColor());
            drawEmpty(this.gc, myTriangle.getCenterX(),myTriangle.getCenterY(),colors[3]);
            if (l < this.level) {
                stack.push(tTop);
                stack.push(tLeft);
                stack.push(tRight);
            }
        } while (!stack.isEmpty());
    }


}

