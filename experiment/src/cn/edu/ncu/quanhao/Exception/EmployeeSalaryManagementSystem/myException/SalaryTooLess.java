package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException;

public class SalaryTooLess extends Exception {
    String info;

    public SalaryTooLess() {
        this.info = "工资太少！";
    }
}
