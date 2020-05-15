package cn.edu.ncu.quanhao.chapter11.model;

public class DivZeroException extends Exception {
    private String info = "除数不应为0";

    @Override
    public String toString() {
        return info;
    }
}
