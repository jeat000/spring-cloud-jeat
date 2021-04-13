package com.test.leetcode2104;

/**
 * @ClassName Leetcode0413
 * @Author chenjian
 * @Date 2021-04-13 12:45
 */
public class Leetcode0413 {
    private int res;
    private TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        res=Integer.MAX_VALUE;
        prev=new TreeNode(-root.val);
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        res=Math.min(res,root.val-prev.val);
        prev=root;
        dfs(root.right);
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
