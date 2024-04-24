// (24/04/2024, 7:29 AM)
// QUESTION: IMPLEMENT SINGLE LL

package datastructure.linkedList;

// LinkedList
class LinkedList {

    Node head = null;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    // addFirst
    public void addFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

    }

    // addLast
    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // removeFirst
    public void removeFirst() {
        if (head == null) {
            return;
        } else {
            head = head.next;
        }
    }

    // removeLast
    public void removeLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            return;
        } else {
            Node cNode = head.next;
            Node prev = head;
            while (cNode.next != null) {
                cNode = cNode.next;
                prev = prev.next;
            }
            prev.next = null;
        }
    }

}

public class SingleLL {
    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();

        l1.addLast(0);
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);

        l1.addFirst(-1);
        l1.addFirst(-2);
        l1.addFirst(-3);
        l1.addFirst(-4);

        l1.removeFirst();
        l1.removeLast();
        l1.print();

    }
}