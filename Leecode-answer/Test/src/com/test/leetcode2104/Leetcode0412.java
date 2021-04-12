package com.test.leetcode2104;

import java.util.PriorityQueue;

/**
 * @ClassName Leetcode0412
 * @Author chenjian
 * @Date 2021-04-12 12:39
 */
public class Leetcode0412 {
    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {
        //合法性
        if (nums == null || nums.length == 0) {
            return "";
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> {
            String str1 = o1.toString() + o2.toString();
            String str2 = o2.toString() + o1.toString();
            return str2.compareTo(str1);
        });
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            res.append(priorityQueue.poll());
        }
        //特殊情况 若干个零
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }
}
