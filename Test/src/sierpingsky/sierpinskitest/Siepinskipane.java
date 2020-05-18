package sierpingsky.sierpinskitest;

import sierpingsky.Entity.MyTriangle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Siepinskipane extends Pane {
    private Canvas canvas;
    private GraphicsContext gc;
    private int size = 1;
    private int level;
    private double lenth;
    private DrawTriangle drawTriangle = new DrawTriangle();



    Siepinskipane(int level) {
        this.level = level;
        canvas = new Canvas(600,600);
        this.gc = canvas.getGraphicsContext2D();
        generate(level);
        getChildren().add(canvas);
    }
    public void generate(int level) {
        MyStackT stack=new MyStackT((int)Math.pow(3.0,this.level)+1);
        MyTriangle myTriangle = new MyTriangle(0, Color.WHITE,
                300,
                100,
                500,
                100,
                400,
                400);
        stack.push(myTriangle);

        int l = 0;
        do {
            myTriangle = stack.pop();
            l = myTriangle.getLevel();
            l++;
            MyTriangle t1 = new MyTriangle(l, Color.YELLOW,
                    myTriangle.x0, myTriangle.getCenterX1(), myTriangle.getCenterX2(),
                    myTriangle.y0, myTriangle.getCenterY1(), myTriangle.getCenterY2());
            MyTriangle t2 = new MyTriangle(l, Color.BLUE,
                    myTriangle.getCenterX1(), myTriangle.x1, myTriangle.getCenterX0(),
                    myTriangle.getCenterY1(), myTriangle.y1, myTriangle.getCenterY0());
            MyTriangle t3 = new MyTriangle(l, Color.RED,
                    myTriangle.getCenterX2(), myTriangle.x2, myTriangle.getCenterX0(),
                    myTriangle.getCenterY2(), myTriangle.y2, myTriangle.getCenterY0());

            drawTriangle.drawShape(this.gc, myTriangle);
            drawTriangle.drawShape(this.gc, t1);
            drawTriangle.drawShape(this.gc, t2);
            drawTriangle.drawShape(this.gc, t3);
            drawTriangle.drawCenters(this.gc, myTriangle);
            if (l < this.level) {
                stack.push(t1);
                stack.push(t2);
                stack.push(t3);
            }
        } while (!stack.isEmpty());


    }

    //public void generate(int level, double lenth) {
    //        Stack<MyTriangle> stack = new Stack<>();
    //        MyTriangle myTriangle = new MyTriangle(2, Color.BLACK,
    //                300,
    //                100,
    //                500,
    //                100,
    //                400,
    //                400);
    //        stack.push(myTriangle);
    //
    //        int l = 0;
    //        do {
    //            myTriangle = stack.pop();
    //            l = myTriangle.getLevel();
    //            l++;
    //            MyTriangle t1 = new MyTriangle(l, Color.YELLOW,
    //                    myTriangle.x0, myTriangle.getCenterX1(), myTriangle.getCenterX2(),
    //                    myTriangle.y0, myTriangle.getCenterY1(), myTriangle.getCenterY2());
    //            MyTriangle t2 = new MyTriangle(l, Color.BLUE,
    //                    myTriangle.getCenterX1(), myTriangle.x1, myTriangle.getCenterX0(),
    //                    myTriangle.getCenterY1(), myTriangle.y1, myTriangle.getCenterY0());
    //            MyTriangle t3 = new MyTriangle(l, Color.RED,
    //                    myTriangle.getCenterX2(), myTriangle.x2, myTriangle.getCenterX0(),
    //                    myTriangle.getCenterY2(), myTriangle.y2, myTriangle.getCenterY0());
    //
    //            drawTriangle.drawShape(this.gc, myTriangle);
    //            drawTriangle.drawShape(this.gc, t1);
    //            drawTriangle.drawShape(this.gc, t2);
    //            drawTriangle.drawShape(this.gc, t3);
    //            drawTriangle.drawCenters(this.gc, myTriangle);
    //            if (l < this.level) {
    //                stack.push(t1);
    //                stack.push(t2);
    //                stack.push(t3);
    //            }
    //        } while (!stack.isEmpty());
    //
    //
    //    }

}

    //public void generate(int level,double lenth){int l=0;
    //        MyStackR stack=new MyStackR(size);
    //        stack.push(myTriangle);
    //        do{
    //            myTriangle=stack.pop();
    //            l=myTriangle.getLevel();
    //            double[]x=myTriangle.getX();
    //            double[]y=myTriangle.getY();
    //
    //            double[]center1=getCenter(x[0],y[0],x[1],y[1]);
    //            double[]center2=getCenter(x[2],y[2],x[1],y[1]);
    //            double[]center3=getCenter(x[0],y[0],x[2],y[2]);
    //            l++;
    //            MyTriangle t1=new MyTriangle(1,Color.YELLOW,x[0],y[0],center1[0],center1[1],center3[0],center3[1]);
    //            MyTriangle t2=new MyTriangle(1,Color.BLUE,center1[0],center1[1],x[1],y[1],center2[0],center2[1]);
    //            MyTriangle t3=new MyTriangle(1,Color.RED,center2[0],center1[1],x[2],y[2],center3[0],center3[1]);
    //
    //            (gc,t1);
    //            drawShape(gc,t2);
    //            drawShape(gc,t3);
    //            dt.drawCenters(this.gc, myTriangle);
    //
    //
    //            if(l<level){
    //                stack.push(t1);
    //                stack.push(t2);
    //                stack.push(t3);
    //            }
    //        }while (!stack.isEmpty());
    //
    //    }




//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//
//public class SierpinskiTriangle {
//    private MyTriangle myTriangle;
//    private int level;
//    private int size=1;
//    public GraphicsContext gc;
//    private Drawtriangle dt=new Drawtriangle();
//    public SierpinskiTriangle(int level,MyTriangle myTriangle){
//        this.level=level;
//        this.myTriangle=myTriangle;
//        for (int i=1;i<level;i++){
//            this.size*=3;
//        }
//    }
//
//
//    public void drawShape(GraphicsContext gc,MyTriangle triangle){
//        gc.setStroke(Color.BLACK);
//        gc.strokePolygon(new double[]{
//                        triangle.x[0],
//                        triangle.x[1],
//                        triangle.x[2]},
//                new double[]{
//                        triangle.y[0],
//                        triangle.y[1],
//                        triangle.y[2]
//                },3);
//        gc.setFill(triangle.getColor());
//        gc.fillPolygon(
//                new double[]{
//                        triangle.x[0],
//                        triangle.x[1],
//                        triangle.x[2]},
//                new double[]{
//                        triangle.y[0],
//                        triangle.y[1],
//                        triangle.y[2]
//                },3);
//    }
//    public void drawCenters(GraphicsContext gc, MyTriangle triangle){
//        gc.setStroke(Color.BLACK);
//        gc.strokePolygon(new double[]{
//                        triangle.center1[0],
//                        triangle.center3[0],
//                        triangle.center2[0]},
//                new double[]{
//                        triangle.center1[1],
//                        triangle.center3[1],
//                        triangle.center2[1]
//                },3);
//        gc.setFill(Color.WHITE);
//        gc.fillPolygon(new double[]{
//                        triangle.center1[0],
//                        triangle.center3[0],
//                        triangle.center2[0]},
//                new double[]{
//                        triangle.center1[1],
//                        triangle.center3[1],
//                        triangle.center2[1]
//                },3);
//    }
//
//
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.layout.Pane;
//
//public class SierpinskiTrianglePane extends Pane{
//
//        private Canvas canvas;
//        private GraphicsContext gc;
//        private SierpinskiTriangle triangle;
//
//        public SierpinskiTrianglePane(){
//            MyTriangle t=new MyTriangle(300,15,600,500,15,500);
//            triangle=new SierpinskiTriangle(3,t);
//            this.canvas=new Canvas(600,600);
//            this.gc=canvas.getGraphicsContext2D();
//
//            paint(triangle);
//            getChildren().addAll(canvas);
//    }
//    public void paint(SierpinskiTriangle triangle){triangle.generate(gc);}
//}
//}import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.awt.*;
//
//public class TestSierpinskiTriangle extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        SierpinskiTrianglePane p=new SierpinskiTrianglePane();
//        Scene s=new Scene(p,610,660);
//        primaryStage.setScene(s);
//        primaryStage.setTitle("test1");
//        primaryStage.show();
//    }
//    public static void main(String... args){
//        Application.launch(args);
//    }
//}import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//
//public class Drawtriangle {
//    public void drawShape(GraphicsContext gc, MyTriangle triangle){
//        gc.setStroke(Color.BLACK);
//        gc.strokePolygon(new double[]{
//                        triangle.x[0],
//                        triangle.x[1],
//                        triangle.x[2]},
//                new double[]{
//                        triangle.y[0],
//                        triangle.y[1],
//                        triangle.y[2]
//                },3);
//        gc.setFill(triangle.getColor());
//        gc.fillPolygon(
//                new double[]{
//                        triangle.x[0],
//                        triangle.x[1],
//                        triangle.x[2]},
//                new double[]{
//                        triangle.y[0],
//                        triangle.y[1],
//                        triangle.y[2]
//                },3);
//    }
//    public void drawCenters(GraphicsContext gc, MyTriangle triangle){
//        gc.setStroke(Color.BLACK);
//        gc.strokePolygon(new double[]{
//                        triangle.center1[0],
//                        triangle.center3[0],
//                        triangle.center2[0]},
//                new double[]{
//                        triangle.center1[1],
//                        triangle.center3[1],
//                        triangle.center2[1]
//                },3);
//        gc.setFill(Color.WHITE);
//        gc.fillPolygon(new double[]{
//                        triangle.center1[0],
//                        triangle.center3[0],
//                        triangle.center2[0]},
//                new double[]{
//                        triangle.center1[1],
//                        triangle.center3[1],
//                        triangle.center2[1]
//                },3);
//    }
//}