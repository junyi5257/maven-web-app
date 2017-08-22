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
public class T13 {
   //这里使用volatile并不能保证 执行结果为100000，
   volatile   int count = 0;
    //在这里使用 AtomicInteger，可以保证执行10000个(EG:T15)
   final AtomicInteger aciCount =new AtomicInteger(0);
      void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
            aciCount.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T13 t13 = new T13();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t13::m, "thread-" + i));
        }
        threads.forEach((o) -> o.start());
        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.NANOSECONDS.sleep(2);
        System.out.println(t13.count);
        System.out.println(t13.aciCount.get());
    }


}
