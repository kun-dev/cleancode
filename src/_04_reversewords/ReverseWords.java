/*
 * Question: Given an input string s, reverse the string word by word
 * For example, given a string s = "the sky is blue", return "blue is sky the"
 * One simple approach is a two-pass solution: First pass to split the string
 * by spaces into an array of words, then second pass to extract the words in
 * reserve order.
 * We can do better in one-pass. While iterating the string in reserve order,
 * we keep track of a word's begin and end position. When we are at the begining
 * of word, we append it.
 * Solution: O(n) runtime, O(n) space
 */
package _04_reversewords;

/**
 *
 * @author I300939
 */
public class ReverseWords {
    public String reserveWords(String s) {
        StringBuilder reserved = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reserved.length() != 0) {
                    reserved.append(" ");
                }
                reserved.append(s.subSequence(i, j));
            }
        }
        return reserved.toString();
    }
    
    public static void main(String[] args) {
        ReverseWords me = new ReverseWords();
        String result = me.reserveWords("the sky is blue");
        System.out.println(result);
    }
}
