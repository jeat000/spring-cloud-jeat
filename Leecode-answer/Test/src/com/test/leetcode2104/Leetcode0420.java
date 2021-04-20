package com.test.leetcode2104;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Leetcode0420
 * @Author chenjian
 * @Date 2021-04-20 12:45
 */
public class Leetcode0420 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new LinkedList<>();
            dfs(0,0,target,new LinkedList<>(),res,candidates);
            return res;
        }

        private void dfs(int sum,int i, int target,List<Integer> list,List<List<Integer>> res,int[] candidates){
            if(sum==target){
                res.add(new LinkedList<Integer>(list));
                return;
            }else if(sum>target){
                return;
            }
            for(int c=i;c<candidates.length;c++){
                sum+=candidates[c];
                list.add(candidates[c]);
                dfs(sum,c,target,list,res,candidates);
                list.remove(list.size()-1);
                sum-=candidates[c];
            }
        }
    }
}
