package br.araujo.product.Mapper;

import br.araujo.product.dtos.ProductResponse;
import br.araujo.product.entities.Product;

public class ProductMapper {
    public static ProductResponse toDTO(Product product){
        return new ProductResponse(
            product.getId(), 
            product.getName(), 
            product.getPrice(), 
            product.getCategory());
    }
}
