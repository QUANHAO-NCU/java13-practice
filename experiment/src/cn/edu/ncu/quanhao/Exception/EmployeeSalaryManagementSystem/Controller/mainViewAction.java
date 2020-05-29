package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Controller;

import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Main;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.Employee;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.SalaryManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class mainViewAction {
    private SalaryManagement salaryManagement;
    private AnchorPane changePane;
    private AnchorPane addPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button addBtn;
    @FXML
    private VBox employInfoContainer;
    @FXML
    private Label test;


    @FXML
    public void addEmployee() throws IOException {
        addPane.getChildren().clear();
        AnchorPane addEmployee = FXMLLoader.load(Main.class.getResource("view/addEmployee.fxml"));
        addPane.getChildren().add(addEmployee);
    }

    public void addEmployee(String close) {
        addPane.getChildren().clear();
    }

    @FXML
    void initialize() {
        myInitialize();
    }

    public void myInitialize() {
        changePane = new AnchorPane();
        changePane.setPrefSize(275, 319);
        changePane.setLayoutX(367);
        changePane.setLayoutY(50);
        addPane = new AnchorPane();
        addPane.setPrefSize(229, 206);
        addPane.setLayoutX(687);
        addPane.setLayoutY(69);
        rootPane.getChildren().addAll(changePane, addPane);
        salaryManagement = Main.getSalaryManagement();
        Main.insertControl(this);
        showEmployees();
    }

    public void showEmployees() {
        try {
            employInfoContainer.getChildren().clear();
            List<Employee> l = salaryManagement.getEmployeeList();
            for (int i = 0; i < l.size(); i++) {
                Main.insertEmployee(l.get(i));
                HBox h = FXMLLoader.load(Main.class.getResource("view/EmployInfo.fxml"));
                employInfoContainer.getChildren().add(i, h);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void changeSalary(Employee employee) {
        try {
            changePane.getChildren().clear();
            AnchorPane changeSalary = FXMLLoader.load(Main.class.getResource("view/changeSalary.fxml"));
            changePane.getChildren().add(changeSalary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
