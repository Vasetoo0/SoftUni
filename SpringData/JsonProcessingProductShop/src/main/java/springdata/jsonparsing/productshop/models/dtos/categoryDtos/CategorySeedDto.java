package springdata.jsonparsing.productshop.models.dtos.categoryDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class CategorySeedDto {

    @Expose
    private String name;

    public CategorySeedDto() {
    }


    @Length(min = 3,max = 15, message = "Name length not in range")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
