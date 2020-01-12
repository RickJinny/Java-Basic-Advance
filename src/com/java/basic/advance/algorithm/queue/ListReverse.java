package com.java.basic.advance.algorithm.queue;

/**
 * 链表反转
 */
public class ListReverse {

    /**
     * 链表反转的方法一：使用遍历的方法
     * @param node 链表
     * @return
     */
    private static Node reverseList1(Node node) {
        // 空结点pre用来保存先前结点
        Node pre = null;
        // 空结点next用来保存临时变量
        Node next = null;
        // 对头结点node进行遍历
        while (node != null) {
            // next保存head下一个结点
            next = node.next;
            // 将当前结点next指向前一个结点，实现反转
            node.next = pre;
            // 将当前结点的前节点后移
            pre = node;
            // 将当前结点后移
            node = next;
        }
        // 返回反转的链表
        return pre;
    }


    /**
     * 链表反转的方法二：使用递归
     * @param head 链表
     * @return
     */
    private static Node reverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;
        Node pre = reverseList2(next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    private static class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node(11);
        Node nodeB = new Node(22);
        Node nodeC = new Node(33);
        Node nodeD = new Node(44);
        Node nodeE = new Node(55);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        print(nodeA);
        print(reverseList1(nodeA));
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            } else {
                System.out.println();
            }
        }
    }
}
