package cn.junyi.mavenWeb.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器
 * Created by goujy on 7/15/17.
 */
public class MyContainer1 {

    public List list = new ArrayList();

    /**
     * 添加
     */
    public void add(Object o) {
        list.add(o);
    }

    /**
     * 数量
     */
    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        final MyContainer1 myContainer1 = new MyContainer1();
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("监控启动了");
                synchronized (lock) {
                    if (myContainer1.getSize() != 5) {
                        try {
                            lock.wait(); //释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }/* try {
                        TimeUnit.SECONDS.sleep(1); //主线程等一秒，让打开门栓的程序执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println("==被唤醒了，5个了==");
                    lock.notify();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        myContainer1.add(new Object());
                        System.out.println("==ADD=" + i);
                        if (i == 5) {
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();


    }


}
