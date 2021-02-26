package com.test.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Test_1218 {

    public static void main(String[] args) {
        TreeNode r3=new TreeNode(3);
        TreeNode r7=new TreeNode(7);
        TreeNode r9=new TreeNode(9);
        TreeNode r15=new TreeNode(15);
        TreeNode r20=new TreeNode(20);
        r3.left=r9;
        r3.right=r20;
        r20.left=r15;
        r20.right=r7;

        System.out.println(minDepth(r3));
    }





    public static class TreeNode {
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

    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int deep=1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                if(node.left==null && node.right==null) {
                    return deep;
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            ++deep;
        }
        return deep;
    }
}
