package linkedList;

import nodes.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int lenA = 0, lenB = 0, diff;
        //统计长度
        while (p != null) {
            p = p.next;
            lenA++;
        }
        while (q != null) {
            q = q.next;
            lenB++;
        }

        //分配节点 p为长链表，q为短链表
        diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            p = headA;
            q = headB;
        } else {
            p = headB;
            q = headA;
        }

        //长先走
        while (diff > 0) {
            p = p.next;
            diff--;
        }
        //一起走
        while (p != null && p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
