package entities.hospital.consoleBasedUI;

import javax.persistence.EntityManager;
import java.io.IOException;

public interface ConsoleBasedUI {

    void searchDataBase(EntityManager entityManager) throws IOException;



}
