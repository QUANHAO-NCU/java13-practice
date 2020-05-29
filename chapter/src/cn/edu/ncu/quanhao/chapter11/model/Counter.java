package cn.edu.ncu.quanhao.chapter11.model;

public class Counter {
    private DivZeroException e;
    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }
    public double div(double x,double y) throws DivZeroException {
        if(y==0){
            throw new DivZeroException(x,y);
        }else return x/y;
    }
}
