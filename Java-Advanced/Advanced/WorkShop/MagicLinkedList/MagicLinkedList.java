package Advanced.WorkShop.MagicLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MagicLinkedList {
    private class Node{
        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element){
        Node newNode = new Node(element);

        if(this.size == 0) {
            this.head = this.tail = newNode;
        }else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);

        if(this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);

        if(index <= this.size/2) {
            Node firstNode = this.head;

            for (int i = 0; i < index ; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.element;
        } else {
            Node lastNode = this.tail;

            for (int i = this.size - 1; i > index ; i--) {

                lastNode = lastNode.prev;
            }
            return lastNode.element;
        }
    }

    public int removeFirst() {
        checkSize();

        int firstElement = this.head.element;
        this.head = this.head.next;

        if(this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }

        this.size--;
        return firstElement;
    }
    public int removeLast(){
        checkSize();

        int lastElement = this.tail.element;
        this.tail = this.tail.prev;

        if(this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.size--;
        return lastElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        int counter = 0;

        Node currentNode = this.head;

        while (currentNode != null) {
            array[counter++] = currentNode.element;
            currentNode = currentNode.next;
        }
        return array;
    }

    private void checkSize() {
        if(this.size == 0){
            throw new NoSuchElementException("This list is empty");
        }
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, this.size));
        }
    }

}
