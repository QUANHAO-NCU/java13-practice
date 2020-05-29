package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem;

import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Controller.mainViewAction;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.Employee;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.SalaryManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main extends Application {
    private static SalaryManagement salaryManagement;
    private static final Stack<Employee> employees = new Stack<>();
    private static final List<mainViewAction> controls = new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static mainViewAction getMainViewAction() {
        return controls.get(0);
    }

    public static void insertControl(mainViewAction object) {
        controls.add(object);
    }

    public static Employee getEmployee() {
        return employees.pop();
    }

    public static SalaryManagement getSalaryManagement() {
        return salaryManagement;
    }

    public static void insertEmployee(Employee employee) {
        employees.push(employee);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        salaryManagement = new SalaryManagement();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("view/mainView.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setTitle("员工薪水管理系统");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
