package br.araujo.product.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.araujo.product.Mapper.ProductMapper;
import br.araujo.product.dtos.ProductRequest;
import br.araujo.product.dtos.ProductResponse;
import br.araujo.product.entities.Product;
import br.araujo.product.repositories.RepositoryProduct;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private RepositoryProduct repository;

    public List<ProductResponse> getAllProducts(){
        return repository.findAll().stream()
                                   .map(p -> ProductMapper.toDTO(p))
                                   .collect(Collectors.toList());
    }

    public ProductResponse getProductById(long id){
        Product product = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não encontrado"));

            return ProductMapper.toDTO(product);
    }

    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }

    public ProductResponse save(ProductRequest product){
        Product newProduct = repository.save(ProductMapper.toEntity(product));
        return ProductMapper.toDTO(newProduct);
    }

    public void update(ProductRequest product, long id){
        Product aux = repository.getReferenceById(id);

        aux.setCategory(product.category());
        aux.setName(product.name());
        aux.setPrice(product.price());

        repository.save(aux);
    }
}
