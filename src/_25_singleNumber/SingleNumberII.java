/*
 * Givin an array of integers, every element appears three times except for one.
 * Find that single one.
 * Note: Your algorithm should have linear runtime complexity. Could you implement
 * it without using extra memory?
 * If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 due
 * to the constraint of this problem where each number must appear either three
 * times or once. This will be the ith bit of that "single number"
 * A straightforward implementation is to use an array of size 32 to keep track
 * of the total count of ith bit.
 */
package _25_singleNumber;

/**
 *
 * @author I300939
 */
public class SingleNumberII {
//    int singleNumber(int A[], int n) {
//        int[] count = new int[32];
//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//            for (int j = 0; j < n; j++) {
//                if ((A[j] >> i) & 1) {
//                    count[i] ++;
//                }
//            }
//            result |=
//        }
//    }
}
