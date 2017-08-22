package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * 子类同步方法，可以调用父类同步方法
 * Created by goujy on 8/1/17.
 */
public class T10 {
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "==m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "==m end");
    }

    public static void main(String[] args) {
        new T10San().m();
    }

}

class T10San extends T10 {

    @Override
    synchronized void m() {
        System.out.println("child == n == start");
        super.m();
        System.out.println("child == n ==  ned");
    }
}
