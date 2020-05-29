package cn.edu.ncu.quanhao.Final.first;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(FileReader fileReader = new FileReader(new File("D:\\JAVA\\java13-practice\\exam\\src\\cn\\edu\\ncu\\quanhao\\Final\\first\\grade.cvs"))){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<Student> list = new ArrayList<>();
            bufferedReader.readLine();//跳过第一行
            bufferedReader.lines().forEach(e->{
                String[] m = e.split(",");
                list.add(new Student(m[0],m[1],Integer.valueOf(m[2])));
            });
            list.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));
            Collections.sort(list);
            for(int i = 0;i<5;i++){
                System.out.println(list.get(i).toString());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
