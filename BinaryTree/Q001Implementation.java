// (19/09/23), 19:25, (20/09/23), 8.54am
package datastructure.BinaryTree;

import java.util.*;
import java.lang.*;

// QUES: BUILDING A TREE FROM PREORDER TRAVERSAL
// Node
class Node {
    int val;
    Node left;
    Node right;

    Node(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

// Binarytree
class BinaryTree {

    // create
    static int idx = -1;

    // create
    static Node create(int[] nodes) {
        int val = nodes[++idx];
        if (val == -1)
            return null;
        Node newNode = new Node(val);
        newNode.left = create(nodes);
        newNode.right = create(nodes);
        return newNode;
    }

    // postorder(LRN)
    static void postorder(Node root, List<Integer> post) {
        if (root == null)
            return;
        postorder(root.left, post);
        postorder(root.right, post);
        post.add(root.val);
    }

    // postorder2(RLN)
    static void postorder2(Node root, List<Integer> post2) {
        if (root == null)
            return;
        postorder2(root.right, post2);
        postorder2(root.left, post2);
        post2.add(root.val);

    }
}

public class Q001Implementation {
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        // Ques1: create tree
        Node root = bt.create(nodes);
        System.out.println(root.val);
        // QUES2: postorder
        List<Integer> post = new ArrayList<>();
        bt.postorder(root, post);
        System.out.println("Postorder : " + post);
        // QUES3: postorder2
        List<Integer> post2 = new ArrayList<>();
        bt.postorder2(root, post2);
        System.out.println("Postorder_2 : " + post2);
    }
}
