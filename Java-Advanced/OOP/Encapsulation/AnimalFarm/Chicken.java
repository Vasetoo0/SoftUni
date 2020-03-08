package OOP.Encapsulation.AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.getName(),
                this.getAge(),
                this.productPerDay());
    }

    private void setName(String name) {
        if(name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        double eggPerDay = 0;
        if(age >= 0 && age < 6) {
            eggPerDay = 2;
        } else if(age > 11) {
            eggPerDay = 0.75;
        } else {
            eggPerDay = 1;
        }
        return eggPerDay;
    }
}
