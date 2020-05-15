package cn.edu.ncu.quanhao.Sierpinsky2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SierpinskiTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        View view = new View();
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle("塞尔平斯基图形绘制器");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
