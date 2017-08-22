package cn.junyi.mavenWeb.Controller;

import cn.junyi.mavenWeb.bean.Chap6;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by goujy on 3/5/17.
 */
public class BaseController {
    public static void main(String[] args) {
        System.out.println(Chap6.class);
        Map<String,String> currMap = new ConcurrentHashMap<String,String>();
    }

}
