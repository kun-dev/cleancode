/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author I300939
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int count = map.get(s.charAt(i));
            if (count == 1) {
                if (i < index) {
                    index = i;
                }
            }
        }
        return index == Integer.MAX_VALUE? -1 : index;
    }
    public static void main(String[] args) {
        FirstUniqueCharacter me = new FirstUniqueCharacter();
        String arg = "leetcode";
        System.out.println(me.firstUniqChar(arg));
    }
}
