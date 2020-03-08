package entities.hospital.consoleBasedUI;

import entities.hospital.Diagnose;
import entities.hospital.Medicament;
import entities.hospital.Patient;
import entities.hospital.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleBasedUIImpl implements ConsoleBasedUI {

    private final BufferedReader reader;

    public ConsoleBasedUIImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void searchDataBase(EntityManager entityManager) throws IOException {
        System.out.println(
                "Select what info do you need.Choose from 'patients', 'visitations', 'diagnoses', 'medicaments'!" +
                        System.lineSeparator() +
                        "Write it: "
        );

        String options = reader.readLine();

        System.out.println("Write 'one' for single entity. " +
                "Or 'all' for all entities." +
                System.lineSeparator() +
                "Choose: ");
        String option = reader.readLine();

        switch (options) {
            case "patients":
                switch (option) {
                    case "one":
                        getOnePatientByName(entityManager);
                        break;
                    case "all":
                        getAllPatients(entityManager);
                        break;
                    default:
                        System.out.println("No such option!");
                        break;
                }
                break;
            case "visitations":
                switch (option) {
                    case "one":
                        getOneVisitationById(entityManager);
                        break;
                    case "all":
                        getAllVisitations(entityManager);
                        break;
                    default:
                        System.out.println("No such option!");
                        break;
                }
                break;
            case "diagnoses":
                switch (option) {
                    case "one":
                        getOneDiagnoseById(entityManager);
                        break;
                    case "all":
                        getAllDiagnoses(entityManager);
                        break;
                    default:
                        System.out.println("No such option!");
                        break;
                }
                break;
            case "medicaments":
                switch (option) {
                    case "one":
                        getOneMedicamentById(entityManager);
                        break;
                    case "all":
                        getAllMedicaments(entityManager);
                        break;
                    default:
                        System.out.println("No such option!");
                        break;
                }
                break;
            default:
                System.out.println("There is no such info in DataBase!");
                break;
        }

    }

    private void getAllPatients(EntityManager entityManager) {
        entityManager.createQuery("select p from Patient as p", Patient.class)
                .getResultList()
                .forEach(p -> {
                    printPatientInfo(p);
                    System.out.println("---------------------");
                });
    }

    private void getOnePatientByName(EntityManager entityManager) throws IOException {
        System.out.println("Write Patient name: ");
        String patientName = reader.readLine();

        try {
            Patient patient = entityManager.createQuery("select p from Patient as p " +
                    "where concat(p.firstName,' ',p.lastName) = :name ", Patient.class)
                    .setParameter("name", patientName)
                    .getSingleResult();

            printPatientInfo(patient);
        } catch (NoResultException nr) {
            System.out.println("No such patient!");
        }
    }

    private void printPatientInfo(Patient p) {
        System.out.println(String.format("Id: %d%n" +
                        "Address: %s%n" +
                        "DateOfBirth: %s%n" +
                        "Email: %s%n" +
                        "Name: %s %s%n" +
                        "HaveMedInsurance: %s%n",
                p.getId(),
                p.getAddress(),
                p.getDateOfBirth(),
                p.getEmail(),
                p.getFirstName(),
                p.getLastName(),
                p.isHaveMedInsurance()));
    }

    private void getAllVisitations(EntityManager entityManager) {
        entityManager.createQuery("select v from Visitation as v", Visitation.class)
                .getResultList()
                .forEach(v -> {
                    printVisitationInfo(v);
                    System.out.println("------------------");
                });
    }

    private void getOneVisitationById(EntityManager entityManager) throws IOException {
        System.out.println("Write visitation ID:");
        int id = Integer.parseInt(reader.readLine());

        try {
            Visitation visitation = entityManager.createQuery("select v From Visitation as v where v.id = :id", Visitation.class)
                    .setParameter("id", id)
                    .getSingleResult();

            printVisitationInfo(visitation);
        } catch (NoResultException nr) {
            System.out.println("No such visitation!");
        }
    }

    private void printVisitationInfo(Visitation visitation) {
        System.out.println(String.format("Id: %d%n" +
                        "Date: %s%n",
                visitation.getId(),
                visitation.getDate()));

        visitation.getComments().forEach(c -> {
            System.out.println("Comment: " + c.getComment());
        });
    }

    private void getAllDiagnoses(EntityManager entityManager) {
        entityManager.createQuery("select d from Diagnose as d", Diagnose.class)
                .getResultList()
                .forEach(d -> {
                    printDiagnoseInfo(d);
                    System.out.println("------------------");
                });
    }

    private void getOneDiagnoseById(EntityManager entityManager) throws IOException {
        System.out.println("Write Diagnose id: ");
        int id = Integer.parseInt(reader.readLine());

        try {
            Diagnose diagnose = entityManager.createQuery("select d from Diagnose as d " +
                    "where d.id = :id ", Diagnose.class)
                    .setParameter("id", id)
                    .getSingleResult();

            printDiagnoseInfo(diagnose);
        } catch (NoResultException nr) {
            System.out.println("No such patient!");
        }
    }

    private void printDiagnoseInfo(Diagnose diagnose) {
        System.out.println(String.format("Id: %d%n" +
                        "Name: %s%n",
                diagnose.getId(),
                diagnose.getName()));

        diagnose.getComments().forEach(c -> {
            System.out.println("Comment: " + c.getComment());
        });
    }

    private void getAllMedicaments(EntityManager entityManager) {
        entityManager.createQuery("select e from Medicament as e", Medicament.class)
                .getResultList()
                .forEach(m -> {
                    printMedicamentInfo(m);
                    System.out.println("---------------------");
                });
    }

    private void getOneMedicamentById(EntityManager entityManager) throws IOException {
        System.out.println("Write Medicament id: ");
        int id = Integer.parseInt(reader.readLine());

        try {
            Medicament medicament = entityManager.createQuery("select m from Medicament as m " +
                    "where m.id = :id ", Medicament.class)
                    .setParameter("id", id)
                    .getSingleResult();

            printMedicamentInfo(medicament);
        } catch (NoResultException nr) {
            System.out.println("No such patient!");
        }
    }

    private void printMedicamentInfo(Medicament medicament) {
        System.out.println(String.format("Id: %d%n" +
                        "Name: %s%n",
                medicament.getId(),
                medicament.getName()));
    }
}

