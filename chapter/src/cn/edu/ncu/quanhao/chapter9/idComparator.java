package cn.edu.ncu.quanhao.chapter9;

import java.util.Comparator;

public class idComparator implements Comparator<Student> {
    /**
     * 按照学号进行比较
     * */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
