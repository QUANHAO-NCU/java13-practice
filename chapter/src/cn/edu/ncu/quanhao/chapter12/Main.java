package cn.edu.ncu.quanhao.chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Counter c = new Counter();
        try{
            Scanner scanner = new Scanner(new File("D:\\JAVA\\java13-practice\\chapter\\src\\cn\\edu\\ncu\\quanhao\\chapter12\\data.txt"));
            while (scanner.hasNext()){
                c.formatPrint(scanner.nextInt(),scanner.nextInt());
            }
        }catch (FileNotFoundException f1){
            f1.printStackTrace();
        }

    }
}
