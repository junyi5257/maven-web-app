package cn.junyi.mavenWeb.thread;

/**
 * ThreadDemo
 * Created by goujy on 6/17/17.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        yield(); //暂停当前线程
        System.out.println("=====Mythread=====");
    }
    

}

