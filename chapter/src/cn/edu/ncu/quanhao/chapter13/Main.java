package cn.edu.ncu.quanhao.chapter13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static List<Stage> stageList;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stageList = new ArrayList<>();
        stageList.add(primaryStage);
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("view/mainView.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setTitle("文件浏览器");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
