package com.java.basic.advance.algorithm.queue;

/**
 * 链表中检测环
 */
public class CheckCircle {

    public Node getIntersectionNode(Node headA, Node headB) {

        Node nodeList1 = headA;
        Node nodeList2 = headB;

        while (nodeList1 != nodeList2) {
            nodeList1 = (nodeList1 == null) ? headB : nodeList1.next;
            nodeList2 = (nodeList2 == null) ? headA : nodeList2.next;
        }

        return nodeList1;
    }

    private static class Node {

        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
    }
}
