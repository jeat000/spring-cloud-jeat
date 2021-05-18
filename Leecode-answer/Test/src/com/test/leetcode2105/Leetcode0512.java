package com.test.leetcode2105;

/**
 * @ClassName Leetcode0512
 * @Author chenjian
 * @Date 2021-05-18 15:01
 */
public class Leetcode0512 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int m=arr.length;
        int[]base=new int[m+1];
        for(int i=0;i<m;i++){
            base[i+1]=base[i]^arr[i];
        }


        int n = queries.length;
        int[]res = new int[n];
        for(int i=0;i<n;i++){
            int l=queries[i][0],r=queries[i][1];
            res[i]=base[l]^base[r+1];
        }
        return res;
    }
}
