package cn.edu.ncu.quanhao;

import java.util.Date;

public class format_print {
    public static void main(String[] args) {
        int codePoint = 0x1D307;
        String s = Character.toString(codePoint);
        System.out.printf("%20s\n",s);
        System.out.printf("%18s%4s\n",s,s);
        System.out.printf("%16s%s%s%s%s\n",s,s,s,s,s);
        System.out.printf("%14s%10s\n",s,s);
        System.out.printf("%12s%14s\n",s,s);
        printTime();

    }
    public static void printTime(){
        Date date = new Date();
        System.out.printf("%tY年%tm月%td日 %tp %tl:%tM:%tS",date,date,date,date,date,date,date);
    }
}
