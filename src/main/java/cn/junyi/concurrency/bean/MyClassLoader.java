package cn.junyi.concurrency.bean;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by goujy on 3/22/17.
 */
public class MyClassLoader {

    public static void main(String[] args) {
       // URL[] urls = {};

        try {
            URL url = new File("/home/goujy/IDEA_SPACE/maven-wab-app/target/classes/cn/junyi/concurrency/bean/MyClass.class").toURI().toURL();
            ClassLoader cl = new URLClassLoader(new URL[]{url});
            Thread.currentThread().setContextClassLoader(cl);
            //System.out.println(cl);
            Class clazz = cl.loadClass("cn.junyi.concurrency.bean.MyClass");
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i <methods.length ; i++) {
                System.out.println(methods[i].toString()+"====="+methods[i].getName());
                if(methods[i].toString().indexOf("doTask")>0){
                    System.out.println("======");
                    methods[i].setAccessible(true);
                    clazz.getMethod("doTask",String.class,String.class);
                    methods[i].invoke(clazz.newInstance(),"LiJun","JunYi");
                }
            }
            Method method = clazz.getMethod("doTask",String.class,String.class);

            method.invoke(clazz.newInstance(),"LiJun","JunYi");

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
