package cn.junyi.concurrency.bean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by goujy on 3/18/17.
 */
public class ConnectionUtil {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://192.168.1.6:3306/publisher?user=root&password=123456";
    public static final String USERNAME = "";
    public static final String PASSWORD = "";
    private static ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL);
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }
    };

    public static void main(String[] args) {
        Connection conn = connectionHolder.get();
        System.out.println(conn);
        System.out.println( ConnectionUtil.class.getClassLoader().getClass());
        System.out.println(Thread.currentThread().getContextClassLoader().getClass());


    }

}