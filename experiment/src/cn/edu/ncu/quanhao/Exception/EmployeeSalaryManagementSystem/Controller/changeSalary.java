package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Controller;

import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.Main;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.Employee;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module.SalaryManagement;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException.SalaryAddTooMore;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException.SalaryCutTooMore;
import cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException.SalaryTooLess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;


public class changeSalary {
    @FXML
    Label id;
    @FXML
    Label name;
    @FXML
    Label position;
    @FXML
    Label currentSalary;
    @FXML
    Button confirm;
    @FXML
    TextField newSalary;
    private mainViewAction mainViewAction;
    private SalaryManagement salaryManagement;
    private Employee employee;

    @FXML
    public void initialize() {
        salaryManagement = Main.getSalaryManagement();
        mainViewAction = Main.getMainViewAction();
        employee = Main.getEmployee();
        id.setText(employee.getId());
        name.setText(employee.getName());
        position.setText(employee.getPosition());
        currentSalary.setText("当前工资：\n" + employee.getSalary());
    }

    @FXML
    private void change() {
        try {
            int salary = Integer.valueOf(newSalary.getText());
            salaryComparator(salary, Integer.valueOf(employee.getSalary()));
            employee.setSalary(salary);
            salaryManagement.updateEmployee(employee);
            mainViewAction.showEmployees();
        } catch (NumberFormatException n) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("输入的内容不对，请重新输入");
            alert.showAndWait();
        } catch (SalaryCutTooMore salaryCutTooMore) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("降薪降太多啦");
            alert.showAndWait();
        } catch (SalaryAddTooMore salaryAddTooMore) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("加薪加太多啦");
            alert.showAndWait();
        } catch (SalaryTooLess salaryTooLess) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("工资太少啦");
            alert.showAndWait();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void salaryComparator(int salary1, int salary2) throws SalaryTooLess, SalaryAddTooMore, SalaryCutTooMore {
        if (salary1 < 2000) {
            throw new SalaryTooLess();
        }
        double factor = Math.abs(salary1 - salary2) / (salary2 * 1.0);
        if ((salary1 - salary2) > 0 && factor > 0.1) {
            throw new SalaryAddTooMore();
        } else if ((salary1 - salary2) < 0 && factor > 0.1) {
            throw new SalaryCutTooMore();
        }
    }
}
