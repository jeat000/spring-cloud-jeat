package com.test.leecode2103;

/**
 * @ClassName Leetcode0330
 * @Author chenjian
 * @Date 2021-04-01 13:53
 */
public class Leetcode0330 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;
        int start =0, end = m*n-1;
        while(start<=end){
            int mid =(end-start)/2 + start;
            if(matrix[mid/n][mid%n]==target){
                return true;
            }
            if(matrix[mid/n][mid%n]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }

    /*public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;
        for(int i=m-1; i>=0; i--){
            if(matrix[i][0]<=target){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]==target)
                    return true;
                }
            }
        }
        return false;
    }*/
}
