/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author I300939
 */
public class FindResturant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet(Arrays.asList(list1));
        Map<String, Integer> map1 = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }        
        List<String> tmp = new ArrayList();
        List<String> retList = new ArrayList();
        for (int i = 0; i < list2.length; i++) {
            if (set.contains(list2[i])) {
                tmp.add(list2[i]);
            }
        }
        for (String s : tmp) {
            int sum = map1.get(s) + map2.get(s);
            if (sum < min) {
                min = sum;
                retList.clear();
                retList.add(s);
            } else if (sum == min) {
                retList.add(s);
            }
        }
        return retList.toArray();
    }
    public static void main(String[] args) {
        FindResturant me = new FindResturant();
        String[] arg1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arg2 = new String[]{"KFC","Shogun","Burger King"};
        String[] ret = me.findRestaurant(arg1, arg2);
        System.out.println(Arrays.toString(ret));
                
    }
}
