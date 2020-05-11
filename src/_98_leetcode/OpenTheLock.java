/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author I300939
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        
        for (String s : deadends) {
            deads.add(s);
        }
        int steps = 0;
        if (deads.contains(target)) {
            return -1;
        }
        queue.add("0000");
        while(!queue.isEmpty()) {
            steps ++;
            String node = queue.poll();
            if (node == target) return steps;
            if (!visited.contains(node) && !deads.contains(node)) {
                visited.add(node);
                for (String s : rolls(node)) {
                    if (!visited.contains(s) && !deads.contains(s)) {
                        queue.add(s);
                    }
                }
            }
        }
        return -1;
    }
    
    public List<String> rolls(String str) {
        List<String> rolls = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = -1; j <=1; j+=2) {
                int c = ((str.charAt(i) - '0') + j + 10) % 10;
                String s = str.substring(0, i) + ("" + c) + str.substring(i+1);
                rolls.add(s);
            }
        }
        return rolls;
    }
    
    public static void main(String[] args) {
        OpenTheLock me = new OpenTheLock();
        String[] arr = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(me.openLock(arr, target));
    }
}
