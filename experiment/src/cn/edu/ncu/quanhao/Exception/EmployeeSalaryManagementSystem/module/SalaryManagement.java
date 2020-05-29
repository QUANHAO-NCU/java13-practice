package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.module;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryManagement {

    private Connection conn;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/employeesalary?serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
    private final String user = "root";
    private final String password = "123456";
    private final List<Employee> employeeList = new ArrayList<>();
    private Statement statement;

    public SalaryManagement() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        try {
            String sql = "update salary set position ='" + employee.getPosition() +
                    "',salary=" + employee.getSalary() +
                    "  where id='" + employee.getId() +
                    "' and name ='" + employee.getName() +
                    "'";
            statement.executeUpdate(sql);
            return true;
        } catch (Exception c) {
            c.printStackTrace();
        }
        return false;
    }

    public boolean addEmployee(Employee employee) throws SQLException {
        try {
            String sql = "insert into salary values('" + employee.getId() +
                    "','" + employee.getName() +
                    "'," + employee.getSalary() +
                    ",'" + employee.getPosition() +
                    "')";
            statement.executeUpdate(sql);
            return true;
        } catch (Exception c) {
            c.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(Employee employee) {
        try {
            String sql = "delete from salary where id = '" + employee.getId() +
                    "'";
            statement.executeUpdate(sql);
            return true;
        } catch (Exception c) {
            c.printStackTrace();
        }
        return false;
    }

    public List<Employee> getEmployeeList() throws SQLException {
        if (!employeeList.isEmpty()) {
            employeeList.clear();
        }
        try {
            String sql = "select * from salary";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                int salary = rs.getInt("salary");
                Employee e = new Employee(id, name, salary, position);
                employeeList.add(e);
            }
        } catch (Exception c) {
            c.printStackTrace();
        }
        return employeeList;
    }

}