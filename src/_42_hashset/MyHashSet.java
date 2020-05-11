/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _42_hashset;

import java.util.LinkedList;

/**
 *
 * @author I300939
 */
public class MyHashSet {
    private int base = 769;
    private Bucket[] buckets;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new Bucket[this.base];
        for (int i = 0; i < this.base; i++) {
            this.buckets[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        Bucket bucket = buckets[this.hash(key)];
        bucket.insert(key);
    }
    
    public void remove(int key) {
        Bucket bucket = buckets[this.hash(key)];
        bucket.delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        Bucket bucket = buckets[this.hash(key)];
        return bucket.contains(key);       
    }
    public int hash(int key) {
        return key % this.base;
    } 
    public static void main(String[] args) {
        MyHashSet s = new MyHashSet();
        s.add(1);
        s.add(2);
        s.contains(1);
        s.contains(3);
        s.add(2);
        s.contains(2);
        s.remove(2);
        s.contains(2);
    }
}

class Bucket {
    LinkedList<Integer> container = null;
    public Bucket() {
        container = new LinkedList<Integer>();
    }
    public boolean contains(Integer key) {
        int index = this.container.indexOf(key);
        return index > -1;
    }
    public void insert(Integer key) {
        if (!this.contains(key)) {
            this.container.addFirst(key);
        }
    }
    public void delete(Integer key) {
        this.container.remove(key);
    }
}