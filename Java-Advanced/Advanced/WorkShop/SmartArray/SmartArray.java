package Advanced.WorkShop.SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if(this.size == this.capacity) {
            this.resize();
        }

        this.data[size++] = element;
    }

    public int get(int index) {
        checkIndex(index);

        return this.data[index];
    }

    public void remove(int index) {
        checkIndex(index);

        int element = this.data[index];
        shift(index);
        this.size--;

        if(this.size <= this.capacity / 4) {
            shrink();
        }

    }

    public void add(int index, int element) {
        checkIndex(index);

        if(this.size == this.capacity) {
            resize();
        }

        if(index == this.size-1) {
            add(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        } else {
            this.size++;
            shiftToRight(index);
            this.data[index] = element;
        }

    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void shiftToRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void shrink() {
        this.capacity /= 2;
        int[] copyArr = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            copyArr[i] = this.data[i];
        }

        this.data = copyArr;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = 0;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d",
                    index,
                    this.size));
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] copyArr = new int[this.capacity];

        System.arraycopy(this.data, 0, copyArr, 0, this.data.length);

        this.data = copyArr;
    }

}
