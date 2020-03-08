package Advanced.IteratorsAndComparators.Exercise.ListlyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListlyIterator {

    private int index;
    private List<String> list;

    public ListlyIterator(){
        this.list = new ArrayList<>();
    }

    public ListlyIterator(List<String> list) {

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

    public boolean hasNext() {
        if (this.index < list.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        if(this.list.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            System.out.println(this.list.get(this.index));
        }
    }

}
