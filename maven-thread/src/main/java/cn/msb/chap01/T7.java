package cn.msb.chap01;

/**
 * 同步方法和非同步方法是否可以同时调用?
 *
 * Created by goujy on 8/1/17.
 */
public class T7 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"m1 start");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1 end");
    }

    public synchronized void m2(){
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m2");
    }

    public static void main(String[] args) {
        final T7 t7 = new T7();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t7.m1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t7.m2();
            }
        }).start();
    }
}
