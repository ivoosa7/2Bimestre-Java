package br.araujo.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.araujo.product.entities.Product;
import br.araujo.product.repositories.RepositoryProduct;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private RepositoryProduct repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(Long id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Produto não encontrado"));
    }
}
