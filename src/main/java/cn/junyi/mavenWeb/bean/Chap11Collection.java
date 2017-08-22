package cn.junyi.mavenWeb.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Collection
 * Created by goujy on 6/11/17.
 */
public class Chap11Collection {


    private static void dealCopyOnWriteArrayList(){
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        //区别 CopyOnWriteArraySet---集合基于CopyOnWriteArrayList 实现
        //由于set 集合特性，不允许重复元素，所以使用了其add()方法使用了
        //CopyOnWriteArrayList的 addIfAbsent()方法

        //这也是两者的区别
    }

    /**
     * BlockingQueue 阻塞队列
     *
     */
    private static void dealArrayBlockingQueen(){
        BlockingQueue<String> arrayListBlockQueen = new ArrayBlockingQueue<String>(10);


    }


    /**
     * 处理HashMap
     */
    private static void  dealHashMap(){

        Map<String,String> hashMap = new HashMap<String, String>();
    }

    /**
     * Make  HasnMap Syncronized
     */

     private static void makeHashMapSync(){
         Map<String,String> hashMap = new HashMap<String, String>();

        hashMap  =  Collections.synchronizedMap(hashMap);
     }



    /**
     * 处理cucurrentHashMap
     */
    private static void dealConCurrentHashMap(){
        Map<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();

    }

    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
       // System.out.println( 1 << 16);
       int concurrencyLevel = 16;
        // Find power-of-two sizes best matching arguments
        int sshift = 0;
        int ssize = 1;

        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }
        int b = 1;
        b = b<<3;
        int c =1;
        c<<=3;
        System.out.println("c:"+c+"=====b:"+b);
        System.out.println();
        System.out.println(sshift);
        int segmentShift = 32 - sshift;
        int segmentMask = ssize - 1;

        System.out.println(segmentShift+"===="+segmentMask);
    }

}
