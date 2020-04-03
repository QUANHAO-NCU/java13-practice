package cn.edu.ncu.quanhao.Exam.SecondExam;

public class MyInteger {
    /**
     * （1）一个名为value的int型数据域，存储这个对象表示的int值；
     */
    private int value;

    /**
     * （2）一个为指定的int值创建的MyInteger对象的构造方法；
     */
    public MyInteger(int value) {
        this.value = value;
    }

    /**
     * （3）一个返回int值的get方法
     */
    public int getValue() {
        return value;
    }

    /**
     * （4）如果值分别为偶数、奇数或素数，那么isEven()、isOdd()和isPrime()方法都会返回true;
     */
    public boolean isEven() {
        return this.value % 2 == 0;
    }

    public boolean isOdd() {
        return !this.isEven();
    }

    public boolean isPrime() {
        for (int i = 2; i < Math.sqrt(this.value); i++) {
            if (this.value % i == 0) return false;
        }
        return true;
    }

    /**
     * （（5）如果指定值分别为偶数、奇数或素数，那么相应的静态方法isEven(int)、
     * isOdd(int)和isPrime(int)会返回true;
     */
    public boolean isEven(int x) {
        return x % 2 == 0;
    }

    public boolean isOdd(int x) {
        return !this.isEven(x);
    }

    public boolean isPrime(int x) {
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    /**
     * （6）如果指定值分别为偶数、奇数或素数，那么相应的静态方法isEven(MyInteger)、
     * isOdd(MyInteger)和isPrime(MyInteger)会返回true;
     */
    public boolean isEven(MyInteger i) {
        return i.value % 2 == 0;
    }

    public boolean isOdd(MyInteger i) {
        return !this.isEven(i.value);
    }

    public boolean isPrime(MyInteger i) {
        for (int j = 2; j < Math.sqrt(i.value); j++) {
            if (i.value % j == 0) return false;
        }
        return true;
    }
    public void Test(){
        MyInteger mi = new MyInteger(17);
        MyInteger test = new MyInteger(15);
        if(mi.value==17)
            if(mi.getValue()==17)
                if(!mi.isEven())
                    if(mi.isOdd())
                        if (mi.isPrime())
                            if(mi.isEven(4))
                                if(mi.isOdd(3))
                                    if(mi.isPrime(11))
                                        if (!mi.isEven(test))
                                            if(mi.isOdd(test))
                                                if(!mi.isPrime(test))
                                                    System.out.println("测试成功！");
    }

    public static void main(String[] args) {
        MyInteger mi = new MyInteger(0);
        mi.Test();
    }
}
