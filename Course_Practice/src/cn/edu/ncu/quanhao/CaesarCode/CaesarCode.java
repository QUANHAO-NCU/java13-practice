package cn.edu.ncu.quanhao.CaesarCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCode {
    /**
     * 加密
     */
    public char encryption(char c, int code) {
        if (c >= 65 && c <= 90) {
            //大写字母
            c = (char) ('A' + (c - 'A' + code) % 26);
        }
        if (c >= 'a' && c <= 'z') {
            //小写字母
            c = (char) ('a' + (c - 'a' + code) % 26);
        }
        return c;//其他字符保留不变
    }

    /**
     * 解密
     */
    public char decrypt(char c, int code) {
        if (c >= 65 && c <= 90) {
            //大写字母
            c = (char) ('A' + (c - 'A' - code) % 26);
        }
        if (c >= 'a' && c <= 'z') {
            //小写字母
            c = (char) ('a' + (c - 'a' - code) % 26);
        }
        return c;//其他字符保留不变
    }

    public static void main(String[] args) throws FileNotFoundException {
        CaesarCode cc = new CaesarCode();
        try {
            StringBuffer s = new StringBuffer();
            FileReader fr = new FileReader("D:\\java13-practice\\Course_Practice\\src\\cn\\edu\\ncu\\quanhao\\CaesarCode\\article1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                s.append(line);
                s.append('\n');
                line = br.readLine();
            }
            String article = s.toString();//文章加载到字符串中
            Scanner sc = new Scanner(System.in);
            System.out.println("输入要加密的密码：");
            int code = sc.nextInt();
            String[] result = article.split("");
            String encryptionArticle = "";
            for (int i = 0; i < result.length; i++) {

                encryptionArticle += cc.encryption(result[i].charAt(0), code);
            }
            System.out.println(encryptionArticle);

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
