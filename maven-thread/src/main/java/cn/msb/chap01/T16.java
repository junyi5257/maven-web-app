package cn.msb.chap01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized优化
 * synchronized less  will  be  better
 * <p>
 * Created by goujy on 8/12/17.
 */
public class T16 {
    int count = 0;

    synchronized void m1() {
        //do something do not sync
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //need sync
        count++;
        //do something do not need sync
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This Method will be better than m1;
     */
    void m2() {
        //do something do not sync
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //need sync
        //使用细粒度的锁，使线程争用时间变短，提高效率
        synchronized (this) {
            count++;
        }
        //do something do not need sync
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
