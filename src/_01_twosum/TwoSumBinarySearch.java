/*
 * The Hash table approach costs us O(n) extra spaces, plus it does not make use
 * of the fact that the input is already sorted.
 * O(nlogn) runtime, O(1) space - Bianary Search
 * For each element x, we could look up if target - x exists in O(logn) time by
 * applying binary search over the sorted array.
 */
package _01_twosum;

/**
 *
 * @author I300939
 */
public class TwoSumBinarySearch {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, target - numbers[i], i+1);
            if (j != -1) {
                return new int[] {i+1, j+1};
            }
        }
        throw new IllegalArgumentException("No two sum found");
    }
    
    private int binarySearch(int[] A, int key, int start) {
        int L = start, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < key) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && A[L] == key) ? L : -1;
    }
    
    public static void main(String[] args) {
        TwoSumBinarySearch me = new TwoSumBinarySearch();
        int[] result = me.twoSum(new int[]{1,3,5,7,8}, 10);
        System.out.println("result is: " + result[0] + " : " + result[1]);
    }
    
}
