// (25/04/2024, 8:23 AM)
// QUSTION: IMPLENT DOUBLE LINKED LIST
package datastructure.linkedList;

public class DoubleLL {

    Node head = null;

    class Node {
        Node prev;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    // print
    public void print() {
        Node cNode = head;
        while (cNode != null) {
            System.out.print(cNode.val + " ");
            cNode = cNode.next;
        }
        System.out.println();
    }

    // printReverse
    public void printReverse() {
        Node cNode = head;
        while (cNode.next != null)
            cNode = cNode.next;
        while (cNode != null) {
            System.out.print(cNode.val + " ");
            cNode = cNode.prev;
        }
        System.out.println();
    }

    // insertAtHead
    public void insertAtHead(int val) {

        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    // insertAtEnd
    public void insertAtTail(int val) {

        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cNode = head;
        while (cNode.next != null) {
            cNode = cNode.next;
        }
        cNode.next = newNode;
        newNode.prev = cNode;
    }

    // insertAtPosition
    public void insertAtPosition(int index, int val) {

        Node newNode = new Node(val);
        // insert at head
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        int ptr = 0;
        Node cNode = head;
        while (ptr < index - 1) {
            cNode = cNode.next;
            ptr++;
        }

        // insert at the end
        if (cNode.next == null) {
            cNode.next = newNode;
            newNode.prev = cNode;
            return;
        }
        newNode.next = cNode.next;
        newNode.prev = cNode;
        cNode.next.prev = newNode;
        cNode.next = newNode;

    }

    // deleteHead
    public void deleteHead() {

        if (head == null) {
            return;
        }
        head = head.next;
        head.prev = null;

    }

    // deleteTail
    public void deleteTail() {

        Node cNode = head.next;
        Node prev = head;

        while (cNode.next != null) {
            cNode = cNode.next;
            prev = prev.next;
        }
        prev.next = null;
        cNode.prev = null;

    }

    // deleteAtIndex
    public void deleteAtIndex(int index) {

        // to delete head
        if (index == 0) {
            head = head.next;
            head.prev = null;
            return;
        }
        int ptr = 0;
        Node prev = head;
        Node cNode = head.next;
        while (ptr < index - 1) {
            prev = prev.next;
            cNode = cNode.next;
            ptr++;
        }
        // to delete tail
        if (cNode.next == null) {
            prev.next = null;
            cNode.prev = null;
            return;
        }
        prev.next = cNode.next;
        cNode.next.prev = prev;
        cNode.next = null;
        cNode.prev = null;

    }

    public static void main(String[] args) {

        DoubleLL dl1 = new DoubleLL();
        dl1.insertAtHead(4);
        dl1.insertAtHead(3);
        dl1.insertAtHead(2);
        dl1.insertAtHead(1);
        dl1.insertAtHead(0);
        dl1.print();

        // dl1.insertAtTail(5);
        // dl1.insertAtTail(6);
        // dl1.insertAtTail(7);

        
        // dl1.insertAtPosition(4, 100);

        // dl1.deleteHead();
        // dl1.deleteTail();
        dl1.deleteAtIndex(2);

        dl1.print();
        dl1.printReverse();
    }
}