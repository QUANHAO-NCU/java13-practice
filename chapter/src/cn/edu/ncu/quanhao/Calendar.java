package cn.edu.ncu.quanhao;

import java.util.Scanner;

/**
 * 例：根据年份和月份，获得指定年月的总天数
 *
 * @author：quanhao
 */
public class Calendar {
    public static boolean isLeap(int year) {
        //判断闰年
        return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0));
    }

    public static int getDays(int year, int mouth) {
        int day = switch (mouth) {
            case 1, 3, 5, 7, 8, 10, 12 ->31;
            case 2 ->isLeap(year) ? 29 : 28;
            case 4,6,9,11 -> 30;
            default -> 0;//月份非法天数为0
        };
        return day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        System.out.println("请输入月份：");
        int mouth = sc.nextInt();
        int days = Calendar.getDays(year, mouth);
        System.out.printf("%d年的%d月有%d天", year, mouth, days);
    }
}
