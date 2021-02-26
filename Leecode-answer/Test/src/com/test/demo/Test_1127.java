package com.test.demo;

import java.util.*;

public class Test_1127 {
    public Test_1127(){

    }
    public static void main(String[] args) {
        /*String s="abcabc";
        int n = s.length();
        int max=0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<n-max; i++){
            int j=i;
            while(set.add(s.charAt(j))){
                j++;
            }
            if(max<set.size()){
                max=set.size();
            }
            set.clear();
        }
        System.out.println(max);*/



        /*Queue stack1 = new LinkedList();
        stack1.offer(1);
        stack1.offer(2);
        stack1.offer(3);
        stack1.offer(4);
        System.out.println(stack1.poll());
        System.out.println(stack1.peek());
        Deque stack2 = new LinkedList();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
        String s = "";
        s.substring(1);
        Map m = new HashMap();Integer.parseInt(s);
        m.containsKey("");*/


        /*int[] s = new int[]{1,2,3};
        System.out.println(permute(s));*/

        List<String> list = new LinkedList<>();
        list.add( "1");
        list.add( "2");
        list.add( "3");
        System.out.println(list);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
