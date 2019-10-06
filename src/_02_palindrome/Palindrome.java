/*
 * Question: Givin a string, determine if it is palindrome, consider only
 * alphanumeric characters and ignore cases.
 * O(n) runtime, O(1) space
 * Solution: the idea is simple, have two pointers - one at head while the other
 * one at the tail. Move them toward each other until they meet while skipping
 * non-alphanumeric characters.
 */
package _02_palindrome;

/**
 *
 * @author I300939
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length();
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
