package cn.edu.ncu.quanhao.chapter11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = FXMLLoader.load(getClass().getResource("view/mainView.fxml"));
        Scene scene = new Scene(borderPane,800,400);
        primaryStage.setTitle("计算器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
