package com.ltaocs.linkedList;

/**
 * Lin Tao
 * a.ltaocs.com
 * LeetCode 206. Reverse Linked List
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode Prev = null;
        ListNode Current = head;
        ListNode Next = Current.next;
        while (Current != null) {
            Current.next = Prev;
            Prev = Current;
            Current = Next;
            if (Current != null) {
                Next = Current.next;
            }
        }
        return Prev;
    }
}
