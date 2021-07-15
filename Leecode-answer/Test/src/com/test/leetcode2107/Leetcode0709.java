package com.test.leetcode2107;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0709
 * @Author chenjian
 * @Date 2021-07-09 12:49
 */
public class Leetcode0709 {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        int temp = 0;
        int count = 0;
        for(int num : nums){
            if(count==0){
                temp=num;
            }
            if(temp==num){
                count++;
            }else{
                count--;
            }
        }
        count=0;
        for(int num : nums){
            if(num==temp){
                count++;
            }
        }
        return count>nums.length/2 ? temp:-1;
    }


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        List<String> res = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("b");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("b")){
                iterator.remove();
                res.add(s);
            }
        }
        System.out.println(list);
        System.out.println(res);
    }
}
