package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * 对写的加锁，
 * 对读取不加锁
 * 容易出现脏读（dirty Read）现象
 *
 * 由于读取的方法中，没有synchronized，可能会出现脏读现象，不一致；
 * 读取加锁，保证了一致性，但是会带来性能的下降;
 *
 * Created by goujy on 8/1/17.
 */
public class T8Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;  //假定这里有业务代码，延迟2s钟
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    /**
     * 由于读取的方法中，没有synchronized，可能会出现脏读现象，不一致；
     * 读取加锁，保证了一致性，但是会带来性能的下降;
     * @return
     */
    public double read() {
        return balance;
    }

    public static void main(String[] args) {
        final T8Account account = new T8Account();
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.set("张三", 100.0f);
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.read());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.read());

    }
}
