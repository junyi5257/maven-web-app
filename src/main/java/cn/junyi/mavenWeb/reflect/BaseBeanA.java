package cn.junyi.mavenWeb.reflect;

import java.lang.reflect.Array;

/**Reflect--反射
 * Class  反射的类对象
 * Constructor 类的构造器
 * Field 类的属性
 * Method 类的方法
 * Created by goujy on 7/3/17.
 */
public class BaseBeanA {
    public static void main(String[] args) {

        //get Class Object Method ----01
        Class<?> classBaenB = BaseBeanB.class;
        BaseBeanB beanB0;
        try {
             beanB0 = (BaseBeanB) classBaenB.newInstance();
            System.out.println(beanB0);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //get Class Object Method ----02
        //frequently userd
        try {
            //通过类的全类名，让jvm在服务器中找到 并临时加载这个类，
            // 这个tomcat类在启动的时候，是没有被加载的。

            Class<?> classBeanB2 = Class.forName("cn.junyi.mavenWeb.reflect.BaseBeanB");
            //System.out.println(classBaenB+"---"+classBeanB2);
            BaseBeanB beanB = (BaseBeanB)classBeanB2.newInstance();
            System.out.println(beanB);

            //Refect Array

            Class<?> cls = Class.forName("java.lang.String");
            Object obj = Array.newInstance(cls,34);
            Array.set(obj,0,"dd");
            Array.set(obj,1,"dd1");
            Array.set(obj,2,"dd2");
            Object res = Array.get(obj,1);
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
