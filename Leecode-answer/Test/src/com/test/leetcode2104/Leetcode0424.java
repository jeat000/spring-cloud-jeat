package com.test.leetcode2104;

/**
 * @ClassName Leetcode0424
 * @Author chenjian
 * @Date 2021-04-25 11:42
 */
public class Leetcode0424 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
