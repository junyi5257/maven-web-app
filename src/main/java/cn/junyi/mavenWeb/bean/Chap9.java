package cn.junyi.mavenWeb.bean;

/**
 * Created by goujy on 3/6/17.
 */
public interface Chap9 {
    int val = 9;

    void testMethod();

}

class MethodA implements Chap9 {

    public static void main(String[] args) {
        MethodA ma = new MethodA();
        ma.testMethod();
    }

    public void testMethod() {
        System.out.println(val + "===");
    }
}