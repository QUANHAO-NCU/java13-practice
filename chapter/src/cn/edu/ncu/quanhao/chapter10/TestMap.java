package cn.edu.ncu.quanhao.chapter10;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.*;



public class TestMap {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src\\cn\\edu\\ncu\\quanhao\\chapter10\\article.txt"));

        Map<String, Integer> map = new HashMap<>();

        String[] marks = new String[]{",", ".", "?", "!"};

        List<String> marksList = Arrays.asList(marks);

        while (scanner.hasNext()) {

            String word = scanner.next();

            if (marksList.contains(word)) continue;//标点符号不统计

            else {

                if (!map.containsKey(word)) {

                    map.put(word, 1);

                } else {

                    map.put(word, map.get(word) + 1);

                }

            }

        }

        Set<Map.Entry<String, Integer>> set = map.entrySet();

        List<Map.Entry<String,Integer>> resultList = new ArrayList<>();

        resultList.addAll(set);

        resultList.sort((o1,o2)->{return o1.getValue()-o2.getValue();});

        for (Iterator<Map.Entry<String, Integer>> it = resultList.iterator(); it.hasNext(); ) {

            Map.Entry<String, Integer> entry = it.next();

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

    }

}