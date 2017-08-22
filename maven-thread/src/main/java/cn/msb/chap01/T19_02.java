package cn.msb.chap01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 添加 volatile 使线程可见
 * Created by goujy on 8/12/17.
 */
public class T19_02<E> {
    volatile List<E> list = new ArrayList();

    public void add(E e) {
        System.out.println("=====add=One===");
        list.add(e);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        T19_02<Object> t19_02 = new T19_02<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    t19_02.add(new Object());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread1--").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (t19_02.getSize() == 5) {
                        break;
                    }
                }
                System.out.println("t2---end");
            }
        }, "Thread2--").start();
    }
}
