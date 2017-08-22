package cn.junyi.mavenWeb.bean;

/**
 * Created by goujy on 3/6/17.
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    //.this 用法；
    public class Inner {
        public DotThis outer() {
            System.out.println(this.toString());
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
        System.out.println(dti.outer() == dt);
    }
}
