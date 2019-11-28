/*
 * Givin a roman numeral, convert it to an integer
 * Input is guaranteed to be within the rang from 1 to 3999
 * Solution: Let's work through some example. Assume the input is VII, using the
 * additive notation, we could simple add up each roman literal, V+I+I=5+1+1=7.
 * Now let's look at another example input IV. Now we need to use the subtractive
 * Notation. We first look at I, and we add 1 to it. Then we look at V and since
 * a smaller roman literal I appears before it, we need to substract I from V.
 * Remember that we already added another I before it, so we need to substract a
 * total of two one's from it.
 */
package _28_romanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author I300939
 */
public class RomanToInteger {
    private Map<Character, Integer> map = new HashMap<Character, Integer>();
    
    public int romanToInteger(String s) {
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);
        int prev = 0, total = 0;
        for (char c : s.toCharArray()) {
            int curr = map.get(c);
            total += (curr > prev) ? (curr - 2 * prev) : curr;
            prev = curr;
        }
        return total;
    }
}
