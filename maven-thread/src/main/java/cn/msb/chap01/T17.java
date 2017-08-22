package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o,如果o的属性改变，并不会影响锁的使用；
 * 但是如果o变成另外的对象，则锁的对象发生改变
 * 应当避免将锁的对象的引用变成另外的对象
 * <p>
 * so,锁的不是栈内存(stack)中的引用，而是堆内存（heap）中new Object()对象；
 * <p>
 * Created by goujy on 8/12/17.
 */
public class T17 {
    Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T17 t17 = new T17();
        new Thread(t17::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(t17::m, "t2");
        t17.o = new Object();
        t2.start();
    }
}
