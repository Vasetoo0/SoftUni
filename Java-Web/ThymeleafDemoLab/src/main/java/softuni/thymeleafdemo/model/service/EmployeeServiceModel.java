package softuni.thymeleafdemo.model.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class EmployeeServiceModel extends BaseServiceModel {

    private LocalDate birthdate;
    private String educationLevel;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private BigDecimal salary;
    private CompanyServiceModel company;

    public EmployeeServiceModel() {
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getSalary() {

        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void setCompany(CompanyServiceModel company) {
        this.company = company;
    }
}
