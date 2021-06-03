package com.test.leetcode2106;

import java.util.HashMap;
import java.util.Map;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0603
 * @Author chenjian
 * @Date 2021-06-03 14:09
 */
public class Leetcode0603 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0,res=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                sum++;
            }else{
                sum--;
            }
            if(map.containsKey(sum)){
                res=Math.max(res,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return res;
    }


    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head,fast=head;
        while(fast!=null){
            if(fast==null ||fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                ListNode s =head;
                while(s!=slow){
                    slow=slow.next;
                    s=s.next;
                }
                return s;
            }
        }

        return null;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
