package cn.junyi.mavenWeb.bean;

import java.util.Random;

import static net.mindview.util.Print.*;

/**
 * Created by goujy on 3/5/17.
 */
class FinalData {
    public static void main(String[] args) {
        System.out.println("============FinalData==");
        FinalData fd1 = new FinalData("fd1");
        //fd1.valueOne++;
        fd1.v2.i++;         //v2 --final,but Object isn't Constant.
        fd1.v1 = new Value(9);
        //a[] --final Array
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;     // a[] final ,but Object isn't Constant.
            //fd1.a = new int[]{12};  Can't change final Reference
            //fd1.v2 = new Value(34); Can't change final Reference
            //fd1.VAL_3 = new Value(45); Can't change final Reference
        }
        print(fd1);
        print("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        print(fd2);

        print(fd1);

        print(rand.nextInt(20));
    }

    private static Random rand = new Random(49);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int valueOne = 9;
    private static final int VALU_YWO = 99;
    public static final int VALUE_THREE = 319;

    private final int i4 = rand.nextInt(20);


    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[] a = {1, 2, 3, 4, 5, 6};

    public String toString() {
        return id + ": " + "i4= " + i4 + ",INT5= " + INT_5+",Random: "+rand.nextInt(20);
    }


}

class Value {
    int i;
    public Value(int i) {
        this.i = i;
    }
}
