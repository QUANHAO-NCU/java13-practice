package cn.edu.ncu.quanhao.char2;
import java.util.Scanner;
public class format_input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input:");
        var contain1 = input.next();//不知道数据类型可以用这种方法接受任意一种数据类型
        var contain2 = input.next();
        var contain3 = input.next();
        var contain4 = input.next();// next 表示获取输入缓冲区的下一个输入，默认输入会被空格截断
        System.out.println("the 1 input is :"+contain1);
        System.out.println("the 2 input is :"+contain2);
        System.out.println("the 3 input is :"+contain3);
        System.out.println("the 4 input is :"+contain4);
    }
}
