package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0607
 * @Author chenjian
 * @Date 2021-06-09 12:31
 */
public class Leetcode0607 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int s: nums){
            sum+=s;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }



    /* private int res=0;
    public int findTargetSumWays(int[] nums, int target ) {
        int n=nums.length;
        dfs(nums, n, 0, 0, target);

        return res;

    }


    private void dfs(int[]nums, int n, int s, int sum, int target){
        if(s==n){
            if(sum==target){
                res++;
            }
            return;
        }

        dfs(nums, n, s+1, sum+nums[s];, target);
        dfs(nums, n, s+1, sum-nums[s];, target);
    }*/
}
