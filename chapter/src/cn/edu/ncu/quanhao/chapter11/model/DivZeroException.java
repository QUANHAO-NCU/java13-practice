package cn.edu.ncu.quanhao.chapter11.model;

public class DivZeroException extends Exception {
    private String info;
    public DivZeroException(){
        this.info = "除零错误";
    }
    public DivZeroException(double x, double y){

        this.info=String.format("%6.3f/%6.3f抛出DivideByZeroException异常,除数不应为0",x,y);

    }

    @Override
    public String toString() {
        return info;
    }
}
