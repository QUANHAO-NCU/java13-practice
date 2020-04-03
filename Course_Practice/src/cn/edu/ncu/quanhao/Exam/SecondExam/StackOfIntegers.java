package cn.edu.ncu.quanhao.Exam.SecondExam;

import java.util.*;
/**
 *
 编程：提示用户输入一个正整数，让后降序显示它的所有的最小因子。

 例如：如果整数为120，那么显示的最小因子为5、3、2、2、2.使用StackOfIntegers类存储最小因子（例如2、2、2、3、5），获取之后按倒序显示这些因子。
 * */
public class StackOfIntegers {
    private List<Integer> result = new ArrayList<Integer>();
    public int value;

    public StackOfIntegers(int value) {
        this.value = value;
        this.getFactor();
    }

    public void getFactor() {
        int num = this.value;
        for (int i = 2; i < this.value; i++) {
            while (num % i == 0) {
                this.result.add(i);
                num /= i;
            }
        }
    }
    public void showFactor(){
        Collections.reverse(this.result);
        for(int i :result){
            System.out.println(i);
        }
    }
    public List<Integer> getResult(){
        return this.result;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner sc =new Scanner(System.in);
        int i = sc.nextInt();
        StackOfIntegers si = new StackOfIntegers(120);
        si.showFactor();
        return;
    }

}
