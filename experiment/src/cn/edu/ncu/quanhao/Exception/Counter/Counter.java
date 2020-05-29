package cn.edu.ncu.quanhao.Exception.Counter;

public class Counter extends DivZeroException {
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

    public void formatPrint(int x,int y){
        try{
            System.out.printf("%d+%d=%d %d-%d=%d %dx%d=%d %d/%d=%d\n",x,y,add(x,y),x,y,sub(x,y),x,y,mul(x,y),x,y,div(x,y));
        }catch (DivZeroException d){
            System.out.printf("%d+%d=%d %d-%d=%d %dx%d=%d %d/%d=%s\n",x,y,add(x,y),x,y,sub(x,y),x,y,mul(x,y),x,y,"没有计算结果");
        }
    }
}
