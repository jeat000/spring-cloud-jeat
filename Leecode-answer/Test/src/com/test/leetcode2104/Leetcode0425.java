package com.test.leetcode2104;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Leetcode0425
 * @Author chenjian
 * @Date 2021-04-25 11:42
 */
public class Leetcode0425 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp = root;
        TreeNode res = new TreeNode();
        TreeNode s=res;
        Deque<TreeNode> stack = new LinkedList<>();
        while(temp != null || !stack.isEmpty())
        {
            while(temp != null)
            {
                stack.push(temp);
                temp = temp.left;
            }
            if(!stack.isEmpty())
            {
                temp = stack.pop();
                s.right=new TreeNode(temp.val);
                s=s.right;
                temp = temp.right;
            }
        }
        return  res.right;
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
