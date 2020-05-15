package cn.edu.ncu.quanhao.chapter10;

/**
 * 不想优化代码了，将就着看吧
 */

import java.time.LocalDate;
import java.util.Arrays;

import java.util.Iterator;

import java.util.Scanner;

import java.util.TreeSet;


public class StudentManSys {

    private TreeSet<Student> studentSet = new TreeSet<>();


    StudentManSys() {

        //自动建树集

        Student[] students = new Student[]{

                new Student("10000", "张三", "male", "185", 1999, 1, 1),

                new Student("10001", "李四", "female", "185", 2000, 2, 2),

                new Student("10002", "王五", "male", "185", 1999, 3, 3),

                new Student("10003", "马六", "female", "185", 2000, 7, 7),

                new Student("10004", "赵七", "male", "185", 1999, 6, 6)

        };

        studentSet.addAll(Arrays.asList(students));

    }


    StudentManSys(Student[] students) {

        //根据传入的数组创建对应的树集

        studentSet.addAll(Arrays.asList(students));

    }


    private void menu() {

        System.out.println("""

                1.新增学生信息

                2.删除学生信息

                3.显示某班级的学生信息

                4.显示所有学生的信息

                5.对某班级学生按照姓名升序排序

                6.对某班级学生按照姓名降序排序

                7.对某班级学生按照学号升序排序

                8.对某班级学生按照学号降序排序

                9.对某班级学生按照年龄升序排序

                10.对某班级学生按照年龄降序排序

                11.退出

                输入要执行的操作>>>

                """

        );

    }


    private void disPlayStudent(Student student) {

        System.out.println(student.toString());

    }


    private void disPlayStudent() {

        Student student = new Student();

        for (Iterator<Student> it = studentSet.iterator(); it.hasNext(); ) {

            student = it.next();

            disPlayStudent(student);

        }

    }

    private void disPlayStudent(TreeSet<Student> students) {

        Student student = new Student();

        for (Iterator<Student> it = students.iterator(); it.hasNext(); ) {

            student = it.next();

            disPlayStudent(student);

        }

    }

    private void disPlayStudent(String classID) {

        Student student = new Student();

        for (Iterator<Student> it = studentSet.iterator(); it.hasNext(); ) {

            student = it.next();

            if (student.getClassID().equals(classID)) {

                disPlayStudent(student);

            }

        }

    }


    public void addStudent(Student student) {

        if (student != null) {

            studentSet.add(student);

            System.out.println("学生添加成功！");

        }

    }


    public void deleteStudent(Student student) {

        if (studentSet.contains(student)) {

            studentSet.remove(student);

            System.out.println("学生删除成功！");

        }

    }


    public Student find(Student student) {

        if (studentSet.contains(student)) {

            for (Iterator<Student> it = studentSet.iterator(); it.hasNext(); ) {

                Student s;

                s = it.next();//这个比较只比较学号

                if (s.equals(student)) {

                    student = s;

                    System.out.println("已找到学生：");

                    disPlayStudent(student);

                    break;

                }

            }

        }

        return student;

    }


    private Student creatStudentModel(int type) {

        Student student = new Student();

        Scanner scanner = new Scanner(System.in);

        if (type == 0) {

            System.out.println("""

                    输入这名学生的

                    学号      姓名      性别      班别      出生 年  月  日:

                    """);

            student.setId(scanner.next());

            student.setName(scanner.next());

            student.setGender(scanner.next());

            student.setClassID(scanner.next());

            student.setBirthday(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        } else {

            System.out.println("""

                    输入这名学生的

                    学号:

                    """);

            student.setId(scanner.next());

            student.setName(null);

            student.setGender(null);

            student.setClassID(null);

            student.setBirthday(LocalDate.now());

        }

        return student;

    }


    private TreeSet<Student> getStudentSetByClass(String classID) {

        TreeSet<Student> students = new TreeSet<>();

        Student student = new Student();

        for (Iterator<Student> it = studentSet.iterator(); it.hasNext(); ) {

            student = it.next();

            if (student.getClassID().equals(classID)) {

                students.add(student);

            }

        }

        return students;

    }


    public TreeSet<Student> sortStudent(TreeSet<Student> students, int model, int direction) {

        //direction 0 3

        switch (model + direction) {

            case 5:

                TreeSet<Student> studentsSortedN = new TreeSet<Student>(((o1, o2) -> {

                    return o1.getName().compareTo(o2.getName());

                }));

                studentsSortedN.addAll(students);

                return studentsSortedN;

            case 6:

                TreeSet<Student> studentsSortedI = new TreeSet<Student>(((o1, o2) -> {

                    return o1.getId().compareTo(o2.getId());

                }));

                studentsSortedI.addAll(students);

                return studentsSortedI;

            case 7:

                TreeSet<Student> studentsSortedB = new TreeSet<Student>(((o1, o2) -> {

                    return o1.getBirthday().compareTo(o2.getBirthday());

                }));

                studentsSortedB.addAll(students);

                return studentsSortedB;

            case 8:

                TreeSet<Student> studentsSortedNR = new TreeSet<Student>(((o1, o2) -> {

                    return o2.getName().compareTo(o1.getName());

                }));

                studentsSortedNR.addAll(students);

                return studentsSortedNR;

            case 9:

                TreeSet<Student> studentsSortedIR = new TreeSet<Student>(((o1, o2) -> {

                    return o2.getId().compareTo(o1.getId());

                }));

                studentsSortedIR.addAll(students);

                return studentsSortedIR;

            case 10:

                TreeSet<Student> studentsSortedBR = new TreeSet<Student>(((o1, o2) -> {

                    return o2.getBirthday().compareTo(o1.getBirthday());

                }));

                studentsSortedBR.addAll(students);

                return studentsSortedBR;

        }

        return null;

    }


    public void handle() {


        Scanner scanner = new Scanner(System.in);

        String c = null;

        do {

            menu();

            c = scanner.next();

            switch (c) {

                case "1":

                    addStudent(creatStudentModel(0));

                    break;

                case "2":

                    deleteStudent(find(creatStudentModel(1)));

                    break;

                case "3":

                    System.out.println("输入要查询的班级：");

                    disPlayStudent(scanner.next());

                    break;

                case "4":

                    disPlayStudent();

                    break;

                case "5":

                    System.out.println("输入要查询的班级以：");

                    disPlayStudent(sortStudent(getStudentSetByClass(scanner.next()), 5, 0));

                    break;

                case "6":

                    System.out.println("输入要查询的班级：");

                    disPlayStudent(sortStudent(getStudentSetByClass(scanner.next()), 5, 3));

                    break;

                case "7":

                    System.out.println("输入要查询的班级：");

                    disPlayStudent(sortStudent(getStudentSetByClass(scanner.next()), 6, 0));

                    break;

                case "8":

                    System.out.println("输入要查询的班级：");

                    disPlayStudent(sortStudent(getStudentSetByClass(scanner.next()), 6, 3));

                    break;

                case "9":

                    System.out.println("输入要查询的班级：");

                    disPlayStudent(sortStudent(getStudentSetByClass(scanner.next()), 7, 0));

                    break;

                case "10":

                    System.out.println("输入要查询的班级：");

                    disPlayStudent(sortStudent(getStudentSetByClass(scanner.next()), 7, 3));
                case "11":
                    System.exit(0);
            }

        } while (true);
    }
}

