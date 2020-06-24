package softuni.thymeleafdemo.service;

import softuni.thymeleafdemo.model.service.EmployeeServiceModel;

import java.util.List;

public interface EmployeeService {

    void addEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> getAll();

    EmployeeServiceModel getById(Long id);

    void deleteById(Long id);
}
