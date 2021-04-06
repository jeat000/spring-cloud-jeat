package com.test.leetcode2104;

/**
 * @ClassName Leetcode0402
 * @Author chenjian
 * @Date 2021-04-06 10:13
 */
public class Leetcode0402 {
    public int trap(int[] height) {
        int n=height.length;
        if(n==0){
            return 0;
        }
        int[][]dp=new int[n][2];
        dp[0][0]=height[0];
        dp[n-1][1]=height[n-1];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],height[i]);
            dp[n-i-1][1]=Math.max(dp[n-i][1],height[n-i-1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=Math.min(dp[i][0],dp[i][1])-height[i];
        }
        return res;
    }
}
