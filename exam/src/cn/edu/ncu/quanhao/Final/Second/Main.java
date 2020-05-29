package cn.edu.ncu.quanhao.Final.Second;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(FileReader fileReader = new FileReader(new File("D:\\JAVA\\java13-practice\\exam\\src\\cn\\edu\\ncu\\quanhao\\Final\\Second\\article.txt"))){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> newContent = new ArrayList<>();
            List<String> deleteWords = new ArrayList<>();
            deleteWords.addAll(Arrays.asList(new String[]{"Rossetti","Stevenson","Lear"}));
            bufferedReader.lines().forEach(e->{
                String[] word = e.split(" ");
                for(String s :word){
                    if(deleteWords.contains(s)) continue;
                    else newContent.add(s);
                    newContent.add(" ");
                }
                newContent.add("\n");
            });
            String outPut = "";
            for(String s:newContent){
                outPut+=s;
            }
            System.out.println(outPut);
            try(FileWriter fileWriter = new FileWriter(new File("D:\\JAVA\\java13-practice\\exam\\src\\cn\\edu\\ncu\\quanhao\\Final\\Second\\article.txt"))){
                newContent.forEach(e->{
                    try {
                        fileWriter.write(e);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
            }catch (IOException i){
                i.printStackTrace();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
