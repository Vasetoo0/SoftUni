package exercise;

import exercise.engine.Engine;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        Engine engine = new Engine(emf.createEntityManager());

        engine.run();    }
}
