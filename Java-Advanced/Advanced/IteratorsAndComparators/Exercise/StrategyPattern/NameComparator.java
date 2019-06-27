package Advanced.IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Comparator;

public class NameComparator  implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getName().length() == o2.getName().length()) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
        return o1.getName().length() - o2.getName().length();
    }
}
