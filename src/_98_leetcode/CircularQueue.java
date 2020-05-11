/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I300939
 */
class MyCircularQueue {
    
    int size = 0;
    int capacity = 0;
    private List<Integer> list;
    int start = 0;
    int end = -1;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.list = new ArrayList<>();
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.size == this.capacity) {
            return false;
        }
        this.size++;
        end = (end + 1) % this.capacity;
        this.list.add(end, value);
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.size == 0) {
            return false;
        }
        this.size --;
        start = (start + 1) % this.capacity;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (this.size == 0) {
            return -1;
        }        
        return this.list.get(start);
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (this.size == 0) {
            return -1;
        }
        return this.list.get(end);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.size == this.capacity;
    }
    
    public static void main(String[] args) {
        MyCircularQueue me = new MyCircularQueue(6);
        me.enQueue(6);
        System.out.println(me.Rear());
        System.out.println(me.Rear());
        me.deQueue();
        me.enQueue(5);
        System.out.println(me.Rear());
        me.deQueue();
        System.out.print(me.Front());
        me.deQueue();
        me.deQueue();
        me.deQueue();
    }
}
