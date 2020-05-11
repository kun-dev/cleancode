/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _42_hashset;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author I300939
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
            set.add(nums[i]);
        }
        Object[] arr = set.toArray();
        return (int)arr[0];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        Solution s = new Solution();
        System.out.println(s.singleNumber(nums));
    }

}
