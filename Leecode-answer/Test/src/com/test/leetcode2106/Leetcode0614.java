package com.test.leetcode2106;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0614
 * @Author chenjian
 * @Date 2021-06-15 12:48
 */
public class Leetcode0614 {
    public int guessNumber(int n) {
        int l=1,r=n;
        while(l<r){
            int mid=l+(r-l)/2;
            if(guess(mid)==0){
                return mid;
            }
            if(guess(mid)<0){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return 0;
    }

    private int guess(int num){
        return 0;
    }
}
