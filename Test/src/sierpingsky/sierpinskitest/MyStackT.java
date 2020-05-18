package sierpingsky.sierpinskitest;

import sierpingsky.Entity.MyTriangle;

public class MyStackT {
    private MyTriangle[] container;
    private int cur=-1;
    public MyStackT(int size){
        if(size<=0)
            return;
        container=new MyTriangle[size];
    }
    public void push(MyTriangle triangle){
        if(cur+1>container.length){
            System.out.println(("堆栈已满"));
            return;
        }
        container[++cur]=triangle;
    }
    public MyTriangle pop(){
        if (cur-1<-1){
            System.out.println("堆栈已空，没有元素");
            return null;
        }
        MyTriangle t=container[cur--];
        return t;
    }
    public boolean isEmpty(){
        if (cur<0)
            return true;
        return false;
    }

}
