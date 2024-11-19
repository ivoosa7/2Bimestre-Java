package br.araujo.product.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.araujo.product.Mapper.ProductMapper;
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

    public Product getProductById(long id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não encontrado"));
    }

    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Produto não encontrado");
        }
    }

    public Product save(Product product){
        return repository.save(product);
    }

    public void update(Product product, long id){
        Product aux = repository.getReferenceById(id);

        aux.setCategory(product.getCategory());
        aux.setName(product.getName());
        aux.setPrice(product.getPrice());

        repository.save(aux);
    }
}
