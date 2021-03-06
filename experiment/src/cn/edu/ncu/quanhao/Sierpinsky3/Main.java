package cn.edu.ncu.quanhao.Sierpinsky3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainPane = FXMLLoader.load(getClass().getResource("view/mainView.fxml"));
        Scene scene = new Scene(mainPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("塞尔平斯基形状家族");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
