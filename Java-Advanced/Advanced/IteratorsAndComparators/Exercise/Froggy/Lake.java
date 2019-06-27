package Advanced.IteratorsAndComparators.Exercise.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer>{

    private List<Integer> lake;

    public Lake() {
        this.lake = new ArrayList<>();
    }

    public Lake(List<Integer> lake) {
        this.lake = lake;
    }

    public List<Integer> getLake() {
        return lake;
    }

    public class Frog implements Iterator<Integer> {

        private int cursor = lake.size() == 0 ? 0 : -2;

        private boolean isEvenCursor() {
            return cursor % 2 == 0;
        }

        @Override
        public boolean hasNext() {
            if (isEvenCursor() && lake.size() > 2) {
                return true;
            } else if (!isEvenCursor() && lake.size() > 2) {
                return cursor < lake.size() - 2;
            } else {
                return cursor < lake.size() - 1;
            }
        }

        @Override
        public Integer next() {
            cursor += 2;

            if (cursor > lake.size() - 1) {
                cursor = 1;
            }

            return lake.get(cursor);
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }


    public void forEachOdd(Consumer<? super Integer> action) {
        Iterator<Integer> oddIter = this.iterator();
        while (oddIter.hasNext()) {

                action.accept(oddIter.next());

        }
    }


}
