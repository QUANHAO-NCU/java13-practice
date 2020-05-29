package cn.edu.ncu.quanhao.Final;

public interface Movable {
    static void myFunc(){
    /**静态方法*/
    }
    private void a(String name) {
        /**私有方法*/
        System.out.println(name+"private");
    }
    default void move(String direction) {
        /**非抽象方法*/
        a("private Func");
        System.out.println(direction);

    }
}
