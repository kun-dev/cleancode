/*
 * Given a sorted integer array where the range of elements are [0,99] inclusive
 * return its ranges
 * For example, givin [0,1,3,50,75], return ["2","4->49","51->74","76->99"]
 * Further, you should be able to extend above cases not only for fixed range,
 * but any arbitrary range [start, end]
 */
package _07_missingRange;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I300939
 */
public class MissingRange {
    public List<String> findMissingRange(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start - 1;
        for (int i = 0; i <= vals.length; i++) {
            int curr = (i == vals.length) ? end + 1 : vals[i];
            if(curr - prev >= 2) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }
    
    public String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }
    
    public static void main(String[] args) {
        int[] vals = new int[]{1,2,7,80};
        MissingRange me = new MissingRange();
        List list = me.findMissingRange(vals, 0, 99);
        System.out.println(list.toString());
    }
}
