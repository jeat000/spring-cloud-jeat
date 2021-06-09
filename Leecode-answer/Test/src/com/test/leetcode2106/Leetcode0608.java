package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0608
 * @Author chenjian
 * @Date 2021-06-09 12:31
 */
public class Leetcode0608 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}
