package cn.junyi.mavenWeb.bean;

/**
 * Created by goujy on 3/6/17.
 */
public class Chap10 {
    public static void main(String[] args) {
        //Outer outer = new Outer();
        //outer.inn = outer.getInnerClass();
        Outer.Inner inner = new Outer().getInnerClass();

    }
}

//out class
class Outer {

    /*public static void main(String[] args) {
        Outer out = new Outer();
        out.getInnerClass();
    }*/

    Inner inn = new Inner();

    Inner getInnerClass() {
        Inner in = new Inner();
        return in;
    }

    //inner class
    class Inner {

    }
}