package cn.msb.chap01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 同样可以处理简单的++操作；
 * Created by goujy on 8/12/17.
 */
public class T15 {
    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T15 t15 = new T15();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t15.m();
                }
            }, "Thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();// MakeSure Threads->o complete  before Main Thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t15.count.get());
    }
}
