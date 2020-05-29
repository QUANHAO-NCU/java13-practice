package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException;

public class SalaryAddTooMore extends Exception {
    String info;

    public SalaryAddTooMore() {
        this.info = "工资增长幅度过多！";
    }
}
