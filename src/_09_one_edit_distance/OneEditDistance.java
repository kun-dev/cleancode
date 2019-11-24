/*
 * Question: Givin two strings S and T, determine if they are both one edit
 * distance apart.
 * Solution: We make a first pass over S and T concurrently and stop at the
 * first non-matching character between S and T.
 * 1. If S matches all characters in T, then check if there is an extra
 * character at the end of T. (Append operation)
 * 2. If |n-m| == 1, that means we must skip this non-matching character only in
 * T and make sure the remaining characters between S and T are exactly matching
 * 3. If |n-m| == 0, then we skip both non-matching characters in S and  T and
 * make sure the remaining characters between S and T are exactly matching.
 */
package _09_one_edit_distance;

/**
 *
 * @author I300939
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return isOneEditDistance(t, s);
        if (n - m > 1) return false;
        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        if (i == m) return shift > 0;
        if (shift == 0) i++;
        while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == m;
    }
}
