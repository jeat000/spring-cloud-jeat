package com.test.leetcode2107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0713
 * @Author chenjian
 * @Date 2021-07-15 12:40
 */
public class Leetcode0713 {
    public List<List<Integer>> getSkyline(int[][] bs) {
        List<List<Integer>> res = new ArrayList<>();

        List<int[]> list = new ArrayList<>();
        for(int[] b : bs) {
            list.add(new int[]{b[0],-b[2]});
            list.add(new int[]{b[1],b[2]});
        }
        Collections.sort(list,(a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)-> b-a);
        int prev = 0;
        q.add(prev);
        for(int[] l : list) {
            if(l[1]<0){
                q.add(-l[1]);
            }else{
                q.remove(l[1]);
            }
            int temp = q.peek();
            if(prev!=temp) {
                List<Integer> r = new ArrayList<>();
                r.add(l[0]);
                r.add(temp);
                res.add(r);
                prev=temp;
            }
        }
        return res;
    }
}
