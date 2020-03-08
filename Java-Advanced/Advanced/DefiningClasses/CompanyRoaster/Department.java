package Advanced.DefiningClasses.CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;

    Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAvarage() {
       return this.employees.stream()
                .mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
