package br.araujo.product.Mapper;

import br.araujo.product.dtos.ProductRequest;
import br.araujo.product.dtos.ProductResponse;
import br.araujo.product.entities.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setCategory(productRequest.category());

        return product;
    }

    public static ProductResponse toDTO(Product product){
        return new ProductResponse(
            product.getId(), 
            product.getName(), 
            product.getPrice(), 
            product.getCategory());
    }
}
