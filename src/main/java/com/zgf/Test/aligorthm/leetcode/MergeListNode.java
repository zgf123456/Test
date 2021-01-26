package com.zgf.Test.aligorthm.leetcode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeListNode {
    public static void main(String[] args) {
        MergeListNode mergeListNode = new MergeListNode();

        ListNode listNode1 = new ListNode(1);
        ListNode ln11 = new ListNode(2);
        listNode1.next = ln11;
        ListNode ln12 = new ListNode(3);
        ln11.next = ln12;
        ListNode ln13 = new ListNode(4);
        ln12.next = ln13;

        ListNode listNode2 = new ListNode(2);
        ListNode ln21 = new ListNode(3);
        listNode2.next = ln21;
        ListNode ln22 = new ListNode(4);
        ln21.next = ln22;
        ListNode ln23 = new ListNode(5);
        ln22.next = ln23;

        ListNode listNode = mergeListNode.mergeKLists(new ListNode[]{listNode1, listNode2});
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode head = null;
        ListNode opNode = null;

        while (true) {
            ListNode min = null;
            // 找到当前最小的值
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (min == null) {
                        min = lists[i];
                        minIndex = i;
                    } else {
                        if (lists[i].val < min.val) {
                            min = lists[i];
                            minIndex = i;
                        }
                    }
                }
            }

            if (min == null) {
                break;
            } else {
                lists[minIndex] = lists[minIndex].next;
            }

            // 摘除节点
            if (head == null) {
                head = min;
                head.next = null;
                opNode = head;
            } else {
                opNode.next = min;
                opNode = opNode.next;
                opNode.next = null;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;


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
