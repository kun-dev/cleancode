/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _98_leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author I300939
 */
public class NumberOfIslands {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] {1, 0},
        new int[] {-1, 0},
        new int[] {0, 1},
        new int[] {0, -1}
    );
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int m = 0; m < row; m ++) {
            for (int n = 0; n < col; n++) {
                if (grid[m][n] == '1') {
                    count ++;
                    grid[m][n] = '0';
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {m, n});
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        for (int[] direction : DIRECTIONS) {
                            int r = m + direction[0];
                            int c = n + direction[1];
                            if (r >= 0 && c >= 0 && r < row && c < col && grid[r][c] == '1') {
                                q.offer(new int[] {r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        char[][] chars = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        NumberOfIslands me = new NumberOfIslands();
        System.out.println(me.numIslands(chars));
    }
}
