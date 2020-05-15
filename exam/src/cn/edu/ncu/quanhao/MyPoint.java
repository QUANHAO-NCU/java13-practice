package cn.edu.ncu.quanhao;

public class MyPoint {
    /**
     * (1).两个带有get方法的数据域表示它的坐标
     */
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * (2)创建点（0,0）的无参构造方法
     */
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * (3)创建特定坐标的构造方法
     */
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * (4)一个命名为distance方法，返回该点到MyPoint类型指定点之间的距离；
     */
    public double distance(MyPoint position) {
        int distance;
        return Math.sqrt(Math.pow(Double.valueOf(this.x - position.getX()), 2.0) +
                Math.pow(Double.valueOf(this.y - position.getY()), 2.0));
    }

    /**
     *一个命名为distance方法，返回从该点到指定x和y坐标的指定点之间的距离；
     */
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(Double.valueOf(this.x - x), 2.0) +
                Math.pow(Double.valueOf(this.y - y), 2.0));

    }
    public void Test(){
        MyPoint mp = new MyPoint();
        if(mp.getX()==0&&mp.getY()==0){
            System.out.println("测试例1成功！");
        }
        MyPoint mp2 = new MyPoint(3,4);
        if(mp2.getX()==3&&mp2.getY()==4){
            System.out.println("测试例2成功！");
        }
        MyPoint position = new MyPoint(7,8);
        if(mp2.distance(position)==mp2.distance(7,8)){
            System.out.println("测试例3成功！");
        }
    }

    public static void main(String[] args) {
        MyPoint  mp = new MyPoint();
        mp.Test();
    }
}