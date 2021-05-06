package com.test.leetcode2104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Leetcode0427
 * @Author chenjian
 * @Date 2021-05-06 10:24
 */
public class Leetcode0427 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) {
            return 0;
        }
        int res=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp==null){
                continue;
            }
            if(temp.val>high){
                queue.offer(temp.left);
            }else if(temp.val<low){
                queue.offer(temp.right);
            }else{
                res+=temp.val;
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return res;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
}
