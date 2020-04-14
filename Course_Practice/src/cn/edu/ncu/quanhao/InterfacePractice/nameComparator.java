package cn.edu.ncu.quanhao.InterfacePractice;

import java.util.Comparator;

public class nameComparator implements Comparator<Student> {
    /**
     * 按照姓名进行比较
     * */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
