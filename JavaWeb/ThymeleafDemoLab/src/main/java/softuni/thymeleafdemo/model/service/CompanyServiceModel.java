package softuni.thymeleafdemo.model.service;


import java.math.BigDecimal;

public class CompanyServiceModel extends BaseServiceModel {

    private BigDecimal budget;
    private String description;
    private String name;
    private String town;

    public CompanyServiceModel() {
    }


    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
