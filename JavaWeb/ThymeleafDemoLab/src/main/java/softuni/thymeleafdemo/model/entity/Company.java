package softuni.thymeleafdemo.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    private BigDecimal budget;
    private String description;
    private String name;
    private String town;
    private Set<Employee> employees;

    public Company() {
    }

    @Column(nullable = false)
    @DecimalMin(value = "0", message = "Budget must be positive number!")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    @Length(min = 10, message = "Description must be at 10 chars long!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(unique = true, nullable = false)
    @Length(min = 2, max = 10, message = "Name must be between 2 and 10 chars long!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Length(min = 2, max = 10, message = "Town must be between 2 and 10 chars long!")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "company", cascade = CascadeType.REFRESH)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
