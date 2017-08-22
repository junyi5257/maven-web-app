package cn.junyi.concurrency.event;

import java.util.EventListener;

/**
 *
 * 事件监听器实现EventListener 接口，定义回调方法，
 * 在事件源完成之后调用此方法;
 * Created by goujy on 3/18/17.
 */
public class CusEventListener implements EventListener {

    public void fireCusEvent(CusEvent ce) {
        EventSourceObject eso = (EventSourceObject) ce.getSource();
        System.out.println("My name has changed-----");
        System.out.println("My name is \""+eso.getName()+"\"");
    }

}
