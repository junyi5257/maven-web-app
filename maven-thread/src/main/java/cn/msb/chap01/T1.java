package cn.msb.chap01;

/**
 * synchronized关键字
 * 对某一对象加锁
 * Created by goujy on 8/1/17.
 */
public class T1 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o) {  //任何线程执行下面的代码，都必须拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count==" + count);
        }
    }


}
