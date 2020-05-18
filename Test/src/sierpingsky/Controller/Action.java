package sierpingsky.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sierpingsky.Entity.MyRectangle;
import sierpingsky.Entity.MyTriangle;
import sierpingsky.sierpinskiRectangle.MyStackR;
import sierpingsky.sierpinskitest.MyStackT;

import java.util.ArrayDeque;
import java.util.Queue;

public class Action {
    /**
     * 自己换个名字
     * Ctrl+r 打开替换菜单，一键换名
     */
    private Queue<MyRectangle> rectangles = new ArrayDeque<>();
    private Queue<MyTriangle> triangles = new ArrayDeque<>();
    @FXML
    private TextField layout;
    @FXML
    private ComboBox<String> shape;
    @FXML
    private ComboBox<String> frontColor;
    @FXML
    private ComboBox<String> backColor;
    @FXML
    private Canvas canvas;


    @FXML
    public void setCengci() {

    }

    @FXML
    public void setShape() {
        switch (shape.getValue()) {
            case "塞尔平斯基三角形":
                drawTriangle(getLayout(), canvas);
                break;
            default:
                drawRectangles(getLayout(), canvas);
        }
    }

    @FXML
    public void setColor() {
        setShape();
    }

    private int getLayout() {
        String cengCi = layout.getText();
        if (cengCi == null && cengCi.length() == 0) {
            return 1;
        } else return Integer.valueOf(cengCi);
    }

    private Color[] getColors() {
        Color[] colors = new Color[2];
        String fColor = frontColor.getValue();
        String bColor = backColor.getValue();
        try {
            switch (fColor) {
                case "红色":
                    colors[0] = Color.RED;
                    break;
                case "黄色":
                    colors[0] = Color.YELLOW;
                    break;
                case "白色":
                    colors[0] = Color.WHITE;
                    break;
                case "蓝色":
                    colors[0] = Color.BLUE;
                    break;
                case "黑色":
                    colors[0] = Color.BLACK;
                    break;
                case "绿色":
                    colors[0] = Color.GREEN;
                    break;
                default:
                    colors[0] = Color.RED;
            }

            switch (bColor) {
                case "红色":
                    colors[1] = Color.RED;
                    break;
                case "黄色":
                    colors[1] = Color.YELLOW;
                    break;
                case "白色":
                    colors[1] = Color.WHITE;
                    break;
                case "蓝色":
                    colors[1] = Color.BLUE;
                    break;
                case "黑色":
                    colors[1] = Color.BLACK;
                    break;
                case "绿色":
                    colors[1] = Color.GREEN;
                    break;
                default:
                    colors[1] = Color.RED;
            }
        } catch (NullPointerException w) {

        }
        return colors;
    }

    private void drawRectangles(int level, Canvas canvas) {
        if (!rectangles.isEmpty()) {
            rectangles.clear();
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        MyStackR stack = new MyStackR((int) Math.pow(3.0, level) + 1);
        MyRectangle myRectangle = new MyRectangle(0, getColors()[0], 50, 0, 600, 600);
        stack.push(myRectangle);
        rectangles.add(myRectangle);
        DrawRectangle drawRectangle = new DrawRectangle();
        int l = 0;
        do {
            myRectangle = stack.pop();
            rectangles.add(myRectangle);
            l = myRectangle.getLevel();
            l++;
            MyRectangle myRectangle1 = new MyRectangle(l, getColors()[0], myRectangle.r1());
            MyRectangle myRectangle2 = new MyRectangle(l, getColors()[0], myRectangle.r2());
            MyRectangle myRectangle3 = new MyRectangle(l, getColors()[0], myRectangle.r3());
            MyRectangle myRectangle4 = new MyRectangle(l, getColors()[0], myRectangle.r4());
            MyRectangle myRectangle5 = new MyRectangle(l, getColors()[0], myRectangle.r5());
            MyRectangle myRectangle6 = new MyRectangle(l, getColors()[0], myRectangle.r6());
            MyRectangle myRectangle7 = new MyRectangle(l, getColors()[0], myRectangle.r7());
            MyRectangle myRectangle8 = new MyRectangle(l, getColors()[0], myRectangle.r8());
            if (l < level) {
                stack.push(myRectangle1);
                rectangles.add(myRectangle1);
                stack.push(myRectangle2);
                rectangles.add(myRectangle2);
                stack.push(myRectangle3);
                rectangles.add(myRectangle3);
                stack.push(myRectangle4);
                rectangles.add(myRectangle4);
                stack.push(myRectangle5);
                rectangles.add(myRectangle5);
                stack.push(myRectangle6);
                rectangles.add(myRectangle6);
                stack.push(myRectangle7);
                rectangles.add(myRectangle7);
                stack.push(myRectangle8);
                rectangles.add(myRectangle8);
            }

        } while (!stack.isEmpty());
        for (MyRectangle i : rectangles) {
            drawRectangle.DrawShape(gc, i);
            drawRectangle.DrawCenter(gc, i);
        }
    }

    private void drawTriangle(int level, Canvas canvas) {
        if (!triangles.isEmpty()) {
            triangles.clear();
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        MyStackT stack = new MyStackT((int) Math.pow(3.0, level) + 1);
        MyTriangle myTriangle = new MyTriangle(0, Color.WHITE,
                300,
                100,
                500,
                100,
                400,
                400);
        stack.push(myTriangle);
        triangles.add(myTriangle);
        DrawTriangle drawTriangle = new DrawTriangle();
        int l = 0;
        do {
            myTriangle = stack.pop();
            l = myTriangle.getLevel();
            l++;
            MyTriangle t1 = new MyTriangle(l, getColors()[0],
                    myTriangle.x0, myTriangle.getCenterX1(), myTriangle.getCenterX2(),
                    myTriangle.y0, myTriangle.getCenterY1(), myTriangle.getCenterY2());
            MyTriangle t2 = new MyTriangle(l, getColors()[0],
                    myTriangle.getCenterX1(), myTriangle.x1, myTriangle.getCenterX0(),
                    myTriangle.getCenterY1(), myTriangle.y1, myTriangle.getCenterY0());
            MyTriangle t3 = new MyTriangle(l, getColors()[0],
                    myTriangle.getCenterX2(), myTriangle.x2, myTriangle.getCenterX0(),
                    myTriangle.getCenterY2(), myTriangle.y2, myTriangle.getCenterY0());

            if (l < level) {
                stack.push(t1);
                triangles.add(t1);
                stack.push(t2);
                triangles.add(t2);
                stack.push(t3);
                triangles.add(t3);
            }
        } while (!stack.isEmpty());
        for (MyTriangle i : triangles) {
            drawTriangle.drawShape(gc, i);
            drawTriangle.drawCenters(gc, i);
        }
    }

    class DrawRectangle {
        public void DrawShape(GraphicsContext gc, MyRectangle Rectangle) {
            gc.setStroke(Color.BLACK);
            gc.strokeRect(Rectangle.X, Rectangle.Y, Rectangle.width, Rectangle.height);
            gc.setFill(Rectangle.getColor());
            gc.fillRect(Rectangle.X, Rectangle.Y, Rectangle.width, Rectangle.height);
            gc.setStroke(Color.BLACK);
        }

        public void DrawCenter(GraphicsContext gc, MyRectangle Rectangle) {
            gc.strokeRect(Rectangle.getCenterX(), Rectangle.getCenterY(), Rectangle.minwidth, Rectangle.minheight);
            gc.setFill(getColors()[1]);
            gc.fillRect(Rectangle.getCenterX(), Rectangle.getCenterY(), Rectangle.minwidth, Rectangle.minheight);
        }
    }

    class DrawTriangle {
        public void drawShape(GraphicsContext gc, MyTriangle triangle) {
            gc.setStroke(Color.WHITE);
            gc.strokePolygon(new double[]{
                            triangle.getX()[0],
                            triangle.getX()[1],
                            triangle.getX()[2]},
                    new double[]{
                            triangle.getY()[0],
                            triangle.getY()[1],
                            triangle.getY()[2]
                    }, 3);
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
                    }, 3);
        }

        public void drawCenters(GraphicsContext gc, MyTriangle triangle) {
            gc.setStroke(Color.WHITE);
            gc.strokePolygon(new double[]{
                            triangle.center1[0],
                            triangle.center2[0],
                            triangle.center3[0]},
                    new double[]{
                            triangle.center1[1],
                            triangle.center2[1],
                            triangle.center3[1]
                    }, 3);
            gc.setFill(getColors()[1]);
            gc.fillPolygon(new double[]{
                            triangle.center1[0],
                            triangle.center2[0],
                            triangle.center3[0]},
                    new double[]{
                            triangle.center1[1],
                            triangle.center2[1],
                            triangle.center3[1]
                    }, 3);
        }
    }
}
