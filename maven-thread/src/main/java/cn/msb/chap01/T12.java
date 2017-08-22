package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字，使一个变量在多个线程中可见
 * A,B两个线程公用一个变量，java 默认是A线程中保留了一份copy,这样如果B线程修改了变量，则A线程未必知道
 * 使用volatile 关键字，会让所有的线程都会读到变量的修改值
 * <p>
 * 在下面的代码中，running 是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running从堆内存【共享】中读取到t1线程的工作区【独享的缓冲区】，在运行过程中直接使用这个copy
 * ，并不会每次都去读取堆内存中，这样在主线程修改running之后，t1线程感知不到，所以不会停止运行。
 * <p>
 * <p>
 * 涉及JAVA内存模型
 * <p>
 * <p>
 * <p>
 * 加volatile 并不是每次都去堆内存中读，而是在共享变量被修改的时候，通知各个线程，你们的缓冲区已经过期了。
 * ？？这句话存在疑问。。
 * <p>
 *     volatile关键字来保证可见性
 * <p>
 * Created by goujy on 8/2/17.
 */
public class T12 {
    volatile  boolean running = true; //对比，如果没有volidate，则无法直接打断(通知)线程

    void m() {
        System.out.println("m==start");
        while (running) {

        }
        System.out.println("m==end");
    }

    public static void main(String[] args) {
        final T12 t12 = new T12();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t12.m();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===我要打断了=");
        t12.running = false;
        System.out.println("===我已经打断了=");
    }

}
