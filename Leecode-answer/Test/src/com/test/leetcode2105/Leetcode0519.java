package com.test.leetcode2105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0519
 * @Author chenjian
 * @Date 2021-05-21 12:57
 */
public class Leetcode0519 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return results.get(k - 1);
    }
}
