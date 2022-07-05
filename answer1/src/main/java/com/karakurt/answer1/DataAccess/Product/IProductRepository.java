package com.karakurt.answer1.DataAccess.Product;

import com.karakurt.answer1.Entities.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
