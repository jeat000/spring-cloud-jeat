package com.test.leetcode2107;

import java.util.Arrays;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0702
 * @Author chenjian
 * @Date 2021-07-02 12:23
 */
public class Leetcode0702 {
    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for(int i=0;i<costs.length; i++){
            if(costs[i]<=coins){
                res++;
                coins-=costs[i];
            }else{
                break;
            }
        }
        return res;
    }
    public int maxIceCream(int[] costs, int coins) {
        int[]s = new int[100001];
        for(int c : costs){
            s[c]++;
        }

        int res = 0;
        for(int i=1;i<100001; i++){
            if(i<=coins){
                int temp = Math.min(s[i],coins/i);
                res+=temp;
                coins=coins-i*temp;
            }else{
                break;
            }
        }
        return res;
    }
}
