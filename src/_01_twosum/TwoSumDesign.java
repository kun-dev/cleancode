/*
 * Question: Design and implement a class. It should support the operations:
 * add and find
 * add: add the number to an internal data structure
 * find: find if any pair of numbers which sum is equal to the value
 * for example: add(1),add(3),add(5),find(4)->true,find(7)->false
 * add O(1), find O(n), O(n) space - store in hash table
 */
package _01_twosum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author I300939
 */
public class TwoSumDesign {
    private Map<Integer, Integer> table = new HashMap<>(); 
    
    public void add(int input) {
        int count = table.containsKey(input) ? table.get(input) : 0;
        table.put(input, count);
    }
    
    public boolean find(int val) {
        for (Map.Entry<Integer, Integer> entry: table.entrySet()) {
            int num = entry.getKey();
            int y = val - num;
            if (y == num) {
                if (entry.getValue() >= 2) return true;
            } else if (table.containsKey(y)) {
                return true;
            }
        }
        return false;
    }
}
