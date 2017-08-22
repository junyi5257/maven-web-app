package cn.junyi.concurrency.event;

import java.io.Serializable;
import java.util.EventObject;

/**
 * Created by goujy on 3/18/17.
 */
public class CusEvent extends EventObject implements Serializable {
    public static final long serialVersionUID = 1L;
    private Object source;

    public CusEvent(Object source) {
        super(source);
        this.source = source;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}

