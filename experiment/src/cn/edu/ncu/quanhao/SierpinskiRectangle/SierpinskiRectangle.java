package cn.edu.ncu.quanhao.SierpinskiRectangle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SierpinskiRectangle extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DrawingControl dc = new DrawingControl(3,500);
        Scene scene = new Scene(dc,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("塞尔平斯基地毯");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
