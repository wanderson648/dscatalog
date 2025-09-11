package com.devsuperior.auladev.tests;

import com.devsuperior.auladev.entities.Category;
import com.devsuperior.auladev.entities.Product;
import com.devsuperior.auladev.entities.dto.ProductDTO;

import java.time.Instant;

public class Factory {

    public static Product createProduct() {

        var product = new Product(1L, "Phone", 9000.0,
                Instant.parse("2025-09-10T03:00:00Z"), "Good Phone", "https://img.com/img.png");

        product.getCategories().add(new Category(2L, "Eletronics"));
        return product;
    }

    public static ProductDTO createProductDTO() {
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }
}
