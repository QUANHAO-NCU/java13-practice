package cn.edu.ncu.quanhao.chapter10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FasterVisitTest {
    private List<Integer> list;

    public long for_Index(List<Integer> list) {
        long t1 =System.nanoTime();
        for (int i = 0; i < list.size(); i++){
            empty(i);
        };
        long t2 =System.nanoTime();
        System.out.print("for_stream:"+(t2 - t1));
        return (t2-t1);
    }

    public long for_each(List<Integer> list) {
        long t1 =System.nanoTime();
        for (Integer i : list){
            empty(i);
        };
        long t2 =System.nanoTime();
        System.out.print("    for_each:"+(t2 - t1));
        return (t2-t1);
    }

    public long for_iterator(List<Integer> list) {
        long t1 =System.nanoTime();
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); it.next()) {
            empty(1);
        }
        long t2 =System.nanoTime();
        System.out.print("    for_iterator:"+(t2 - t1));
        return (t2-t1);
    }

    public long for_stream(List<Integer> list) {
        long t1 =System.nanoTime();
        list.forEach(FasterVisitTest::empty);
        long t2 =System.nanoTime();
        System.out.print("    for_stream:"+(t2 - t1)+"\n");
        return (t2-t1);
    }

    public static void empty(int i) {
        /**
         * 为了适用for_Each 方法而写的空方法
         * */

    }
    public long average(List<Long> list){
        long average ,sum=0;
        for(int i = 0;i<list.size();i++){
            sum+=list.get(i);
        }
        average = sum/100;
        return average;
    }
    public static void main(String[] args) {
        List<Long> for_Index = new ArrayList<Long>(100);
        List<Long> for_each = new ArrayList<Long>(100);
        List<Long> for_iterator = new ArrayList<Long>(100);
        List<Long> for_stream = new ArrayList<Long>(100);
        FasterVisitTest f = new FasterVisitTest();
        for(int j =0;j<100;j++){
            List<Integer> list = new ArrayList<Integer>(10000);
            Random r = new Random();
            for(int i = 0;i<10000;i++){
                list.add(r.nextInt(10001));
            }
            System.out.print("第"+j+"次：  ");
            for_Index.add(f.for_Index(list));
            for_each.add(f.for_each(list));
            for_iterator.add(f.for_iterator(list));
            for_stream.add(f.for_stream(list));
        }
        System.out.println("经过100次不同的随机数列表测试，各个访问方法的均用时为\nfor_Index:"+f.average(for_Index));
        System.out.println("for_each:"+f.average(for_each));
        System.out.println("for_iterator:"+f.average(for_iterator));
        System.out.println("for_stream:"+f.average(for_stream));
    }

}
