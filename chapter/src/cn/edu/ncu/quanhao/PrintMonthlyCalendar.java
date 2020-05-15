package cn.edu.ncu.quanhao;

import java.util.Scanner;

/**
 * 例：根据年份和月份，打印该月份的月历
 *
 * @author：quanhao
 */

public class PrintMonthlyCalendar {
    public static void printHeader() {
        //打印月历表头
        System.out.printf("日\t一\t二\t三\t四\t五\t六\t\n");
    }

    public static boolean isLeap(int year) {
        //判断闰年
        return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0));
    }
    public static int passYearDay(int year){
        //计算在所求年份之前相对于基准时间（1900年1月1日过了多少时间）
        int passDay = 0;
        for(int i = 1900;i<year;i++){
            if(isLeap(i)){
                passDay+=366;continue;
            }
            passDay+=365;
        }
        return passDay;
    }
    public static int passMouthDay(int year, int month) {
        //计算在所求年份的所求月份之前过了多少天
        int passDay = 0;
        for (int i = 1; i < month; i++) {
            passDay += switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 2 -> isLeap(year) ? 29 : 28;
                default -> 30;
            };
        }
        return passDay;
    }
    public static int CalFirstDay(int year,int month){
        //计算所求月份的1号的星期
        int sumDay = passYearDay(year)+passMouthDay(year,month);
        return sumDay%7+1;//sumDay%7得到的是上个月月末的星期，下个月要加一
    }
    public static int theMouthDay(int year,int month){
        //计算当月的总天数
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeap(year) ? 29 : 28;
            default -> 30;
        };
    }
    public static void printMonthlyCalendar(int year,int month){
        //打印月历
        int monthDay = theMouthDay(year,month);
        int weekDay = CalFirstDay(year,month);
        for(int j = 0;j<weekDay%7;j++){
            System.out.print("\t");
        }
        for(int i = 1;i<=monthDay;i++){
            System.out.printf("%d\t",i);
            weekDay++;
            if(weekDay%7==0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
    public static void divideLine(){
        System.out.println("===========================================");
    }
    public static void main(String[] args) {
        int year,month;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入年份：");
        year = sc.nextInt();
        System.out.print("请输入月份:");
        month = sc.nextInt();
        System.out.printf("%d年%d月有%d天，%d月1号是星期%d。\n",year,month,theMouthDay(year,month),month,CalFirstDay(year,month));
        System.out.println("打印月历：");
        divideLine();
        printHeader();
        printMonthlyCalendar(year,month);
        divideLine();
        System.out.println("打印结束！");
        return;
    }
}
