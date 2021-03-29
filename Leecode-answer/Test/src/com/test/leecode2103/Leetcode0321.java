package com.test.leecode2103;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Leetcode0325
 * @Author chenjian
 * @Date 2021-03-25 14:37
 */
public class Leetcode0321 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
        Set<Integer> rows=new HashSet<>();
        Set<Integer> colunms=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    colunms.add(j);
                }
            }
        }
        for(int c:rows){
            for(int i=0;i<n;i++){
                matrix[c][i]=0;
            }
        }
        for(int c:colunms){
            for(int i=0;i<m;i++){
                matrix[i][c]=0;
            }
        }
        return;
    }
}
