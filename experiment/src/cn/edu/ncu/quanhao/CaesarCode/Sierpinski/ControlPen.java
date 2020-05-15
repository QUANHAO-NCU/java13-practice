package cn.edu.ncu.quanhao.CaesarCode.Sierpinski;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Stack;

/**
 * 控制模型C
 * 塞尔平斯基三角形最终在这里控制绘画
 */
public class ControlPen extends Pane {
    public Canvas canvas;
    private int level;//这里决定塞尔屏斯基三角形的最终层次
    private double maxSideLen;//这里决定塞尔平斯基三角形的最大边长
    public GraphicsContext gc;
    public DrawTriangle dt = new DrawTriangle();
    public MyTriangle myTriangle;
    private double margin = 10.0;

    ControlPen(int level, double maxSideLen) {
        this.level = level;
        this.maxSideLen = maxSideLen;
        canvas = new Canvas(maxSideLen + 150 + margin * 2, maxSideLen + 150 + margin * 2);
        this.gc = canvas.getGraphicsContext2D();
        generate(level, maxSideLen);
        getChildren().add(canvas);
    }

    public void generate(int level, double maxSideLen) {
        Stack<MyTriangle> stack = new Stack<>();
        myTriangle = new MyTriangle(Color.WHITE, 0,
                margin + maxSideLen / 2,
                margin,
                margin + maxSideLen,
                margin,
                margin + (maxSideLen / 2) * Math.sqrt(2.0),
                margin + (maxSideLen / 2) * Math.sqrt(2.0));
        stack.push(myTriangle);
//        dt.fillTriangle(this.gc,myTriangle);
//        dt.drawEmptyCenter(this.gc, myTriangle);

        int l = 0;
        do {
            myTriangle = stack.pop();
            l = myTriangle.getLevel();
            l++;
            MyTriangle tTop = new MyTriangle(Color.ORANGE, l,
                    myTriangle.xTop, myTriangle.getCenterXLeft(), myTriangle.getCenterXRight(),
                    myTriangle.yTop, myTriangle.getCenterYLeft(), myTriangle.getCenterYRight());
            MyTriangle tLeft = new MyTriangle(Color.BLUE, l,
                    myTriangle.getCenterXLeft(), myTriangle.xLeft, myTriangle.getCenterXTop(),
                    myTriangle.getCenterYLeft(), myTriangle.yLeft, myTriangle.getCenterYDown());
            MyTriangle tRight = new MyTriangle(Color.RED, l,
                    myTriangle.getCenterXRight(), myTriangle.xTop, myTriangle.xRight,
                    myTriangle.getCenterYRight(), myTriangle.getCenterYDown(), myTriangle.getCenterYDown()
            );
            dt.fillTriangle(this.gc, myTriangle);
            dt.fillTriangle(this.gc, tTop);
            dt.fillTriangle(this.gc, tLeft);
            dt.fillTriangle(this.gc, tRight);
            dt.drawEmptyCenter(this.gc, myTriangle);
            if (l < this.level) {
                stack.push(tTop);
                stack.push(tLeft);
                stack.push(tRight);
            }
        } while (!stack.isEmpty());
        System.out.println("Drawing done!");

    }


}
