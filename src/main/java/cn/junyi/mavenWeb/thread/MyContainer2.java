package cn.junyi.mavenWeb.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by goujy on 7/15/17.
 */
public class MyContainer2 {
    public volatile  List container = new ArrayList();

    // public final static Lock lockReader = new ReentrantLock();
    // public final static Lock lockAdd = new ReentrantLock();


    public void addObj(Object o) {
        container.add(o);
    }

    public int getSize() {
        return container.size();
    }

    public static void main(String[] args) {
        final MyContainer2 myContainer2 = new MyContainer2();
        final CountDownLatch latch = new CountDownLatch(1);
        //通知线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("==监控启动==");
                if (myContainer2.getSize() != 5) {
                    try {
                        //门栓等待
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //门闩被打开了
                    System.out.println("=5个了==");
                }
            }
        }).start();

        //添加线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    myContainer2.addObj(new Object());
                    System.out.println("--add-" + i);
                    if (i == 5) {
                        latch.countDown();
                        //门栓数减一【由于设置为门栓数1，所以减一直接打开了】
                        try {
                            TimeUnit.SECONDS.NANOSECONDS.sleep(10); //主线程等一秒，让打开门栓的程序执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();
    }
}
