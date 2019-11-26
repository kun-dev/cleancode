/*
 * Givin an array of integers, every element appears twice except for one. Find
 * that single one.
 * We could use a map to keep track of the number of times an element appears.
 * We can also inserts elements into a set instead. If an element already exists,
 * we discard the element from the set knowing that it will not appear again.
 * XOR-ing a number with itself is zero. If we XOR all numbers together, it would
 * effectively cancel out all elements that appear twice leaving us with only the
 * single number. As the XOR operation is both commutative and associative, the
 * the order in how you XOR them does not matter.
 */
package _25_singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author I300939
 */
public class SingleNumber {
    public int singeNumberUsingMap(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : A) {
            int count = map.containsKey(x) ? map.get(x) : 0;
            map.put(x, count + 1);
        }
        for (int x : A) {
            if (map.get(x) == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("No single element");
    }
    
    public int singleNumberUsingSet(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int x : A) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return set.iterator().next();
    }
    
    public int singeNumberUsingBitManipulation(int[] A) {
        int num = 0;
        for (int x : A) {
            num ^= x;
        }
        return num;
    }
}
