package OOP.Encapsulation.ShoppingSpree;

import java.util.ArrayList;

public class Person {
    private String name;
    private double money;
    private ArrayList<Product> products;

    public Person(String name, double money) {
        this.products = new ArrayList<>();
        this.setName(name);
        this.setMoney(money);
    }

    private void setMoney(double money) {
        if (money < 0.0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s",
                    this.getName(),
                    product.getName()));
        }
            this.products.add(product);
            this.setMoney(this.money - product.getCost());

    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ");
        if(products.size() == 0) {
            sb.append("Nothing bought");
        } else {
            for (int i = 0; i < products.size(); i++) {
                if(i < products.size() - 1) {
                    sb.append(products.get(i).getName()).append(", ");

                }else {
                    sb.append(products.get(i).getName());
                }

            }
        }

        return sb.toString();
    }
}
