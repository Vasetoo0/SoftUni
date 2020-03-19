package springdata.jsonparsing.productshop.models.dtos.categoryDtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CategoryProductCountDto {

    @Expose
    private String category;
    @Expose
    private int productsCount;
    @Expose
    private double averagePrice;
    @Expose
    private double totalRevenue;

    public CategoryProductCountDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }


    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
