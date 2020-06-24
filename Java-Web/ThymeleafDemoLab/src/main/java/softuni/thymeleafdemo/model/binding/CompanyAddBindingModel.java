package softuni.thymeleafdemo.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class CompanyAddBindingModel {

    private String name;
    private String town;
    private String description;
    private BigDecimal budget;

    public CompanyAddBindingModel() {
    }

    @Length(min = 2, max = 10, message = "Name must be between 2 and 10 chars long!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 2, max = 10, message = "Town must be between 2 and 10 chars long!")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Length(min = 10, message = "Description must be at 10 chars long!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "Budget must be positive number!")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
