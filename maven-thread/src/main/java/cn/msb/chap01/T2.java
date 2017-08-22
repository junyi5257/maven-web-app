package cn.msb.chap01;

/**
 *
 * synchronized关键字   --锁定的为某一对象；
 * ☆☆对某一对象加锁☆☆  【锁的为某一对象】
 * Created by goujy on 8/1/17.
 *
 * msg:专门的创建一个锁对象，消耗内存，可以简化为this.
 *
 */
public class T2 {
    private int count = 10;

    public void m() {
        synchronized (this) { //任何对象执行下面的代码，必须拿到this的锁,
            count--;
            System.out.println(Thread.currentThread().getName() + "count==" + count);
        }
    }

}
