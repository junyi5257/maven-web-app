package cn.msb.chap01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，提供两个方法，add和size
 * 写两个线程，线程1添加10个元素到容器中，
 * 线程2实现监控元素个数，当添加5个时，线程2给出提示并结束t2
 * <p>
 * 分析下面程序，看看是不是能实现?
 * (A:NO)
 * Created by goujy on 8/12/17.
 */
public class T19_01<E> {
   /*volatile*/ List<E> list = new ArrayList();

    public void add(E e) {
        System.out.println("=====add=One===");
        list.add(e);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        T19_01<Object> t19_01 = new T19_01<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    t19_01.add(new Object());
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
                    if (t19_01.getSize() == 5) {
                        break;
                    }
                }
                System.out.println("t2---end");
            }
        }, "Thread2--").start();
    }
}
