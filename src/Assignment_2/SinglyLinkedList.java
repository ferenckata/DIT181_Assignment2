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
        throw new UnsupportedOperationException();

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
            for (int i = 0; i < index; i++) {
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
        // ToDo: again, check for exception
        if (index>size() || index < 0) {
            throw new IllegalArgumentException("Index ouf of bounds");
        }
        if (head == null){
            throw new RuntimeException("List is Empty");
        }
        if (index==size()) {
            Node<Item> current = head;
            while (current.next != null){
                current = current.next;
            }
            Node<Item> newNode = new Node<>();
            newNode.next = null;
            newNode.el = newElement;
            current.next = newNode;
            return;
        }
        if (index == 0){
            head.next = head;
            head = new Node<>();
            head.el = newElement;
        }
        else {
            Node<Item> current = head;
            for (int i = 0; i < index-1; i++){
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
            int i = 0;
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
        System.out.println(testList.size());
    }
}
