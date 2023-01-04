package com.oma.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;

    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public Node insertNode(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return head;
    }

    public static Node findIntersection(Node l1, Node l2) {
        Node cur = l1;
        while (cur != null) {
            Node cur2 = l2;
            while (cur2 != null) {

                if (cur == cur2) {
                    return cur;
                }
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        System.out.println(list.insertNode(1));
        System.out.println(list.insertNode(2));
        System.out.println(list.insertNode(3));
        System.out.println(list2.insertNode(4));
        System.out.println(list2.insertNode(5));
        System.out.println(list2.insertNode(6));
        list.head.next.next.next = list2.head.next;
        System.out.println(findIntersection(list.head, list2.head));
//        System.out.println(list.removeNode(6));
    }
}
