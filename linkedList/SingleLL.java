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

    // size
    public void size() {
        Node cNode = head;
        int size = 0;

        while (cNode != null) {
            size++;
            cNode = cNode.next;
        }
        System.out.println(size);
    }

    // print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
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

    // addAtPosition
    public void addAtPosition(int position, int val) {

        Node newNode = new Node(val);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        }

        Node prev = head;
        int ptr = 1;
        while (ptr < position) {
            prev = prev.next;
            ptr++;
        }
        if (prev.next == null) {
            prev.next = newNode;
            return;
        }
        Node nextNode = prev.next.next;
        newNode.next = nextNode;
        prev.next = newNode;

    }

    // deleteNode
    public void deleteNode(int position) {

        if (position == 0) {
            head = head.next;
            return;
        }
        int ptr = 1;
        Node cNode = head;
        while (ptr < position) {
            cNode = cNode.next;
            ptr++;
        }
        cNode.next = cNode.next.next;
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
        l1.addLast(5);

        // l1.addFirst(-1);
        // l1.addFirst(-2);
        // l1.addFirst(-3);
        // l1.addFirst(-4);

        // l1.removeFirst();
        // l1.removeLast();

        l1.addAtPosition(4, 100);
        // l1.deleteNode(4);

        l1.size();
        l1.print();

    }
}