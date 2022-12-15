package linkedList;

import nodes.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1, head), fast, last;
        last = newHead;
        fast = head;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            last = last.next;
        }
        last.next = last.next.next;
        return newHead.next;
    }
}
