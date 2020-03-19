package springdata.jsonparsing.productshop.services;


import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductByPriceDto;
import springdata.jsonparsing.productshop.models.dtos.productDtos.ProductSeedDto;

import java.util.List;

public interface ProductService {

    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductByPriceDto> getAllByPriceBetweenAndNoBuyer();

}
