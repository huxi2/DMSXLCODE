package linkedList;

import nodes.ListNode;
import org.junit.Test;

public class MyLinkedList {
    ListNode element;
    int size;

    public MyLinkedList() {
        element = new ListNode(-1);
        size = 0;
    }

    public ListNode getElementByIndex(int index) {
        //返回索引为index的节点  0 为第一个节点 非首节点
        ListNode p = element;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p;
    }

    public int get(int index) {// index [0, size-1]
        if (index < 0 || index >= size) return -1;
        return getElementByIndex(index).val;
    }

    public void addAtHead(int val) {
        element.next = new ListNode(val, element.next);
        size++;
    }

    public void addAtTail(int val) {
        ListNode p = getElementByIndex(size - 1);
        p.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode p;
        if (index < 0) p = getElementByIndex(-1);
        else if (index < size) p = getElementByIndex(index - 1);
        else if (index == size) p = getElementByIndex(size - 1);
        else return;
        p.next = new ListNode(val, p.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode p = getElementByIndex(index - 1);
        p.next = p.next.next;
        size--;
    }

    @Test
    public void test() {
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(2);
        ml.deleteAtIndex(1);
        ml.addAtHead(2);
        ml.addAtHead(7);
        ml.addAtHead(3);
        ml.addAtHead(2);
        ml.addAtHead(5);
        ml.addAtTail(5);
        System.out.println(ml.get(5));
        ml.deleteAtIndex(6);
        System.out.println(ml.get(4));
    }
}
