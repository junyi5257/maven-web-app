package cn.junyi.concurrency.bean;

import java.io.File;
import java.net.URL;

/**
 * Created by goujy on 3/22/17.
 */
public class MyClass {
    public MyClass() {
        Object o = new Object();
        System.out.println("=====init=MyClass======");
    }

   public void doTask(String paraA, String paraB) {
        System.out.println(paraA + "====" + paraB);
    }

    public static File getClassFile(Class clazz) {
        URL path = clazz.getResource(clazz.getName().substring(
                clazz.getName().lastIndexOf(".") + 1) + ".classs");
        if (path == null) {
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }
        return new File(path.getFile());
    }

    public static void main(String[] args) {
        System.out.println(getClassFile(MyClass.class).getPath());
        System.out.println(MyClass.class.getClass().getResource("/").getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }
}
