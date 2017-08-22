package cn.junyi.concurrency.event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 事件源
 * Created by goujy on 3/18/17.
 */
public class EventSourceObject {
    private String name;
    private Set<CusEventListener> listener;

    public EventSourceObject() {
        this.listener = new HashSet<CusEventListener>();
        this.name = "defaultName";
    }

    /**
     * 给事件源注册监听器
     *
     * @param cusEventListener 监听器实例
     */
    public void registerListener(CusEventListener cusEventListener) {
        this.listener.add(cusEventListener);
    }

    private void notifiers() {
        CusEventListener cel;
        Iterator<CusEventListener> iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            cel = iterator.next();
            cel.fireCusEvent(new CusEvent(this));
        }
    }

    public String getName() {
        return name;
    }

    /**
     * 当修改名称时，触发事件;
     * @param name
     */
    public void setName(String name) {
        if(!this.name.equals(name)){
            this.name = name;
            notifiers();
        }
    }
}
