package cn.edu.ncu.quanhao;

import java.util.Arrays;

public class BinaryMultiplication {
    public int[] multipy(int[] one, int[] two) {
        int[] result = new int[one.length + two.length];
        int[] temp = new int[result.length];
        int pos = two.length - 1;
        for (int i = two.length-1; i >= 0; i--) {
            if (two[i] == 1) {
                shift(one, pos, temp);
                add(temp, result);
                Arrays.fill(temp, 0);
            }
            pos++;
        }
        return result;
    }

    private void add(int[] temp, int[] result) {
        for (int i = 0; i < temp.length; i++) {
            result[i] += temp[i];
            if (result[i] >= 2) {
                result[i] = result[i] % 2;
                result[i + 1]++;
            }
        }
    }

    public void shift(int[] one, int pos, int[] result) {
        for (int i = one.length-1; i >= 0; i--) {
            result[pos] = one[i];
            pos--;
        }
    }

    public String convertInt(int[] ints) {
        StringBuilder builder = new StringBuilder();
        int pos = ints.length-1;
        for(;ints[pos]==0;pos--);
        for(;pos>=0;pos--){
            builder.append(ints[pos]);
        }return builder.toString();
    }

    public static void main(String[] args) {
        int[] one ={0,1,1,1,0,0,1};
        int[] two ={1,0,1,1,1,0,1};
        BinaryMultiplication bm = new BinaryMultiplication();
        int[] result = bm.multipy(one,two);
        System.out.println("\n运算结果"+Arrays.toString(result));
        String lastResult = bm.convertInt(result);
        System.out.println(lastResult);
    }
}
