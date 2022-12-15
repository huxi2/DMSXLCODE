package linkedList;

import nodes.ListNode;

public class SwapPairs {
    //画图理解
    public ListNode swapPairs(ListNode head) {
        ListNode newList = new ListNode(-1,head),pre,first,second;
        pre = newList;
        first = head;
        while(first!=null){
            second = first.next;
            if(second!=null){
                pre.next=second;
                first.next = second.next;
                second.next =first;
            }
            pre = first;
            first = pre.next;
        }

        return newList.next;
    }
}
