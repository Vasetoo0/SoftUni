package Advanced.WorkShop.CustomDeque;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomDeque {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public CustomDeque() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            resize();
        }

        this.data[this.size++] = element;
    }

    public int pop() {
        checkEmpty();

        int element = this.data[this.size - 1];
        this.size--;
        return element;
    }
    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }



    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty!");
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] copyArr = new int[this.capacity];

        System.arraycopy(this.data, 0, copyArr, 0, this.data.length);

        this.data = copyArr;
    }
}
