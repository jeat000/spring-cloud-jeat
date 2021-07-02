package com.test.leetcode2107;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0701
 * @Author chenjian
 * @Date 2021-07-02 12:23
 */
public class Leetcode0701 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}
