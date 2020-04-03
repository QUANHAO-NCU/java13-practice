package cn.edu.ncu.quanhao.char2;
import java.util.Arrays;
import java.util.Scanner;

public class PrintStudentInfomation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要录入信息的学生个数：");
        int studentNum = sc.nextInt();
        Student[] students = new Student[studentNum];
        for(int i = 0;i<studentNum;i++){
            students[i] = new Student();//建立实例
            System.out.println("现在输入第"+(i+1)+"个学生的姓名：");
            students[i].setName(sc.next());
            System.out.println(students[i].name+"的学号是：");
            students[i].setStudentID(sc.next());
            System.out.println(students[i].name+"的年龄是：");
            students[i].setAge(sc.nextInt());
            System.out.println(students[i].name+"的成绩是：");
            students[i].setScore(sc.nextInt());
        }
        Arrays.sort(students);
        for(int i = 0;i<students.length;i++){
            System.out.println("学生："+students[i].name+
                    "\n学号："+students[i].studentID+
                    "\n年龄："+students[i].age +
                    "\n成绩："+students[i].score);
        }
    }
}
