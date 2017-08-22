package cn.msb.chap01;

/**
 * 不要以字符串常量作为锁定的对象
 * 在下面的例子中，m1,m2锁定的为同一对象
 * Created by goujy on 8/12/17.
 */
public class T18 {
    String lock =  "Hello";
    String lock2 = "Hel"+new String("lo");
    void m1(){
        synchronized (lock){
            //DO SomeThing
        }
    }

    void m2(){
        synchronized (lock2){
            //Do SomeThing
        }
    }

    public static void main(String[] args) {
        T18 t18 = new T18();
        System.out.println(t18.lock == t18.lock2);
        System.out.println(t18.lock.intern() == t18.lock2.intern());
    }
}
