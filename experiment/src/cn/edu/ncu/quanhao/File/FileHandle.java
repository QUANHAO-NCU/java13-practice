package cn.edu.ncu.quanhao.File;

import java.io.*;
import java.util.*;

public class FileHandle {
    static int counter = 0;

    public List<Integer> mergeSort(List<Integer> nums, int l, int h) {
        /**
         * 归并排序
         * */
        if (l == h) {
            List<Integer> list = new ArrayList<>();
            list.add(nums.get(l));
            return list;
        }

        int mid = l + (h - l) / 2;
        List<Integer> leftArr = mergeSort(nums, l, mid); //左有序数组
        List<Integer> rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        List<Integer> newNum = new ArrayList<>(); //新有序数组
        int i = 0, j = 0;
        while (i < leftArr.size() && j < rightArr.size()) {
            newNum.add(leftArr.get(i) < rightArr.get(j) ? leftArr.get(i++) : rightArr.get(j++));
        }
        while (i < leftArr.size())
            newNum.add(leftArr.get(i++));
        while (j < rightArr.size())
            newNum.add(rightArr.get(j++));
        return newNum;
    }

    private File generateFile(String fileName, int dataSize) throws IOException {
        counter = 0;
        File file = new File(fileName);
        if (!file.exists()) file.createNewFile();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        random.ints(dataSize, 0, 1000).forEach(list::add);
        try (FileWriter fileWriter = new FileWriter(file)) {

            list.forEach(e -> {
                try {
                    fileWriter.write(e + " ");
                    if (++counter % 2 == 0) {
                        fileWriter.write("\n");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return file;
        }
    }

    public List<Integer> getList(File file) {
        if (!file.exists()) throw new NullPointerException();
        List<Integer> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.lines().forEach(e -> {
                String[] lines = e.split(" ");
                for (String i : lines) {
                    list.add(Integer.valueOf(i));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException n) {
            System.out.print("检查文件中的数据是否全是数字，可以转化为Integer");
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        FileHandle fh = new FileHandle();
        Counter counter = new Counter();
        System.out.println("""
                （1）编程实现，生成两个文件，每个文件的数据是随机生成
                    数据的总数各文件200个
                    要求对两个文件的数据归并排序并在控制台输出。
                """);
        //fh.mergeSort(new int[]{49, 38, 65, 97, 76, 13, 27, 50},0,7);
        List<Integer> list1_1 = fh.getList(fh.generateFile("data1.txt", 100));
        List<Integer> list1_2 = fh.getList(fh.generateFile("data2.txt", 100));

        /**
         * 归并排序
         * */
        System.out.println(fh.mergeSort(list1_1, 0, list1_1.size()-1));
        System.out.println(fh.mergeSort(list1_2, 0, list1_2.size()-1));
        System.out.println("""
                （2）已知空文件data.dat，要求结合java.util.Random生成10组数据
                    计算文件中每行两个整数的加、减、乘、除的运算结果，并将运算结果保存在文件result.txt中。
                """);

        List<Integer> list2_1 = fh.getList(fh.generateFile("data.dat", 20));
        File result = new File("result.txt");
        if (!result.exists()) {
            result.createNewFile();
        }
        try (FileWriter fileWriter = new FileWriter(result)) {
            for (Iterator<Integer> it = list2_1.iterator(); it.hasNext(); ) {
                int i = it.next();
                int j = it.next();
                fileWriter.write(counter.formatWrite(i, j));
                counter.formatPrint(i, j);
            }
        } catch (IOException i) {

        }
    }
}

class Counter extends DivZeroException {
    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) throws DivZeroException {
        if (y == 0) {
            throw new DivZeroException(x, y);
        }
        return x / y;
    }

    public void formatPrint(int x, int y) {
        try {
            System.out.printf("%d+%d=%d \t%d-%d=%d \t%dx%d=%d \t%d/%d=%d\n", x, y, add(x, y), x, y, sub(x, y), x, y, mul(x, y), x, y, div(x, y));
        } catch (DivZeroException d) {
            System.out.printf("%d+%d=%d \t%d-%d=%d \t%dx%d=%d \t%d/%d=%s\n", x, y, add(x, y), x, y, sub(x, y), x, y, mul(x, y), x, y, "没有计算结果");
        }
    }

    public String formatWrite(int x, int y) {
        String s = null;
        try {
            s = String.format("%d+%d=%d \t%d-%d=%d \t%dx%d=%d \t%d/%d=%d\n", x, y, add(x, y), x, y, sub(x, y), x, y, mul(x, y), x, y, div(x, y));
        } catch (DivZeroException d) {
            s = String.format("%d+%d=%d \t%d-%d=%d \t%dx%d=%d \t%d/%d=%s\n", x, y, add(x, y), x, y, sub(x, y), x, y, mul(x, y), x, y, "没有计算结果");
        } finally {
            return s;
        }
    }
}