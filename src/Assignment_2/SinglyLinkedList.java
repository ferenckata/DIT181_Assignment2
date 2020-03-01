package Assignment_2;

import java.awt.*;
import java.util.EmptyStackException;

class SinglyLinkedList<Item> {

    private int size;
    private Node<Item> head;

    // -----------------------------------------------------------------------------------
    /**
     * ----------------- Helper methods -------------------------------------
     */
    /**
     * Linked list node helper data type
     *
     * @param <Item>
     */
    private static class Node<Item> {

        Node<Item> next = null;
        Item el = null;

    }

    public int size() {
        if(head == null){
            size = 0;
        }
        Node<Item> current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }
        size = count;
        return size;
    }

    // -----------------------------------------------------------------------------------
    /**
     * ----------------- ToDo: methods for you to implement
     * ---------------------------
     *
     */
    // -----------------------------------------------------------------------------------
    /**
     * Constructor of an empty Singly linked list
     *
     */
    public SinglyLinkedList() {

    }

    /**
     * Method to get an item from a specified index
     *
     * @param index of the element to return
     * @return the item from the specified index
     */
    public Item get(int index) {
        // ToDo: do not forget to implement a condition for index out of bounds
        // if such event would occur:
        if (index>=size() || index < 0) {
            throw new IllegalArgumentException("Index ouf of bounds");
        }
        Node<Item> current = null;
        if (index < size()) {
            current = head;
            for (int i = 0; i < index; i++) { // Change to one if index is meant to be position
                current = current.next;
            }
        }
        return current.el;

    }

    /**
     * Method to insert element newElement at specified index in the list
     *
     * @param index where you want to insert new element
     * @param newElement the object of type Item you want to insert
     */
    public void insertAt(int index, Item newElement) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Index ouf of bounds");
        }
        if (head == null){
            throw new RuntimeException("List is Empty");
        }
        if (index == 0){
            Node<Item> newNode = new Node<>();
            newNode.next = head;
            newNode.el = newElement;
            head = newNode;
        }
        else {
            Node<Item> current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            Node<Item> newNode = new Node<>();
            newNode.el = newElement;
            newNode.next = current.next;
            current.next = newNode;
        }

    }

    /**
     * Method to remove the element at the specified index from the list
     *
     * @param index the position to remove the item from
     */
    public void removeAt(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Index ouf of bounds");
        }
        if (head == null) {
            throw new RuntimeException("Cannot delete");
        }
        if (index == 0) {
            head = head.next;
        }
        else {
            Node<Item> current = head;
            Node<Item> before = null;
            int i = 0; //change to 1 if position is to be removed
            while (current != null && index != i) {
                before = current;
                current = current.next;
                i++;
            }
            if (current == null){
                throw new RuntimeException("cannot delete");
            }
            before.next = current.next;
        }
    }
    /**
     * Reverse the list
     *
     */
    public void reverse() {
        if (head==null){
            throw new RuntimeException("List is empty");
        }
        else {
            Node<Item> current = head;
            Node<Item> before = null;
            while (current != null) {
                Node<Item> nextNode = current.next;
                current.next = before;
                before = current;
                current = nextNode;
            }
        head = before;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        System.out.println("Size empty: " + testList.size());
        testList.addFirst(1);
        testList.addFirst(2);
        System.out.println("Size 2 elements: " + testList.size());
        testList.addFirst(3);
        testList.addFirst(4);
        testList.addFirst(5);
        testList.addFirst(6);

        System.out.print("\nSize " + testList.size());
        testList.printList();

        System.out.println("Item at index 2: " + testList.get(2));

        testList.reverse();
        System.out.print("\nSize " + testList.size());
        System.out.print("\nReverse: ");
        testList.printList();

        testList.removeAt(2);
        System.out.print("\nSize " + testList.size());
        System.out.print("\nRemoved item at index 2:");
        testList.printList();

        testList.insertAt(2, 3);
        System.out.print("\nSize " + testList.size());
        System.out.print("\nAdded 3 at index 2:");
        testList.printList();


    }

    private void printList(){
        Node<Item> itemNode = head;
        if (head == null){
            System.out.println("List is empty");
        }
        System.out.println();
        while (itemNode != null){
            System.out.print(itemNode.el + ", ");
            itemNode = itemNode.next;
        }
        System.out.println("\nEnd of list");

    }
    private void addFirst(Item item){
        Node<Item> newHead = new Node<>();
        newHead.el = item;
        if (head==null){
            head = newHead;
            newHead.next = null;
            return;
        }
        newHead.next = head;
        head = newHead;

    }
}
