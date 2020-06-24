package softuni.thymeleafdemo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.thymeleafdemo.model.entity.Employee;
import softuni.thymeleafdemo.model.service.EmployeeServiceModel;
import softuni.thymeleafdemo.repository.EmployeeRepository;
import softuni.thymeleafdemo.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(EmployeeServiceModel employeeServiceModel) {

        this.employeeRepository.saveAndFlush(this.modelMapper
                .map(employeeServiceModel, Employee.class));
    }

    @Override
    public List<EmployeeServiceModel> getAll() {

        return this.employeeRepository.findAll()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeServiceModel getById(Long id) {
        return this.employeeRepository.findById(id)
                .map(e -> this.modelMapper.map(e, EmployeeServiceModel.class))
                .orElse(null);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Employee employee = this.employeeRepository.findById(id).orElse(null);

        this.employeeRepository.deleteById(id);
    }
}
