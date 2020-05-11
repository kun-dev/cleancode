/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author I300939
 */
public class InsertionOfTwoArrII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int index = -1;
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                nums1[++index] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
    public static void main(String[] args) {
        InsertionOfTwoArrII me = new InsertionOfTwoArrII();
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(me.intersect(nums1, nums2)));
    }
}
