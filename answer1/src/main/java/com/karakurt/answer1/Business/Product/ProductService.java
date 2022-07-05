package com.karakurt.answer1.Business.Product;

import com.karakurt.answer1.DataAccess.Product.IProductDao;
import com.karakurt.answer1.Entities.Product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private IProductDao iProductDao;

    public ProductService(IProductDao iProductDao){
        this.iProductDao = iProductDao;
    }

    @Override
    public List<Product> getAllProduct() {
        return this.iProductDao.getAllProduct();
    }

    @Override
    public Product getProduct(Long id) {
        return this.iProductDao.getProduct(id);
    }

    @Override
    public Product createProduct(String name, Double price) {
        return this.iProductDao.createProduct(name, price);
    }

    @Override
    public Product updateProduct(Long id, String name, Double price) {
        return this.iProductDao.updateProduct(id, name, price);
    }

    @Override
    public void deleteProduct(Long id) {
        this.iProductDao.deleteProduct(id);
    }
}
