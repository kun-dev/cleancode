/*
 * Reverse the string with constraints: the input string doesn't contain leading
 * or trailing spaces and the words are always separated by a single space.
 * Could you do it in-depth without allocating extra space
 * O(n) runtime, O(1) space - in space reverse
 * Notice when you reserve a word twice, you get original word.
 * The input string is w1w2...wn. If we reserve entire string, it become
 * wn'...w2'w1'. Finally we reserve each individual word and it become wn..w2w1
 */
package _04_reversewords;

/**
 *
 * @author I300939
 */
public class ReverseWordsInPlace {
    
    public void reserveWords(char[] s) {
        reserve(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reserve(s, i, j);
                i = j + 1;
            }
        }
    }
    
    private void reserve(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin)/2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }
    
    public static void main(String[] args) {
        String input = "the sky is blue";
        char[] s = input.toCharArray();
        ReverseWordsInPlace me = new ReverseWordsInPlace();
        me.reserveWords(s);
        String output = new String(s);
        System.out.println(output);
    }
}
