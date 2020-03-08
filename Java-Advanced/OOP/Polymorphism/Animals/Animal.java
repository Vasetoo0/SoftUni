package OOP.Polymorphism.Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    protected Animal(String name, String favoriteFood) {
        this.setName(name);
        this.setFavouriteFood(favoriteFood);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public abstract String explainSelf();

    @Override
    public String toString() {
        return String.format("I am %s and my favourite food is %s%n" + explainSelf(),
                this.getName(),
                this.getFavouriteFood());
    }
}
