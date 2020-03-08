package OOP.Encapsulation.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public String getFlourType() {
        return this.flourType;
    }

    public String getBakingTechnique() {
        return this.bakingTechnique;
    }

    public double getWeight() {
        return this.weight;
    }

    double calculateCalories() {
        return (2 * this.getWeight()) * getTypeModifier(this.getFlourType()) * getTechniqueModifier(this.getBakingTechnique());

    }

    private void setWeight(double weight) {
        Validator.validateDoughWeight(weight);
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.validateDoughTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType) {
        Validator.validateDoughType(flourType);
        this.flourType = flourType;
    }

    private double getTypeModifier(String flowerType) {
        double modifier = 1;
        if ("White".equalsIgnoreCase(flowerType)) {
            modifier = 1.5;
        }
        return modifier;
    }

    private double getTechniqueModifier(String bakingTechnique) {
        double modifier = 1;
        if ("Crispy".equalsIgnoreCase(bakingTechnique)) {
            modifier = 0.9;
        } else if ("Chewy".equalsIgnoreCase(bakingTechnique)) {
            modifier = 1.1;
        }
        return modifier;
    }

}
