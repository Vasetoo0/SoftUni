package entities.sales.factory;

import entities.sales.Customer;
import entities.sales.Product;
import entities.sales.Sale;
import entities.sales.StoreLocation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class SalesFactory {

    public static StoreLocation createStoreLocation(String locationName, Set<Sale> sales) {

        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName(locationName);
        storeLocation.setSales(sales);

        return storeLocation;
    }

    public static Customer createCustomer(String name, String email,
                                          String creditCardNumber,
                                          Set<Sale> sales) {

        Customer customer = new Customer();
        customer.setCreditCardNumber(creditCardNumber);
        customer.setEmail(email);
        customer.setName(name);
        customer.setSales(sales);

        return customer;
    }

    public static Product createProduct(String name, BigDecimal price,
                                        Double quantity, Set<Sale> sales) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setSales(sales);

        return product;
    }

    public static Sale createSale(Customer customer, Product product,
                                  StoreLocation storeLocation, LocalDate localDate) {

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setDate(localDate);
        sale.setProduct(product);
        sale.setStoreLocation(storeLocation);

        return sale;
    }
}
