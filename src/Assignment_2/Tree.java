package Assignment_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree<Item extends Comparable<Item>> {
    // If the tree is empty, root is a null reference.

    private Node<Item> root = null;
    // A node of a tree contains a label, and optionally
    // references to the roots of its left and right subtrees,
    // which might be null if the subtrees are empty.

    public static class Node<Item> {

        public Node<Item> left = null;
        public Node<Item> right = null;
        public Item el = null;
        // Will print out the binary node structure

        public void print() {
            print("", true);
        }

        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + el.toString());
            if (right != null) {
                right.print(prefix + (isTail ? "    " : "│   "), false);
            }
            if (left != null) {
                left.print(prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // For unit testing purposes
    public void setRoot(Node<Item> newRoot) {
        root = newRoot;
    }

    public Node<Item> getRoot() {
        return root;
    }

    // This method constructs the following
    // example tree with 5 in the root:
    //
    //   __5__
    //  /     \
    // /       \
    // 1       8
    //  \     /  \
    //  2    1    3
    //      / \
    //     5   7
    public static Tree<Integer> exampleTree() {
        Node<Integer> t = new Node<>();
        t.el = 5;
        Node<Integer> t1 = new Node<>();
        t.left = t1;
        t1.el = 1;
        Node<Integer> t2 = new Node<>();
        t.right = t2;
        t2.el = 8;
        Node<Integer> t12 = new Node<>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<>();
        t2.left = t21;
        t21.el = 1;
        Node<Integer> t22 = new Node<>();
        t2.right = t22;
        t22.el = 3;
        Node<Integer> t211 = new Node<>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<>();
        t21.right = t212;
        t212.el = 7;
        Tree<Integer> res = new Tree<>();
        res.root = t;
        return res;
    }

    // This method constructs the following
    // example binary tree with 4 in the root:
    //
    //      __4__
    //     /     \
    //    /       \
    //   1         8
    //    \       / \
    //     2     6   9
    //          / \
    //          5 7
    public static Tree<Integer> exampleTreeBin() {
        Node<Integer> t = new Node<>();
        t.el = 4;
        Node<Integer> t1 = new Node<>();
        t.left = t1;
        t1.el = 1;
        Node<Integer> t2 = new Node<>();
        t.right = t2;
        t2.el = 8;
        Node<Integer> t12 = new Node<>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<>();
        t2.left = t21;
        t21.el = 6;
        Node<Integer> t22 = new Node<>();
        t2.right = t22;
        t22.el = 9;
        Node<Integer> t211 = new Node<>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<>();
        t21.right = t212;
        t212.el = 7;

        Tree<Integer> res = new Tree<>();
        res.root = t;
        return res;
    }

    /**
     * returns the size of the tree
     *
     * @return number of nodes in the tree
     */
    public int size() {
        return size(root);
    }

    private int size(Node<Item> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * Hands on session 7, exercise 1. Returns the n:th element in Depth First
     * Search
     *
     * @param n the node to find
     * @return the element in the n:th place
     *
     */
    public Item nthDFS(int n) {
        throw new UnsupportedOperationException();
    }

    /**
     * Hands on session 7, exercise 2. Prints the labels of the tree's nodes in
     * breadth first order (BFS)
     *
     */
    public void printBFT() {
        throw new UnsupportedOperationException();
    }

    /**
     * Hands on session 7, exercise 3. Removes one item from a binary search
     * tree and then rearranges the nodes so that the tree after the item is
     * removed is still a binary search tree.
     * Wrapper method
     * @param i - the item to remove
     */
    public void removeBST(Item item) {

        // This method mainly calls deleteRec()
        root = deleteRec(root, item);

    }

    /**
     * A recursive function to delete a new element in BST, assuming existing
     * tree is BST.
     * The auxiliary method
     * @param root the current root node
     * @param i the Item to delete
     * @return the new root node
     */
    private Node<Item> deleteRec(Node<Item> root, Item item) {
        throw new UnsupportedOperationException();
    }

    /**
     * Assignment 2 Question 7. Returns the nth element in Breadth First Search
     * (BFS) order
     *
     * @param n the position
     * @return the element found at the position
     */
    public Item nthBFS(int n) {

        Queue<Node> queue = new LinkedList<Node>();

        if (root == null || n < 0 || n >= size(root)){
            throw new IllegalArgumentException("Tree is empty or invalid position request.");
        }
        if (n == 0){
            return root.el;
        }
        queue.add(root);
        Node node = null;
        int count = 0;
        while (!queue.isEmpty() && count != n) {
            node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            count++;
        }
        return (Item) queue.poll().el;
    }

    /**
     * Assignment 2 Question 8. Returns a string that contains the nodes of the
     * tree in depth-first order
     */
    public String DFSToString() {

        if (root == null){
            return "";
        }
        ArrayList<String> numbers = new ArrayList();
        DFSToString(root, numbers);

        String numberString = String.join(",", numbers);
        return numberString;
    }

    public String DFSToStringWithStack(){
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        StringBuilder string = new StringBuilder();
        while (!stack.isEmpty()){
            Node current = stack.pop();
            string.append(current.el).append(",");
            if (current.right != null){
                stack.add(current.right);
            }
            if (current.left != null){
                stack.add(current.left);
            }
        }
        string.setLength(string.length()-1);
        return String.valueOf(string);
    }

    private ArrayList<String> DFSToString(Node root, ArrayList<String> numbers){

        if (root == null){
            return numbers;
        }
        numbers.add(String.valueOf(root.el));
        DFSToString(root.left, numbers);
        DFSToString(root.right, numbers);

        return numbers;
    }


    /**
     * Assignment 2, Question 9. Insert i into a binary search tree
     *
     * @param i the Item to insert
     */
    public void insertBST(Item item) {
        int number = (Integer) item;
        root = insertBST(number, root);
        System.out.println("Insertion successful!");
    }

    private Node insertBST(int number, Node node){

        if (node == null){
            node = new Node();
            node.el = number;
            return node;
        }
        if (number < (Integer) node.el){
            node.left = insertBST(number, node.left);
        }
        else if (number >= (Integer) node.el){ // If number is equal to an already existing, it is put on the right side
            node.right = insertBST(number, node.right);
        }
        return node;
    }

    /**
     * A method for visualization and debugging
     */
    public void printTree() {
        if (root != null) {
            root.print();
        }
    }

    public static void main(String[] args) {
        Tree<Integer> t = exampleTreeBin();
        /*System.out.println("Size: " + t.size());
        t.printTree();
        System.out.println(t.DFSToString());*/
        //System.out.println(t.DFSToStringWithStack());
        //System.out.println(t.nthBFS(7));
        t.insertBST(-1);
        t.printTree();
    }
}

