package com.karakurt.answer1.DataAccess.Product;

import com.karakurt.answer1.Entities.Product.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAllProduct();
    Product getProduct(Long id);
    Product createProduct(String name, Double price);
    Product updateProduct(Long id, String name, Double price);
    void deleteProduct(Long id);
}
