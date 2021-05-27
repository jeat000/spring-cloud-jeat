package com.test.leetcode2105;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0521
 * @Author chenjian
 * @Date 2021-05-21 12:56
 */
public class Leetcode0521 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int [][]db = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            int a=nums1[i-1];
            for(int j=1;j<=n;j++){
                int b=nums2[j-1];
                if(a==b){
                    db[i][j]=db[i-1][j-1]+1;
                }else{
                    db[i][j]=Math.max(db[i-1][j],db[i][j-1]);
                }
            }
        }
        return db[m][n];
    }
}
