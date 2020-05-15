package cn.edu.ncu.quanhao.chapter11.controller;

import cn.edu.ncu.quanhao.chapter11.model.Counter;
import cn.edu.ncu.quanhao.chapter11.model.DivZeroException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class handle {
    @FXML
    private TextField xTxt;
    @FXML
    private TextField yTxt;
    @FXML
    private TextField resultTxt;
    @FXML
    private ComboBox<String> sign;
    @FXML
    private Button equalBtn;
    @FXML
    public void action(){
        double x = getDoubleValue(xTxt.getText());
        double y =  getDoubleValue(yTxt.getText());
        String countSign  = sign.getSelectionModel().getSelectedItem();
        Counter c = new Counter();
        switch (countSign){
            case "+":resultTxt.setText(String.format("%6.3f",c.add(x,y)));break;
            case "-":resultTxt.setText(String.format("%6.3f",c.sub(x,y)));break;
            case "x":resultTxt.setText(String.format("%6.3f",c.mul(x,y)));break;
            case "÷":try {
                resultTxt.setText(String.format("%6.3f",c.div(x,y)));
            }catch (DivZeroException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("输入了一个错误的参数");
                alert.setContentText(e.toString());
            }
        }
    }
    private double getDoubleValue(String s){
        return Double.valueOf(s);
    }

}
