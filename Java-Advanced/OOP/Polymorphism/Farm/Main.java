package OOP.Polymorphism.Farm;

import OOP.Polymorphism.Farm.animals.*;
import OOP.Polymorphism.Farm.food.Food;
import OOP.Polymorphism.Farm.food.Meat;
import OOP.Polymorphism.Farm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input;

        while (!"End".equals(input = scanner.nextLine())) {
            String[] animalData = input.split("\\s+");
            Animal animal = produceAnimal(animalData);
            System.out.println(animal.makeSound());
            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = produceFood(foodData);
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animals.add(animal);
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food produceFood(String[] foodData) {
        Food food = null;
        if(foodData[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodData[1]));
        } else  {
            food = new Meat(Integer.parseInt(foodData[1]));
        }
        return food;
    }

    private static Animal produceAnimal(String[] animalData) {
        Animal animal = null;
        String name = animalData[1];
        String type = animalData[0];
        double weight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];
        if(type.equals("Cat")) {
            animal = new Cat(name,type,weight,livingRegion,animalData[4]);
        } else if(type.equals("Tiger")) {
            animal = new Tiger(name,type,weight,livingRegion);
        } else if(type.equals("Zebra")) {
            animal = new Zebra(name,type,weight,livingRegion);
        } else if(type.equals("Mouse")) {
            animal = new Mouse(name,type,weight,livingRegion);
        }
        return animal;
    }

}
