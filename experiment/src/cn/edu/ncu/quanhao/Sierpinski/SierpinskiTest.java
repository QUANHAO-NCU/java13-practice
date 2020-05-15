package cn.edu.ncu.quanhao.Sierpinski;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SierpinskiTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        ControlPen cp = new ControlPen(3,420);
        Scene scene = new Scene(cp,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("塞尔平斯基三角形");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
