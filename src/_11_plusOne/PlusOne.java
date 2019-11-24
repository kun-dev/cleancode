/*
 * Q: Given a number represented as an array of digits, plus one to the number
 * Assume it is a non-negative number
 */
package _11_plusOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author I300939
 */
public class PlusOne {
    
    public int plusOne(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret * 10 + nums[i];
        }
        return ret + 1;
    }
    
    // this is very smart, and the question may not ask to convert to int
    // probably still want to remain the presentation
    public int[] plusOneSol(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int digit = nums[i];
            if (digit < 9) {
                nums[i] = digit + 1;
                return nums;
            } else {
                // carry on
                nums[i] = 0;
            }
        }
        // when reach here, means digitals are all 9s
        int[] nums2 = new int[nums.length + 1];
        nums2[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            nums2[i+1] = nums[i];
        }
        return nums2;
    }
    
    public static void main(String[] args) {
        PlusOne me = new PlusOne();
        System.out.println(me.plusOne(new int[]{1,2,3}));
        System.out.println(me.plusOne(new int[]{1,2,9}));
        System.out.println(Arrays.toString(me.plusOneSol(new int[]{1,2,3})));
        System.out.println(Arrays.toString(me.plusOneSol(new int[]{1,2,9})));
    }
}
