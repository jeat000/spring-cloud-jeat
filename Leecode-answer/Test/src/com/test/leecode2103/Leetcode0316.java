package com.test.leecode2103;

/**
 * @ClassName Leetcode0325
 * @Author chenjian
 * @Date 2021-03-25 14:37
 */
public class Leetcode0316 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode prev=root,temp=head;
        while(temp!=null){
            if(temp.next==null || temp.next.val!=temp.val){
                prev=temp;
                temp=temp.next;
            }else{
                while(temp.next!=null && temp.next.val==temp.val){
                    temp=temp.next;
                }
                prev.next=temp.next;
                temp=temp.next;
            }
        }
        return root.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
