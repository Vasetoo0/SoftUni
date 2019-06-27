package Advanced.IteratorsAndComparators.Exercise.ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        if(this.name.compareTo(o.name) == 0) {
            if(this.age == o.age) {
                return this.town.compareTo(o.town);
            } else {
                return this.age - o.age;
            }
        }
        return this.name.compareTo(o.name);
    }
}
