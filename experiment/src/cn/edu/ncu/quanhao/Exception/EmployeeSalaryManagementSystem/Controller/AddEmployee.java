package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Controller;

import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Main;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.Employee;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.SalaryManagement;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException.SalaryTooLess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddEmployee {
    @FXML
    TextField id;
    @FXML
    TextField name;
    @FXML
    TextField position;
    @FXML
    TextField salary;
    @FXML
    Button addBtn;
    private Employee employee;
    private mainViewAction mainViewAction;
    private SalaryManagement salaryManagement;

    @FXML
    public void addEmployee() throws SQLException, SalaryTooLess {
        int salaryI;
        try {
            salaryManagement = Main.getSalaryManagement();
            mainViewAction = Main.getMainViewAction();
            salaryI = Integer.valueOf(salary.getText());
            if (salaryI < 2000) throw new SalaryTooLess();
            employee = new Employee(id.getText(), name.getText(), salaryI, position.getText());
            if (salaryManagement.addEmployee(employee)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("员工添加成功");
                alert.showAndWait();
                mainViewAction.showEmployees();
                mainViewAction.addEmployee("close");
            }
        } catch (NumberFormatException n) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("输入的工资应该是整数");
            alert.showAndWait();
        } catch (SalaryTooLess e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("工资太少啦");
            alert.showAndWait();
        }

    }
}
