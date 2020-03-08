package Advanced.Generics.CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
       T element = this.elements.get(index);

       this.elements.remove(index);

       return element;
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {

        T firstElement = this.elements.get(firstIndex);
        this.elements.set(firstIndex,this.elements.get(secondIndex));
        this.elements.set(secondIndex,firstElement);
    }

    public int countGreaterThen(T element) {

        int count = 0;
        for (T item : this.elements) {
            if(item.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {

        T firstElement = this.elements.get(0);

        for (T element : this.elements) {
            if(firstElement.compareTo(element) < 0) {
                firstElement = element;
            }
        }

        return firstElement;
    }

    public T getMin(){
        T firstElement = this.elements.get(0);

        for (T element : this.elements) {
            if(firstElement.compareTo(element) > 0) {
                firstElement = element;
            }
        }

        return firstElement;
    }
}
