/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author I300939
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap();
        String[] sortedStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String tmp = new String(c);
            sortedStrs[i] = tmp;
        }
        for (int i = 0; i < sortedStrs.length; i++) {
            if (map.containsKey(sortedStrs[i])) {
                map.get(sortedStrs[i]).add(strs[i]);
            } else {
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(sortedStrs[i], list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }    
    public static void main(String[] args) {
        GroupAnagrams me = new GroupAnagrams();
        String[] arg = new String[]{"eat","tea","tan","ate","nat","bat"};
        List list = me.groupAnagrams(arg);
    }
}
