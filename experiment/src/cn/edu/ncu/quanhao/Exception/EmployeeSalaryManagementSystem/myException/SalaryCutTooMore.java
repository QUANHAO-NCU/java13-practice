package cn.edu.ncu.quanhao.Exception.EmployeeSalaryManagementSystem.myException;

public class SalaryCutTooMore extends Exception {
    String info;

    public SalaryCutTooMore() {
        this.info = "工资减少幅度过多！";
    }
}
