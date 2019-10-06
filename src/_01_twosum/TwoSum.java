/*
 * Question: Given an array of integers, find two numbers such that they add up
 * to a specific target number.
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note
 * that your returned answers are not zero based.
 * You may assume that each input would have exactly one solution
 *
 * O(n) runtime, O(n) space, Hash table
 * We would reduce the runtime complexity of looking up a value to O(1) using
 * a hash map that map a value to its index
 */
package _01_twosum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author I300939
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[] {map.get(target - x) + 1, i + 1};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        TwoSum me = new TwoSum();
        int[] result = me.twoSum(new int[] {1,3,5,7,8}, 10);
        System.out.println("the result is: " + result[0] + " : " + result[1]);
    }
}
