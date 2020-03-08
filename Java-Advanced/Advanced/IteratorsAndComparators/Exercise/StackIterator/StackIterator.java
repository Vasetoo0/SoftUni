package Advanced.IteratorsAndComparators.Exercise.StackIterator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class StackIterator implements Iterable<Integer> {

    private List<Integer> stack;

    public StackIterator() {
        this.stack = new ArrayList<>();
    }

    public void push(int num) {
        this.stack.add(num);
    }

    public int pop() {
        int popedNum = 0;
        if (this.stack.size() == 0) {
            throw new EmptyStackException();
        } else {
            popedNum = this.stack.get(this.stack.size() - 1);
            this.stack.remove(this.stack.size() - 1);
            return popedNum;
        }
    }

    private final class IteratorForStack implements java.util.Iterator<Integer> {

        int index = stack.size() - 1;
        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            return stack.get(index--);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorForStack();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterator<Integer> iter = this.iterator();
        while (iter.hasNext()) {
            action.accept(iter.next());
        }
    }
}
