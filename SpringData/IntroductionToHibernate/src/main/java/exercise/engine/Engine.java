package exercise.engine;

import exercise.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
//        2.	Remove Objects
//        removeObjects();

//        3.	Contains Employee
//        try {
//            containsEmployee();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        4.	Employees with Salary Over 50 000
//        getEmployeeFirstNameWithSalary(new BigDecimal(50000));

//        5.	Employees from Department
//        employeesFromDepartment("Research and Development");

//        6.	Adding a New Address and Updating Employee
//        try {
//            setAddressToEmployeeWithGivenLastName();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        7.	Addresses with Employee Count
//        getAddressesWithCountOFEmployees();

//        8.	Get Employee with Project
//        try {
//            getEmployeeWithProjectsByGivenID();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        9.	Find Latest 10 Projects
//        findTenLatestProjects();

//        10.	Increase Salaries
//        increaseEmployeesSalaries();

//        11.	Remove Towns
//        try {
//            removeTownAndCorrespondingAddresses();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        12.	Find Employees by First Name
//        try {
//            findEmployeeByPatternForFirstName();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        13.	Employees Maximum Salaries
//        findMaxSalaryForDepartment();
    }

    private void removeObjects() {
        this.entityManager.getTransaction().begin();

        List<Town> towns = this.entityManager
                .createQuery("SELECT t FROM Town AS t WHERE LENGTH(t.name) <= 5", Town.class)
                .getResultList();

        for (Town town : towns) {
            this.entityManager.detach(town);

            town.setName(town.getName().toUpperCase());

            this.entityManager.merge(town);
        }
        this.entityManager.flush();
        entityManager.getTransaction().commit();
    }

    private void containsEmployee() throws IOException {
        this.entityManager.getTransaction().begin();

        System.out.println("Enter name:");
        String fullName = this.reader.readLine();

        try {

            Employee employee = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                    "WHERE concat(e.firstName,' ',e.lastName) = :name", Employee.class)
                    .setParameter("name", fullName)
                    .getSingleResult();

            System.out.println("Yes");

            this.entityManager.getTransaction().commit();

        } catch (NoResultException nre) {
            System.out.println("No");
        }
    }

    private void getEmployeeFirstNameWithSalary(BigDecimal salary) {
        this.entityManager.getTransaction().begin();

        this.entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.salary > :salary", Employee.class)
                .setParameter("salary", salary)
                .getResultList()
                .forEach((e) -> {
                    System.out.println(e.getFirstName());
                });
        this.entityManager.getTransaction().commit();
    }

    private void employeesFromDepartment(String depName) {
        this.entityManager.getTransaction().begin();

        try {

            this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                    "WHERE e.department.name = :depName " +
                    "ORDER BY e.salary ASC, e.id ASC", Employee.class)
                    .setParameter("depName", depName)
                    .getResultList()
                    .forEach((e) -> {
                        System.out.println(
                                String.format("%s %s from %s - $%.2f",
                                        e.getFirstName(),
                                        e.getLastName(),
                                        depName,
                                        e.getSalary()
                                ));
                    });
        } catch (NoResultException nR) {
            System.out.println("No such Department!");
        }


        this.entityManager.getTransaction().commit();
    }

    private void setAddressToEmployeeWithGivenLastName() throws IOException {
        System.out.println("Enter last name:");
        String employeeLastName = this.reader.readLine();

        Address address = this.createNewAddress("Vitoshka 15");

        try {
            this.entityManager.getTransaction().begin();
            List<Employee> employees = this.entityManager
                    .createQuery("SELECT e FROM Employee AS e " +
                            "WHERE e.lastName = :lastName", Employee.class)
                    .setParameter("lastName", employeeLastName)
                    .getResultList();

            employees.forEach(e -> {
                this.entityManager.detach(e);

                e.setAddress(address);

                this.entityManager.merge(e);
            });

            this.entityManager.flush();

            this.entityManager.getTransaction().commit();
        } catch (NoResultException nR) {
            System.out.println("No user with lastName exist!");
        }
    }

    private void getAddressesWithCountOFEmployees() {

        this.entityManager.getTransaction().begin();
        try {
            this.entityManager
                    .createQuery("SELECT a FROM Address AS a " +
                            "ORDER BY a.employees.size DESC", Address.class)
                    .getResultList()
                    .stream()
                    .limit(10)
                    .forEach((e) -> {
                        System.out.println(String.format(
                                "%s, %s - %d employees",
                                e.getText(),
                                e.getTown().getName(),
                                e.getEmployees().size()
                        ));
                    });
        } catch (NullPointerException e) {
            System.out.println("Can't find address!");
        }

        this.entityManager.getTransaction().commit();

    }

    private void getEmployeeWithProjectsByGivenID() throws IOException {
        System.out.println("Enter ID:");
        int id = Integer.parseInt(reader.readLine());

        try {
            this.entityManager.getTransaction().begin();

            Employee employee = this.entityManager
                    .createQuery("SELECT e FROM Employee AS e " +
                            "WHERE e.id = :id", Employee.class)
                    .setParameter("id", id)
                    .getSingleResult();

            List<Project> employeeProjects = employee.getProjects().stream()
                    .sorted(Comparator.comparing(Project::getName))
                    .collect(Collectors.toList());

            System.out.println(String.format(
                    "%s - %s",
                    employee.getFirstName() + " " + employee.getLastName(),
                    employee.getJobTitle()
            ));

            for (Project employeeProject : employeeProjects) {
                System.out.println("    " + employeeProject.getName());
            }
            this.entityManager.getTransaction().commit();
        } catch (NoResultException nR) {
            System.out.println("No user with given ID exist!");
        }
    }

    private void findTenLatestProjects() {

        this.entityManager.getTransaction().begin();

        List<Project> projects = this.entityManager
                .createQuery("SELECT p FROM Project AS p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .getResultList()
                .stream()
                .limit(10)
                .sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toList());

        for (Project project : projects) {
            System.out.println(String.format(
                    "Project name: %s%n" +
                            "   Project Description: %s%n" +
                            "   Project Start Date: %s%n" +
                            "   Project End Date: %s%n",
                    project.getName(),
                    project.getDescription(),
                    project.getStartDate().toString(),
                    project.getEndDate()
            ));

        }
        this.entityManager.getTransaction().commit();
    }

    private void increaseEmployeesSalaries() {
        this.entityManager.getTransaction().begin();

        List<Employee> employees = this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name IN('Engineering', 'Tool Design', 'Marketing','Information Services')", Employee.class)
                .getResultList();

        for (Employee employee : employees) {

            this.entityManager.detach(employee);

            employee.setSalary(BigDecimal.valueOf(employee.getSalary().doubleValue() * 1.12));

            this.entityManager.merge(employee);

            System.out.println(String.format(
                    "%s ($%.2f)",
                    employee.getFirstName() + " " + employee.getLastName(),
                    employee.getSalary().doubleValue()
            ));
        }

        this.entityManager.flush();

        this.entityManager.getTransaction().commit();
    }

    private void removeTownAndCorrespondingAddresses() throws IOException {
        System.out.println("Enter town name:");
        String townName = reader.readLine();

        Address newEmplAddress = this.createNewAddress("Ivan Vazov 66");

        try {
            this.entityManager.getTransaction().begin();
            Town town = this.entityManager.createQuery("SELECT t FROM Town AS t " +
                    "WHERE t.name = :name", Town.class)
                    .setParameter("name", townName)
                    .getSingleResult();

            List<Address> townAddresses = this.entityManager
                    .createQuery("SELECT a FROM Address AS a " +
                            "WHERE a.town.name = :name", Address.class)
                    .setParameter("name", town.getName())
                    .getResultList();

            int addressesCount = townAddresses.size();

            for (Address townAddress : townAddresses) {

                changeEmployeesAddress(newEmplAddress, townAddress);

                this.entityManager.remove(townAddress);
            }

            System.out.println(
                    String.format(
                            "%d address in %s deleted", addressesCount, townName
                    ));

            this.entityManager.remove(town);

            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (NoResultException nR) {
            System.out.println("No town with given name exist!");
        }

    }

    private void findEmployeeByPatternForFirstName() throws IOException {
        System.out.println("Enter pattern:");
        String pattern = reader.readLine();
        pattern += '%';

        this.entityManager.getTransaction().begin();
        this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.firstName LIKE (:pattern)", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .forEach(e -> {
                    System.out.println(String.format(
                            "%s - %s - ($%.2f)",
                            e.getFirstName() + " " + e.getLastName(),
                            e.getJobTitle(),
                            e.getSalary().doubleValue()
                    ));
                });
        this.entityManager.getTransaction().commit();

    }

    private void findMaxSalaryForDepartment() {

        this.entityManager.getTransaction().begin();
        this.entityManager
                .createQuery("SELECT d FROM Department AS d ", Department.class)
                .getResultList()
                .forEach(d -> {
                    double maxSalary = d.getEmployees()
                            .stream()
                            .max(Comparator.comparingDouble(a -> a.getSalary().doubleValue()))
                            .orElse(null).getSalary().doubleValue();

                    if (maxSalary < 30000 || maxSalary > 70000) {
                        System.out.println(String.format(
                                "%s %.2f",
                                d.getName(),
                                maxSalary
                        ));
                    }
                });
        this.entityManager.getTransaction().commit();
    }

    private Address createNewAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();

        return address;
    }

    private void changeEmployeesAddress(Address newEmplAddress, Address townAddress) {
        townAddress.getEmployees().forEach((e) -> {
            this.entityManager.detach(e);
            e.setAddress(newEmplAddress);
            this.entityManager.merge(e);
        });
    }
}
