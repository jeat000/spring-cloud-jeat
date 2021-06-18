package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0611
 * @Author chenjian
 * @Date 2021-06-15 12:48
 */
public class Leetcode0611 {
    public int numSquares(int n) {
        int[]dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min=Math.min(min, dp[i-j*j]);
            }
            dp[i] =min+1;
        }
        return dp[n];
    }
}
