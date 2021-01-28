package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = new RemoveNthFromEnd.ListNode(1);
        removeNthFromEnd.removeNthFromEnd(listNode, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        int m = n;
        while (m > 0) {
            if (fast.next != null) {
                fast = fast.next;
                m--;
            } else {
                break;
            }
        }

        if (m > 0) {
            // 删除头结点
            head = head.next;
        } else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }

    static class ListNode {
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
}