package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * 如何模拟死锁
 * Created by goujy on 8/1/17.
 */
public class T9DeadLock {
    Object lock1 = new Object();
    Object lock2 = new Object();
    void m1  (){
        synchronized (lock1){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("==m1==");
            m2();
        }
    }

    void m2(){
        synchronized (lock2){
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===m2====");
            m1();
        }
    }

    public static void main(String[] args) {
        final T9DeadLock test = new T9DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.m2();
            }
        }).start();
    }
}
