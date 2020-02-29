package Assignment_2;

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
        // throw new IllegalArgumentException("Index ouf of bounds");
        throw new UnsupportedOperationException();
    }

    /**
     * Method to insert element newElement at specified index in the list
     *
     * @param index where you want to insert new element
     * @param newElement the object of type Item you want to insert
     */
    public void insertAt(int index, Item newElement) {
        // ToDo: again, check for exception
        // throw new IllegalArgumentException("Index ouf of bounds");
        throw new UnsupportedOperationException();
    }

    /**
     * Method to remove the element at the specified index from the list
     *
     * @param index the position to remove the item from
     */
    public void removeAt(int index) {
        // ToDo: if (...) throw new IllegalArgumentException("Index ouf of bounds");
        throw new UnsupportedOperationException();
    }

    /**
     * Reverse the list
     *
     */
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        System.out.println(testList.size());
    }
}
