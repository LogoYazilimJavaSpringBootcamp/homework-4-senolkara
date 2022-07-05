package com.karakurt.answer1.RestAPI;

import com.karakurt.answer1.Business.Product.IProductService;
import com.karakurt.answer1.Business.Product.ProductService;
import com.karakurt.answer1.DataAccess.Product.IProductRepository;
import com.karakurt.answer1.DataAccess.Product.MySQL.MySQLProductDao;
import com.karakurt.answer1.Entities.Product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api")
public class ProductController {

    private IProductRepository iProductRepository;

    private IProductService iProductService;

    public ProductController(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
        this.iProductService = new ProductService(
                new MySQLProductDao(
                        this.iProductRepository
                )
        );
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return this.iProductService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return this.iProductService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(String name, Double price){
        return this.iProductService.createProduct(name, price);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, String name, Double price){
        return this.iProductService.updateProduct(id, name, price);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.iProductService.deleteProduct(id);
    }
}
