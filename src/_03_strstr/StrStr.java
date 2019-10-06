/*
 * Question: Implement strstr(). Returns the index of the first occurrence of
 * needle in haystack, or -1 if needle is not part of haystack
 * Solution: O(nm) runtime, O(1) space - brute force
 */
package _03_strstr;

/**
 *
 * @author I300939
 */
public class StrStr {
    public int strstr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }
    }
    
    public static void main(String[] args) {
        StrStr me = new StrStr();
        int result = me.strstr("barbara", "rba");
        System.out.println("the result is: " + result);
    }
}
