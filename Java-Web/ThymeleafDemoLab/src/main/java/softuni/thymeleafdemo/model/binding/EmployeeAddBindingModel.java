package softuni.thymeleafdemo.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.thymeleafdemo.model.entity.Company;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeAddBindingModel {

    private LocalDate birthdate;
    private String educationLevel;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private BigDecimal salary;
    private String company;

    public EmployeeAddBindingModel() {
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "BirthDate should be in the past!")
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @NotNull(message = "Education level needed!")
    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Length(min = 2, message = "First name must be at least 2 chars long!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Length(min = 2, message = "Last name must be at least 2 chars long!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull(message = "Job title needed!")
    @Length(min = 2, message = "Job title must be min two chars long!")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @DecimalMin(value = "0", message = "Salary must be positive!")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull(message = "Company needed!")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
