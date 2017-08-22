package cn.msb.chap01;

/**
 * synchronized关键字  互斥锁
 * ☆☆对某一对象加锁☆☆  【锁的为某一对象】
 * Created by goujy on 8/1/17.
 * <p>
 * msg:如果一段代码，在开始的时候就锁定this,在结束的时候才释放锁。可以简写为在
 * <spe>方法上使用synchronized<spe/>
 */
public class T3 {
    private int count = 10;

    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count==" + count);
    }
}
