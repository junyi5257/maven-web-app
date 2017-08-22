package cn.msb.chap01;

/**
 * msg：synchronized 锁定 在 static 方法上 。
 * 等价于cn.msb.chap01.T4.class
 * 即锁定的为class对象【完整的包名+类名称】
 * Created by goujy on 8/1/17.
 */
public class T4 {
    private static int count = 10;

    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void mm() {
        synchronized (T4.class) {
            count--;
        }
    }
}
