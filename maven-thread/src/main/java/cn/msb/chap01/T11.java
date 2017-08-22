package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * 出现异常的时候，默认会释放synchronized锁
 * 所以在处理并发编程的时候，有异常要加倍小心，不然可能导致不一致的现象;
 * 在第一个线程抛出异常的时候，其他的线程就会进入同步代码块中，有可能导致访问到异常的数据;
 * 因此要非常小心的处理同步业务中的异常;
 * <p>
 * 建议使用lock锁，然后在final中释放 lock锁,
 * <p>
 * <p>
 * Created by goujy on 8/2/17.
 */
public class T11 {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count:" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;  //此处抛出异常，锁将被释放,可以cache异常，让程序继续;
            }
        }
    }

    public static void main(String[] args) {
         final T11 t11 = new T11();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t11.m();
            }
        };

        new Thread(r,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {t11.m();
            e.printStackTrace();
        }
        new Thread(r,"t2").start();
    }

}
