/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.Stack;

/**
 *
 * @author I300939
 */
public class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> store;
    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new Stack<>();
        this.store = new Stack<>(); 
    }
    
    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek();
            if (x > min) {
                minStack.push(min);
            } else {
                minStack.push(x);
            }          
        }
        store.push(x);
    }
    
    public void pop() {
        if (store.size() != 0) {
            minStack.pop();
            store.pop();   
        }
    }
    
    public int top() {
        if (store.size() != 0) {
            return store.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if (minStack.size() != 0) {
            return minStack.peek();
        }
        return -1;
    } 
    
    public static void main(String[] args) {
        MinStack me = new MinStack();
        me.push(2147483646);
        me.push(2147483646);
        me.push(2147483647);
        System.out.println(me.top());
        me.pop();
        System.out.println(me.getMin());
        me.pop();
        System.out.println(me.getMin());
        me.pop();
        me.push(2147483647);
        System.out.println(me.top());
        System.out.println(me.getMin());
        me.push(-2147483648);
        System.out.println(me.top());
        System.out.println(me.getMin());
        me.pop();
        System.out.println(me.getMin());
    }
}
