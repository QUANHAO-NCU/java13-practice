package cn.edu.ncu.quanhao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InitialCapital {
    public static String capitalized(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static void printWords(String[] words) {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s ", words[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            StringBuffer s = new StringBuffer();
            String fileName = "D:\\java13-practice\\Course_Practice\\src\\article.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fr);
            String line = bufferedReader.readLine();
            while (line != null) {
                s.append(line);
                line = bufferedReader.readLine();
            }
            String content = s.toString();
            /**
             *由于给出的article句于句之间的分隔并不固定
             * 有的是.号后仅一个空格，有的跟了两个空格，所以采用两次正则化
             * */
            String[] result = content.split("\\.");
            for (int i = 0; i < result.length; i++) {
                int first = 0;
                String[] tempArrays = result[i].split(" ");
                while (first < tempArrays.length) {
                    //只有比对hashCode才能判断是否相同
                    //寻找正确的首字母
                    if (tempArrays[first].hashCode() != "".hashCode()) break;
                    first++;
                }
                tempArrays[first] = capitalized(tempArrays[first]);
                String temp = new String("");
                for (int j = first; j < tempArrays.length; j++) {
                    temp += tempArrays[j];
                    if (j == tempArrays.length - 1) break;
                    temp += " ";
                }
                temp += ".\n";
                result[i] = temp;//拼接句子
            }
            printWords(result);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
