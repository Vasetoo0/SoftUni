package Advanced.DefiningClasses.CompanyRoaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Department> departments = new HashMap<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] data = reader.readLine().split("\\s+");

            Employee employee = new Employee(data[0], Double.parseDouble(data[1]), data[2]);

            if (data.length == 5) {
                if (Character.isDigit(data[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(data[4]));
                } else {
                    employee.setEmail(data[4]);
                }
            } else if (data.length == 6) {
                employee.setEmail(data[4]);
                employee.setAge(Integer.parseInt(data[5]));
            }

            String departmentName = data[3];

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department());
            }

            departments.get(departmentName).addEmployee(employee);

        }

        Map.Entry<String, Department> highestAvgSalary = departments.entrySet().stream()
                .sorted((s1,s2) -> Double.compare(s2.getValue().getAvarage(),s1.getValue().getAvarage()))
                .findFirst()
                .get();

        System.out.println(String.format("Highest Average Salary: %s", highestAvgSalary.getKey()));

        highestAvgSalary.getValue().getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(String.format("%s %.2f %s %s",
                        e.getName(),
                        e.getSalary(),
                        e.getEmail(),
                        e.getAge()))
                );


    }
}
