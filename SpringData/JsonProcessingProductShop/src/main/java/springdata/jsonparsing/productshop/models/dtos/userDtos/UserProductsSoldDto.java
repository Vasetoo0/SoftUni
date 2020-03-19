package springdata.jsonparsing.productshop.models.dtos.userDtos;

import com.google.gson.annotations.Expose;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductCountDto;

public class UserProductsSoldDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private ProductCountDto soldProducts;

    public UserProductsSoldDto() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductCountDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductCountDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
