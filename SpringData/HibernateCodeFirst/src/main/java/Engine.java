import entities.hospital.consoleBasedUI.ConsoleBasedUI;
import entities.hospital.consoleBasedUI.ConsoleBasedUIImpl;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
//        ---------------------------
//        Console based UI for hospital_db. Exercise 04.!

////        ConsoleBasedUI Ui = new ConsoleBasedUIImpl();
//        try {
//            Ui.searchDataBase(this.entityManager);
//        } catch (IOException e) {
//            e.printStackTrace();
////        }
//        ----------------------------
    }
}
