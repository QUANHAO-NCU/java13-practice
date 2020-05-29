package cn.edu.ncu.quanhao.File;

public class DivZeroException extends ArithmeticException{
    private String info;

    public DivZeroException(){
        this.info = "除零错误";
    }
    public DivZeroException(double x, double y){

        this.info=String.format("%6.3f/%6.3f抛出DivideByZeroException异常",x,y);

    }
}
