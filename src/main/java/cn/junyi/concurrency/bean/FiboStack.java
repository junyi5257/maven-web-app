package cn.junyi.concurrency.bean;

/*
 *
 * FiBoFunction
 * Created by goujy on 4/9/17.
 * Stack -- extends Vector
 * E push(E) -- add element on Top,return Add Element
 * E peek( )-- get  the Top Element without remove it
 * <Looks at the object at the top of this stack without removing it>
 *
 * E pop() ---get  the Top Element and     remove it
 *
 *
 *
 *
 */

import java.math.BigInteger;
import java.util.Stack;

public class FiboStack {
    public static void main(String[] args) {
        Stack<BigInteger> stk = new Stack<BigInteger>();
        stk.add(BigInteger.ZERO);//f(0)=0
        stk.push(BigInteger.ONE);//f(1)=1

        stk.peek();
        for (int i = 2; i <= 10; i++) {
            BigInteger f1 = stk.pop();
            BigInteger f2 = stk.pop();
            BigInteger f = f1.add(f2);
            stk.add(f2);
            stk.add(f1);
            stk.add(f);
          //  System.out.println("--line--:"+i+"--"+stk);
        }
        System.out.println(stk);
        System.out.println(stk.pop()+"==="+stk.size());
        System.out.println(stk.peek()+"==="+stk.size());



    }
}
