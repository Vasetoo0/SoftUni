package Advanced.IteratorsAndComparators.Exercise.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Collection implements Iterable<String> {
    private int index;
    private List<String> list;

    public Collection() {
        this.list = new ArrayList<>();
    }

    public Collection(List<String> list) {

        this.list = list;
        this.index = 0;
    }

    public boolean move() {
        if (this.index < list.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public void printAll() {
        if (this.list.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        } else {

            this.list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }


    public boolean hasNext() {
        if (this.index < list.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        if (this.list.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            System.out.println(this.list.get(this.index));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }
}

