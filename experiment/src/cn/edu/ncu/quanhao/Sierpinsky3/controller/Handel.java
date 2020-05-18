package cn.edu.ncu.quanhao.Sierpinsky3.controller;

import cn.edu.ncu.quanhao.Sierpinsky3.model.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.*;

public class Handel implements Drawable {
    private static int runTimes = 0;
    private List<MyRectangle> doneRec = new ArrayList<>();
    private List<MyTriangle> doneTri = new ArrayList<>();
    private List<MyRectangle> Rec = new ArrayList<>();
    private List<MyTriangle> Tri = new ArrayList<>();
    MyThreadGroup threadGroup = new MyThreadGroup("渲染线程组");
    MyThreadGroup threadGroupR = new MyThreadGroup("重渲染线程组");

    @FXML
    private TextField layoutTxt;
    @FXML
    private ComboBox<String> choiceShape;
    @FXML
    private ComboBox<String> choiceFrontColor;
    @FXML
    private ComboBox<String> choiceBackColor;
    @FXML
    private Canvas showCanvas;
    @FXML
    private Button startBtn;

    @FXML
    public void setLevel() throws InterruptedException {
        /**
         * 重新设置了层级，则按照参数重新绘制
         * 初次选择不启动绘制
         * */
        canvasClear();
        if (runTimes != 0) {
            startDraw();
        }

    }

    @FXML
    public void setShape() throws InterruptedException {
        /**
         * 重新设置了绘制图形，则按照参数重新绘制
         * 初次选择不启动绘制
         * */
        canvasClear();
        if (runTimes != 0) {
            startDraw();
        }
    }

    @FXML
    public void setColor() {
        /**
         * 获取当前已绘制的图形，立即重设前景色，后景色
         * 可能线程不安全了
         * */

        if (runTimes != 0) {
            synchronized (threadGroup) {
                //绘图的入口进程锁定
                synchronized (threadGroupR) {
                    //绘图的实时进程锁定
                    Color[] colors = new Color[]{getFrontColor(), getBackColor()};

                    for (MyRectangle i : doneRec) {
                        i.setColor(colors);
                    }
                    for (MyTriangle i : doneTri) {
                        i.setColor(colors);
                    }
                    for (MyRectangle i : Rec) {
                        i.setColor(colors);
                    }
                    for (MyTriangle i : Tri) {
                        i.setColor(colors);
                    }

                    switch (getShape()) {
                        case 1:
                            drawTriangle(showCanvas, doneTri);
                            break;
                        case 2:
                            drawRectangle(showCanvas, doneRec);
                    }
                }
            }
        }
    }


    @FXML
    public void startDraw() {
        runTimes = 1;
        threadGroupR.stop();
        threadGroup.stop();
        canvasClear();
        int shape = getShape();
        Color frontColor = getFrontColor();
        Color backColor = getBackColor();
        switch (shape) {
            case 1:
                MyTriangle myTriangle = new MyTriangle(
                        new Color[]{frontColor, backColor}, 0, 400, 50, 750,
                        0, 400, 400);
                Thread drawTriangleTaskThread = new Thread(threadGroup, new Runnable() {
                    @Override
                    public void run() {
                        drawTriangle(showCanvas, generateTriList(myTriangle, getLevel()), 1);
                        return;
                    }
                }, "绘制三角形入口");
                drawTriangleTaskThread.start();
                threadGroup.remove(drawTriangleTaskThread);
                break;
            case 2:
                MyRectangle myRectangle = new MyRectangle(150, 0, 500, 500, 0, new Color[]{frontColor, backColor});
                Thread drawRectangleTaskThread = new Thread(threadGroup, new Runnable() {
                    @Override
                    public void run() {
                        drawRectangle(showCanvas, generateRecList(myRectangle, getLevel()), 1);
                        return;
                    }
                }, "绘制矩形入口");
                drawRectangleTaskThread.start();
                threadGroup.remove(drawRectangleTaskThread);
        }
    }

    private List<MyRectangle> generateRecList(MyRectangle myRectangle, int level) {
        /**
         * BFS广度优先
         * */
        Rec.clear();
        Stack<MyRectangle> stack = new Stack<>();
        stack.push(myRectangle);
        Rec.add(myRectangle);
        double l = 0;
        do {
            myRectangle = stack.pop();
            l = myRectangle.getLevel();
            l++;
            MyRectangle RUL = new MyRectangle(myRectangle.getUpLeftREC(), l, myRectangle.getColor());
            MyRectangle RUC = new MyRectangle(myRectangle.getUpCenterREC(), l, myRectangle.getColor());
            MyRectangle RUR = new MyRectangle(myRectangle.getUpRightREC(), l, myRectangle.getColor());
            MyRectangle RCL = new MyRectangle(myRectangle.getCenterLeftREC(), l, myRectangle.getColor());
            MyRectangle RCR = new MyRectangle(myRectangle.getCenterRightREC(), l, myRectangle.getColor());
            MyRectangle RDL = new MyRectangle(myRectangle.getDownLeftREC(), l, myRectangle.getColor());
            MyRectangle RDC = new MyRectangle(myRectangle.getDownCenterREC(), l, myRectangle.getColor());
            MyRectangle RDR = new MyRectangle(myRectangle.getDownRightREC(), l, myRectangle.getColor());
            Rec.addAll(Arrays.asList(new MyRectangle[]{RUL, RUC, RUR, RCL, RCR, RDL, RDC, RDR}));
            if (l < level) {
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
        return Rec;
    }

    private List<MyTriangle> generateTriList(MyTriangle myTriangle, int level) {
        /**
         * BFS广度优先
         * */
        Tri.clear();
        Stack<MyTriangle> stack = new Stack<>();

        stack.push(myTriangle);
        int l = 0;
        do {
            myTriangle = stack.pop();
            l = myTriangle.getLevel();
            l++;
            MyTriangle tTop = new MyTriangle(myTriangle.getColor(), l,
                    myTriangle.xTop, myTriangle.getCenterXLeft(), myTriangle.getCenterXRight(),
                    myTriangle.yTop, myTriangle.getCenterYLeft(), myTriangle.getCenterYRight());
            MyTriangle tLeft = new MyTriangle(myTriangle.getColor(), l,
                    myTriangle.getCenterXLeft(), myTriangle.xLeft, myTriangle.getCenterXTop(),
                    myTriangle.getCenterYLeft(), myTriangle.yLeft, myTriangle.getCenterYDown());
            MyTriangle tRight = new MyTriangle(myTriangle.getColor(), l,
                    myTriangle.getCenterXRight(), myTriangle.xTop, myTriangle.xRight,
                    myTriangle.getCenterYRight(), myTriangle.getCenterYDown(), myTriangle.getCenterYDown()
            );
            Tri.addAll(Arrays.asList(new MyTriangle[]{tTop, tLeft, tRight}));
            if (l < level) {
                stack.push(tTop);
                stack.push(tLeft);
                stack.push(tRight);
            }
        } while (!stack.isEmpty());
        return Tri;
    }

    private void drawRectangle(Canvas canvas, List<MyRectangle> theRec, int model) {
        /**
         * model==1，渲染图像
         * model==0,将渲染过的图像重新上色
         * */
        GraphicsContext gc = canvas.getGraphicsContext2D();
        doneRec.clear();
        List<MyRectangle> list = new ArrayList<>();
        list.addAll(theRec);//获取一个备份，防止不安全的访问
        if (!list.isEmpty()) {
            double counter = 1;
            for (MyRectangle myRectangle : list) {
                counter += 0.2;
                Thread thread = new Thread(threadGroupR, new Runnable() {
                    @Override
                    public void run() {
                        drawShape(gc, myRectangle.getXPoints(), myRectangle.getYPoints(), myRectangle.getColor()[0]);
                        drawEmpty(gc, myRectangle.getEmptyXPoints(), myRectangle.getEmptyYPoints(), myRectangle.getColor()[1]);
                        doneRec.add(myRectangle);
                        return;//return线程终止
                    }
                }, "绘制矩形实时线程");
                try {
                    thread.start();
                    thread.sleep((long) (500/counter));
                    thread.interrupt();
                    threadGroupR.remove(thread);
                } catch (InterruptedException e) {
                }
            }
        }
    }


    private void drawTriangle(Canvas canvas, List<MyTriangle> theTri, int model) {
        /**
         * 非 0 值，重新渲染前景色和后景色
         * */
        GraphicsContext gc = canvas.getGraphicsContext2D();
        doneTri.clear();
        List<MyTriangle> list = new ArrayList<>();
        list.addAll(theTri);//获取一个备份，防止不安全的访问
        if (!list.isEmpty()) {
            double counter = 1;
            for (MyTriangle myTriangle : list) {
                counter += 0.1;
                Thread thread = new Thread(threadGroupR, new Runnable() {
                    @Override
                    public void run() {
                        drawShape(gc, myTriangle.getXPoints(), myTriangle.getYPoints(), myTriangle.getColor()[0]);
                        drawEmpty(gc, myTriangle.getCenterX(), myTriangle.getCenterY(), myTriangle.getColor()[1]);
                        doneTri.add(myTriangle);
                        return;
                    }
                }, "绘制三角形实时线程");
                try {
                    thread.start();
                    thread.sleep((long) (500/counter));
                    threadGroupR.remove(thread);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private void drawRectangle(Canvas canvas, List<MyRectangle> theRec) {
        /**
         * model==1，渲染图像
         * model==0,将渲染过的图像重新上色
         * */
        GraphicsContext gc = canvas.getGraphicsContext2D();
        List<MyRectangle> list = new ArrayList<>();
        list.addAll(theRec);//获取一个备份，防止不安全的访问
        if (!list.isEmpty()) {
            for (MyRectangle myRectangle : list) {
                drawShape(gc, myRectangle.getXPoints(), myRectangle.getYPoints(), myRectangle.getColor()[0]);
                drawEmpty(gc, myRectangle.getEmptyXPoints(), myRectangle.getEmptyYPoints(), myRectangle.getColor()[1]);
            }
        }
    }

    private void drawTriangle(Canvas canvas, List<MyTriangle> theTri) {
        /**
         * 非 0 值，重新渲染前景色和后景色
         * */
        GraphicsContext gc = canvas.getGraphicsContext2D();
        List<MyTriangle> list = new ArrayList<>();
        list.addAll(theTri);//获取一个备份，防止不安全的访问
        if (!list.isEmpty()) {
            for (MyTriangle myTriangle : list) {
                drawShape(gc, myTriangle.getXPoints(), myTriangle.getYPoints(), myTriangle.getColor()[0]);
                drawEmpty(gc, myTriangle.getCenterX(), myTriangle.getCenterY(), myTriangle.getColor()[1]);
            }
        }
    }

    private void canvasClear() {
        Rec.clear();
        Tri.clear();
        doneRec.clear();
        doneTri.clear();
        showCanvas.getGraphicsContext2D().clearRect(0, 0, showCanvas.getWidth(), showCanvas.getHeight());
    }

    private int getLevel() {
        try {
            return Integer.valueOf(layoutTxt.getText());

        } catch (NumberFormatException e) {
        }
        return 1;
    }

    private int getShape() {
        String shape = choiceShape.getValue();
        try {
            switch (shape) {
                case "塞尔平斯基三角形":
                    return 1;
                case "塞尔平斯基地毯":
                    return 2;
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("缺少必要参数");
            alert.setContentText("你必须选择一个形状");
            alert.showAndWait();
        }
        return 0;
    }

    private Color getFrontColor() {
        String FrontColor = choiceFrontColor.getValue();
        try {
            switch (FrontColor) {
                case "白色":
                    return Color.WHITE;
                case "绿色":
                    return Color.GREEN;
                case "红色":
                    return Color.RED;
                case "黄色":
                    return Color.YELLOW;
                case "蓝色":
                    return Color.BLUE;
                case "黑色":
                    return Color.BLACK;
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("缺少必要参数");
            alert.setContentText("选择一个前景色");
            alert.showAndWait();

        }
        return null;
    }

    private Color getBackColor() {
        String BackColor = choiceBackColor.getValue();
        try {
            switch (BackColor) {
                case "白色":
                    return Color.WHITE;
                case "绿色":
                    return Color.GREEN;
                case "红色":
                    return Color.RED;
                case "黄色":
                    return Color.YELLOW;
                case "蓝色":
                    return Color.BLUE;
                case "黑色":
                    return Color.BLACK;
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("缺少必要参数");
            alert.setContentText("选择一个后景色");
            alert.showAndWait();
        }
        return null;
    }

}
class MyThreadGroup extends ThreadGroup {
    private final ThreadGroup parent;
    String name;
    int maxPriority;
    boolean destroyed;
    boolean daemon;

    int nUnstartedThreads = 0;
    int nthreads;
    Thread threads[];

    int ngroups;
    ThreadGroup groups[];

    public MyThreadGroup(String name, ThreadGroup parent) {
        super(name);
        this.parent = parent;
    }

    public MyThreadGroup(String name) {
        this(name, Thread.currentThread().getThreadGroup());
    }


    public void remove(Thread t) {
        synchronized (this) {
            if (destroyed) {
                return;
            }
            for (int i = 0; i < nthreads; i++) {
                if (threads[i] == t) {
                    System.arraycopy(threads, i + 1, threads, i, --nthreads - i);
                    // Zap dangling reference to the dead thread so that
                    // the garbage collector will collect it.
                    threads[nthreads] = null;
                    break;
                }
            }
        }
    }
}
