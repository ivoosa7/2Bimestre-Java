package br.araujo.product.dtos;

public record ProductResponse (
    Long id,
    String name,
    Double price,
    String category
) {
    
}
