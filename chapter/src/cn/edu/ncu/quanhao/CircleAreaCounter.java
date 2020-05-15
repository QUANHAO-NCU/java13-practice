package cn.edu.ncu.quanhao;
import java.util.Scanner;
import static java.lang.StrictMath.PI;
public class CircleAreaCounter {
    public static void main(String[] args){
        System.out.println("请输入圆的半径：");
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double areas = radius*radius*PI;
        System.out.println("圆的半径是"+radius+"\n圆的面积是"+areas);
    }
}
