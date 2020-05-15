package cn.edu.ncu.quanhao.Sierpinsky2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class View extends Pane {
    View() {
        final Color[][] colors = new Color[1][1];
        this.setPrefSize(1200, 700);
        this.setMaxSize(1200, 700);
        ComboBox<String> comboBox = new ComboBox(FXCollections.observableArrayList("选择要绘制的图形",
                "塞尔平斯基三角形", "塞尔平斯基矩形"));
        comboBox.getSelectionModel().select(0);
        comboBox.setPrefSize(240, 30);
        comboBox.setLayoutX(50);
        comboBox.setLayoutY(50);
        Label label = new Label("输入要绘制的塞尔平斯基图形的层级1-7");
        label.setPrefSize(120, 30);
        label.setLayoutX(comboBox.getLayoutX());
        label.setLayoutY(comboBox.getLayoutY() + comboBox.getPrefHeight());
        TextField textField = new TextField();
        textField.setPrefSize(120, 30);
        textField.setLayoutX(label.getLayoutX() + label.getPrefWidth());
        textField.setLayoutY(label.getLayoutY());
        Button button = new Button("开始绘制！");
        button.setPrefSize(240, 40);
        button.setLayoutX(label.getLayoutX());
        button.setLayoutY(label.getLayoutY() + label.getPrefHeight());
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(800, 700);
        anchorPane.setPadding(new Insets(50, 0, 50, 0));
        anchorPane.setLayoutX(400);
        anchorPane.setLayoutY(0);
        anchorPane.setBackground(new Background(new BackgroundFill(Color.LAVENDER, null, null)));
        comboBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!anchorPane.getChildren().isEmpty()) {
                    anchorPane.getChildren().clear();
                }
            }
        });
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String choice = comboBox.getValue();
                if (choice.equals("塞尔平斯基三角形")) {
                    if (!anchorPane.getChildren().isEmpty()) {
                        anchorPane.getChildren().clear();
                    }
                    colors[0] = new Color[4];
                    colors[0] = new Color[]{Color.RED, Color.YELLOW, Color.BLUE, Color.PINK};
                    Canvas canvas = new Canvas(240, 240);

                    canvas.setLayoutX(0);
                    canvas.setLayoutY(0);
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    gc.setStroke(Color.BLACK);
                    gc.strokePolygon(new double[]{120, 0, 240}, new double[]{0, 240, 240}, 3);
                    gc.strokePolygon(new double[]{60, 180, 120}, new double[]{120, 120, 240}, 3);
                    ColorPicker colorPicker = new ColorPicker();
                    colorPicker.setLayoutX(canvas.getLayoutX() + canvas.getWidth());
                    colorPicker.setLayoutX(300);
                    colorPicker.setLayoutY(0);
                    anchorPane.getChildren().add(colorPicker);
                    anchorPane.getChildren().add(canvas);
                    canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            double x = event.getX();
                            double y = event.getY();

                            if ((60 < x && x < 180) && (0 < y && y < 120)) {
                                //top
                                colors[0][0] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{60, 120, 180}, new double[]{120, 0, 120}, 3);
                            }
                            if ((0 < x && x < 60) && (120 < y && y < 240)) {
                                //left
                                colors[0][1] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{0, 60, 120}, new double[]{240, 120, 240}, 3);
                            }
                            if ((180 < x && x < 240) && (120 < y && y < 240)) {
                                //right
                                colors[0][2] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{120, 180, 240}, new double[]{240, 120, 240}, 3);
                            }
                            if ((60 < x && x < 180) && (120 < y && y < 240)) {
                                //empty
                                colors[0][3] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{60, 180, 120}, new double[]{120, 120, 240}, 3);
                            }
                        }
                    });
                } else {
                    if (!anchorPane.getChildren().isEmpty()) {
                        anchorPane.getChildren().clear();
                    }
                    colors[0] = new Color[9];
                    colors[0] = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLUE, Color.PURPLE, Color.GOLD, Color.PINK};
                    Canvas canvas = new Canvas(240, 240);
                    canvas.setLayoutX(0);
                    canvas.setLayoutY(0);
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    gc.setStroke(Color.BLACK);
                    gc.strokePolygon(new double[]{0, 0, 80, 80}, new double[]{0, 80, 80, 0}, 4);
                    gc.strokePolygon(new double[]{80, 80, 160, 160}, new double[]{0, 80, 80, 0}, 4);
                    gc.strokePolygon(new double[]{160, 160, 240, 240}, new double[]{0, 80, 80, 0}, 4);

                    gc.strokePolygon(new double[]{0, 0, 80, 80}, new double[]{80, 160, 160, 80}, 4);
                    gc.strokePolygon(new double[]{80, 80, 160, 160}, new double[]{80, 160, 160, 80}, 4);
                    gc.strokePolygon(new double[]{160, 160, 240, 240}, new double[]{80, 160, 160, 80}, 4);

                    gc.strokePolygon(new double[]{0, 0, 80, 80}, new double[]{160, 240, 240, 160}, 4);
                    gc.strokePolygon(new double[]{80, 80, 160, 160}, new double[]{160, 240, 240, 160}, 4);
                    gc.strokePolygon(new double[]{160, 160, 240, 240}, new double[]{160, 240, 240, 160}, 4);
                    ColorPicker colorPicker = new ColorPicker();
                    colorPicker.setLayoutX(300);
                    colorPicker.setLayoutY(0);
                    anchorPane.getChildren().add(colorPicker);
                    anchorPane.getChildren().add(canvas);
                    canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            double x = event.getX();
                            double y = event.getY();
                            if ((0 < x && x < 80) && (0 < y && y < 80)) {
                                //RUL
                                colors[0][0] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{0, 0, 80, 80}, new double[]{0, 80, 80, 0}, 4);
                            }
                            if ((80 < x && x < 160) && (0 < y && y < 80)) {
                                //RUC
                                colors[0][1] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{80, 80, 160, 160}, new double[]{0, 80, 80, 0}, 4);
                            }
                            if ((160 < x && x < 240) && (0 < y && y < 80)) {
                                //RUR
                                colors[0][2] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{160, 160, 240, 240}, new double[]{0, 80, 80, 0}, 4);

                            }
                            if ((0 < x && x < 80) && (80 < y && y < 160)) {
                                //RCL
                                colors[0][3] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{0, 0, 80, 80}, new double[]{80, 160, 160, 80}, 4);

                            }
                            if ((160 < x && x < 240) && (80 < y && y < 160)) {
                                //RCR
                                colors[0][4] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{160, 160, 240, 240}, new double[]{80, 160, 160, 80}, 4);

                            }
                            if ((0 < x && x < 80) && (160 < y && y < 240)) {
                                //RDL
                                colors[0][5] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{0, 0, 80, 80}, new double[]{160, 240, 240, 160}, 4);

                            }
                            if ((80 < x && x < 160) && (160 < y && y < 240)) {
                                //RDC
                                colors[0][6] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{80, 80, 160, 160}, new double[]{160, 240, 240, 160}, 4);

                            }
                            if ((160 < x && x < 240) && (160 < y && y < 240)) {
                                //RDR
                                colors[0][7] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{160, 160, 240, 240}, new double[]{160, 240, 240, 160}, 4);

                            }
                            if ((80 < x && x < 160) && (80 < y && y < 160)) {
                                //empty
                                colors[0][8] = colorPicker.getValue();
                                gc.setFill(colorPicker.getValue());
                                gc.fillPolygon(new double[]{80, 80, 160, 160}, new double[]{80, 160, 160, 80}, 4);
                            }
                        }
                    });
                }
            }
        });
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String choice = comboBox.getValue();
                String levelGet = textField.getText();
                Controller controller = new Controller();
                if (!anchorPane.getChildren().isEmpty()) {
                    anchorPane.getChildren().clear();
                }
                System.out.println(choice + "\n" + levelGet);
                if (!(levelGet == null || levelGet.length() == 0)) {
                    try {
                        int i = Integer.valueOf(levelGet);
                        System.out.println("levelGet:"+i);
                        if(i==0){
                            throw new IllegalArgumentException();
                        }
                        if (choice.equals("塞尔平斯基三角形")) {
                            Strategy s = new DrawTriangleStrategy();
                            controller.setStrategy(s);
                            controller.handle(Integer.valueOf(levelGet), colors[0]);
                            anchorPane.getChildren().add(controller.returnPane());
                        } else {
                            Strategy s = new DrawRectangleStrategy();
                            controller.setStrategy(s);
                            controller.handle(Integer.valueOf(levelGet), colors[0]);
                            anchorPane.getChildren().add(controller.returnPane());
                        }
                    } catch (NumberFormatException e ) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("JavaFX_Alert");
                        alert.setHeaderText("输入了错误的层级参数");
                        alert.setContentText("重新输入层级参数1,2,3,4,5,6,7...");
                        alert.showAndWait();
                    }catch (IllegalArgumentException a){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("JavaFX_Alert");
                        alert.setHeaderText("层级参数不应为0");
                        alert.setContentText("重新输入层级参数1,2,3,4,5,6,7...");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("JavaFX_Alert");
                    alert.setHeaderText("没有输入层级参数");
                    alert.setContentText("重新输入层级参数1,2,3,4,5,6,7...");
                    alert.showAndWait();
                }
            }
        });
        this.getChildren().addAll(comboBox, label, textField, button, anchorPane);
    }
}
