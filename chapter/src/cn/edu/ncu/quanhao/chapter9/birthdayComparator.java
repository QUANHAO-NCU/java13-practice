package cn.edu.ncu.quanhao.chapter9;

import java.util.Comparator;
public class birthdayComparator implements Comparator<Student> {
    /**
     * 按照出生日期进行比较
     * */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
