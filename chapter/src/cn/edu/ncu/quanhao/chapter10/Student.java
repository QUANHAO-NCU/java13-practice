package cn.edu.ncu.quanhao.chapter10;

import java.time.LocalDate;
import java.util.Objects;


public class Student implements Comparable<Student> {

    private String id;

    private String name;

    private String gender;

    private String classID;

    private LocalDate birthday;


    Student() {

    }


    public Student(String id, String name, String gender, String classID, int year, int month, int day) {

        this.id = id;

        this.name = name;

        this.gender = gender;

        this.classID = classID;

        this.birthday = LocalDate.of(year, month, day);

    }


    public void setId(String id) {

        this.id = id;

    }


    public void setName(String name) {

        this.name = name;

    }


    public void setGender(String gender) {

        this.gender = gender;

    }


    public void setClassID(String classID) {

        this.classID = classID;

    }


    public void setBirthday(int year, int month, int day) {

        this.birthday = LocalDate.of(year, month, day);

    }


    public String getId() {

        return id;

    }


    public String getName() {

        return name;

    }


    public String getGender() {

        return gender;

    }


    public String getClassID() {

        return classID;

    }


    public LocalDate getBirthday() {

        return birthday;

    }


    @Override

    public String toString() {

        return "Student{" +

                "学号='" + id + '\'' +

                ", 姓名='" + name + '\'' +

                ", 性别='" + gender + '\'' +

                ", 班级='" + classID + '\'' +

                ", 生日=" + birthday.getYear() + "-" + birthday.getMonthValue() + "-" + birthday.getDayOfMonth() +

                '}';

    }


    @Override

    public boolean equals(Object o) {

        //学号唯一性

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Objects.equals(id, student.id);

    }


    @Override

    public int hashCode() {

        //学号唯一性

        return Objects.hash(id);

    }


    public void setBirthday(LocalDate birthday) {

        this.birthday = birthday;

    }


    @Override

    public int compareTo(Student o) {

        return id.compareTo(o.getId());

    }

}

