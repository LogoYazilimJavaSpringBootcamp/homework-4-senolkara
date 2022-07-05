package com.karakurt.answer1.DataAccess.Product.MySQL;

import com.karakurt.answer1.DataAccess.Product.IProductDao;
import com.karakurt.answer1.DataAccess.Product.IProductRepository;
import com.karakurt.answer1.Entities.Product.Product;
import com.karakurt.answer1.Needs.Needs;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class MySQLProductDao implements IProductDao {
    private static final Date date = Needs.getCurrentDate();

    private IProductRepository iProductRepository;

    public MySQLProductDao(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return this.iProductRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return this.iProductRepository.findById(id).get();
    }

    @Override
    public Product createProduct(String name, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setLastDate(date);
        this.iProductRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, String name, Double price) {
        Product product = this.iProductRepository.findById(id).get();
        product.setName(name);
        product.setPrice(price);
        product.setLastDate(date);
        this.iProductRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        this.iProductRepository.deleteById(id);
    }
}
