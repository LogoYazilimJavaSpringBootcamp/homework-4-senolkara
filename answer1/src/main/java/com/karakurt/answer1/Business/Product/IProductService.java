package com.karakurt.answer1.Business.Product;

import com.karakurt.answer1.Entities.Product.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    Product getProduct(Long id);
    Product createProduct(String name, Double price);
    Product updateProduct(Long id, String name, Double price);
    void deleteProduct(Long id);
}
