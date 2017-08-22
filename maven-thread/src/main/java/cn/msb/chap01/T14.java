package cn.msb.chap01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile并不能保证多个线程共同修改Running变量时所带来的不一致性；
 * 也就是说Volatile不能代替Synchronized
 * <p>
 * Created by goujy on 8/12/17.
 */
public class T14 {
    int count = 0;
    // final AtomicInteger aciCount =new AtomicInteger(0);

    //将方法设置为synchronized可以保证 一致性；
    synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
            //      aciCount.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T14 t14 = new T14();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t14::m, "thread-" + i));
        }
        threads.forEach((o) -> o.start());
        threads.forEach((o) -> {
            try {
                o.join(); //在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t14.count);
        // System.out.println(t14.aciCount.get());
    }


}
