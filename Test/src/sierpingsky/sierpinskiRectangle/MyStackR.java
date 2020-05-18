package sierpingsky.sierpinskiRectangle;

import sierpingsky.Entity.MyRectangle;

public class MyStackR {
    private MyRectangle[] container;
    private int cur=-1;
    public MyStackR(int size){
        if(size<=0)
            return;
        container=new MyRectangle[size];
    }
    public void push(MyRectangle rectangle){
        if(cur+1>container.length){
            System.out.println(("堆栈已满"));
            return;
        }
        container[++cur]=rectangle;
    }
    public MyRectangle pop(){
        if (cur-1<-1){
            System.out.println("堆栈已空，没有元素");
            return null;
        }
        MyRectangle r=container[cur--];
        return r;
    }
    public boolean isEmpty(){
        if (cur<0)
            return true;
        return false;
    }
}
