/*
 * Givin a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * Hint: a palindromic is a string which reads the same in both direction. For
 * example "aba" is a palindromic, "abc" is not.
 */

/*
 * We observe that palindromic mirrors around its center. Therefore, a palindromic
 * can be expanded from its center, and there are only 2n-1 such centers.
 * Why there are 2n-1 but not n centers? The reason is center of a palindronic
 * can be in between two letters. Such palindromic have even number of letters
 * such as "abba".
 */
package _08_longest_palindromic;

/**
 *
 * @author I300939
 */
public class LongestPalindromic {
    public String longestPalindromic(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
