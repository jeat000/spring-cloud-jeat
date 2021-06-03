package com.test.leetcode2106;

import java.util.HashMap;
import java.util.Map;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0602
 * @Author chenjian
 * @Date 2021-06-03 14:08
 */
public class Leetcode0602 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if(m<2) return false;
        int sum=0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,-1);
        for(int i=0;i<m;i++){
            sum=(sum+nums[i])%k;
            if(map.containsKey(sum)){
                if(i-map.get(sum)>1){
                    return true;
                }
            }else{
                map.put(sum,i);
            }
        }
        return false;
    }
}
