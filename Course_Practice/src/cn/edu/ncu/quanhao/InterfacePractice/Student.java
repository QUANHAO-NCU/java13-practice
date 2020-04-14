package cn.edu.ncu.quanhao.InterfacePractice;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private LocalDate birthday;

    public Student() {
    }

    public Student(String id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Student(String id, String name, int year, int month, int day) {
        this.id = id;
        this.name = name;
        this.birthday = LocalDate.of(year, month, day);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }
    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }

    /**
     * 重写toString方法
     */
    @Override
    public String toString() {
        return "学生{" +
                "学号='" + id + '\'' +
                ", 姓名='" + name + '\'' +
                ", 生日=" + birthday +
                '}';
    }
}
