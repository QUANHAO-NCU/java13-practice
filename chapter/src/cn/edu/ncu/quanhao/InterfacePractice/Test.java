package cn.edu.ncu.quanhao.InterfacePractice;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
    public static void menu(){
        System.out.println("----------menu----------");
        System.out.println("1.按照姓名进行排序");
        System.out.println("2.按照学号进行排序");
        System.out.println("3.按照生日进行排序");
        System.out.println("4.退出");
    }
    public static void show(Student[] students){
        for(Student student:students){
            System.out.println(student.toString());
        }
    }
    public static void handle(Student[] students){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            menu();
            System.out.println("输入你的选择：");
            choice =sc.nextInt();
            /**
             * 对Comparable接口的compare抽象方法进行重写，
             * 即应用了匿名类的方法
             * */
            switch (choice){
                case 1->Arrays.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                case 2->Arrays.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });
                case 3->Arrays.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                });
                case 4->System.exit(0);
            }show(students);
        }while (true);

    }

    public static void main(String[] args) {
        Student s1 = new Student("6109118148", "张三", 2000, 1, 1);
        Student s2 = new Student("6109118149", "李四", 1999, 2, 2);
        Student s3 = new Student("6109118150", "王五", 1999, 3, 3);
        Student s4 = new Student("6109118151", "马六", 2000, 4, 4);
        Student[] students = {s1, s2, s3, s4};
        handle(students);
    }
}
