package cn.edu.ncu.quanhao.chapter06;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;
import static java.lang.StrictMath.PI;


import java.util.Optional;

public class JavaFx_CircleAreaCounter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        double radius = 1.0,areas = 0.0;
        //输入
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("JavaFX_CircleAreaCounter");
        inputDialog.setHeaderText("请输入圆的半径：");
        inputDialog.setContentText("圆的半径：");
        Optional<String> input = inputDialog.showAndWait();
        radius = parseDouble(input.get());
        areas = radius*radius*PI;
        //输出
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("JavaFX_CircleAreaCounter");
        alert.setHeaderText("这个圆：");
        alert.setContentText("半径是："+radius+"\n面积是："+areas);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
