package cn.junyi.concurrency.bean;

import java.util.Stack;

/**
 * TestDemo
 * Created by goujy on 4/9/17.
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.add(23);
        myStack.add(45);
        myStack.push(77);
        System.out.println(myStack);
    }
}
