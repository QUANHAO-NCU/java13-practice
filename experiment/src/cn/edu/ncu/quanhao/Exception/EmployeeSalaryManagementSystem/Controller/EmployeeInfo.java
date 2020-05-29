package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Controller;

import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Main;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class EmployeeInfo {
    @FXML
    AnchorPane backgroundPane;
    private Employee employee;
    private mainViewAction mainViewAction;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label position;
    @FXML
    private Label salary;

    @FXML
    private void initialize() {
        myInitialize();
    }

    private void myInitialize() {
        this.employee = Main.getEmployee();
        this.mainViewAction = Main.getMainViewAction();
        id.setText(employee.getId());
        name.setText(employee.getName());
        position.setText(employee.getPosition());
        salary.setText("工资：" + employee.getSalary() + "");
    }

    @FXML
    public void changeStyle() {
        backgroundPane.setStyle("-fx-background-color: rgba(246,9,86,0.84)");
    }

    @FXML
    public void styleRecover() {
        backgroundPane.setStyle("-fx-background-color: rgba(51,78,182,0.33)");
    }

    @FXML
    public void changeSalary() {
        Main.insertEmployee(this.employee);
        mainViewAction.changeSalary(this.employee);
    }

}
