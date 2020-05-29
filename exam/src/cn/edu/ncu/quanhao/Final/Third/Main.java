package cn.edu.ncu.quanhao.Final.Third;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(800,700);
        Canvas canvas = new Canvas();
        canvas.setLayoutX(0);canvas.setLayoutY(0);
        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList("正方形","矩形","三角形"));
        comboBox.setLayoutX(500);comboBox.setLayoutY(0);
        comboBox.setPrefSize(150,50);
        TextField textField = new TextField();
        textField.setPromptText("输入选择的形状的参数：正方形/三角形 ：边长;矩形：长,宽");
        textField.setLayoutX(500);textField.setLayoutY(comboBox.getLayoutY()+comboBox.getPrefHeight());
        textField.setPrefSize(150,50);
        Button button = new Button("绘制");
        button.setLayoutX(500);button.setLayoutY(textField.getLayoutY()+textField.getPrefHeight());
        button.setOnAction(event -> {
            switch (comboBox.getValue()){
                case "正方形":
                    try{
                        int value = Integer.valueOf(textField.getText());
                        Square square = new Square(value);
                        square.drawShape(canvas);
                    }catch (NumberFormatException n){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("应该输入一个整数！");
                        alert.showAndWait();
                    }
                    break;
                case "三角形":
                    try{
                        int value = Integer.valueOf(textField.getText());
                        Triangle triangle = new Triangle(value);
                        triangle.drawShape(canvas);
                    }catch (NumberFormatException n){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("应该输入一个整数！");
                        alert.showAndWait();
                    }
                    break;
                case "矩形":
                    try{
                        String[] s = textField.getText().split(",");
                        int width = Integer.valueOf(s[0]);
                        int height = Integer.valueOf(s[1]);
                        Rectangle rectangle = new Rectangle(width,height);
                        rectangle.drawShape(canvas);
                    }catch (NumberFormatException n ){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("输入格式不对或者输入的不是整数！");
                        alert.showAndWait();
                    }catch (ArrayIndexOutOfBoundsException a){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("输入格式不对或者输入的不是整数！");
                        alert.showAndWait();
                    }
            }
        });
        pane.getChildren().addAll(canvas,comboBox,textField,button);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
