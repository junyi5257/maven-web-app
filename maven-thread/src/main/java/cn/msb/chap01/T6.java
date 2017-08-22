package cn.msb.chap01;

/**
 * 分析下输出--在run上加锁
 * Created by goujy on 8/1/17.
 * Q1,?休息纳秒
 * Q2,会出现结果不是98765 现象
 * 方法1：可以在run 方法上加锁【synchronized】锁
 *
 *
 */
public class T6 implements Runnable {
    private int count = 10;


    @Override
    public synchronized void run() {
        count--;

        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void main(String[] args) {
        T6 t6 = new T6();
        for (int i = 0; i < 5; i++) {
            new Thread(t6).start();  //TODO 这里可以考虑线程池
        }
    }
}
