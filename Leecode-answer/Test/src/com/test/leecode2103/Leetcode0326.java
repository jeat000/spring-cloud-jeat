package com.test.leecode2103;

/**
 * @ClassName Leetcode0326
 * @Author chenjian
 * @Date 2021-03-29 15:46
 */
public class Leetcode0326 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return root.next;
    }
}
