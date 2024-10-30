package br.araujo.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.araujo.product.entities.Product;

                                                                //WrapperClasse
public interface RepositoryProduct extends JpaRepository<Product, Long>{

}


