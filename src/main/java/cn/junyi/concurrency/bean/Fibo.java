package cn.junyi.concurrency.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by goujy on 4/9/17.
 * 1,1,2,3,5,8
 */
public class Fibo {
    static  ArrayList<Long> fibArr = new ArrayList<Long>(500);

    /**
     * cessss
     * @param a
     * @param b
     * @param flag
     */
    static void dealFib(Long a, Long b, boolean flag){
        if (flag) {
            Long c = a + b;
            if (fibArr.size()>80) {
                flag = false;
            }
            fibArr.add(c);
            dealFib(b, c, flag);
        }
    }

    /**
     * 测试方法说明
     * @param args
     */
    public static void main(String[] args) {
        Long a = 0L;
        Long b = 1L;
        dealFib(a, b, true);
        for (int i = 1; i < fibArr.size()+1; i++) {
            System.out.print(fibArr.get(i-1)+",");
            if(i%15==0){
                System.out.println();
            }
        }
    }
}
