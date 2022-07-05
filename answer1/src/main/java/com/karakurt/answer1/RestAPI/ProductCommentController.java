package com.karakurt.answer1.RestAPI;

import com.karakurt.answer1.Business.ProductComment.IProductCommentService;
import com.karakurt.answer1.Business.ProductComment.ProductCommentService;
import com.karakurt.answer1.DataAccess.Product.IProductRepository;
import com.karakurt.answer1.DataAccess.ProductComment.IProductCommentRepository;
import com.karakurt.answer1.DataAccess.ProductComment.MySQL.MySQLProductCommentDao;
import com.karakurt.answer1.DataAccess.User.IUserRepository;
import com.karakurt.answer1.Entities.ProductComment.ProductComment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-comment-api")
public class ProductCommentController {
    private IProductCommentRepository iProductCommentRepository;
    private IUserRepository iUserRepository;
    private IProductRepository iProductRepository;
    private IProductCommentService iProductCommentService;

    public ProductCommentController(IProductCommentRepository iProductCommentRepository,
                                    IUserRepository iUserRepository,
                                    IProductRepository iProductRepository){
        this.iProductCommentRepository = iProductCommentRepository;
        this.iUserRepository = iUserRepository;
        this.iProductRepository = iProductRepository;
        this.iProductCommentService = new ProductCommentService(
                new MySQLProductCommentDao(
                        this.iProductCommentRepository,
                        this.iUserRepository,
                        this.iProductRepository
                )
        );
    }

    @GetMapping
    public List<ProductComment> getAllProductComment(){
        return this.iProductCommentService.getAllProductComment();
    }

    @GetMapping("/{id}")
    public ProductComment getProductComment(@PathVariable Long id){
        return this.iProductCommentService.getProductComment(id);
    }

    @PostMapping
    public ProductComment createProductComment(Long userId, Long productId, String comment){
        return this.iProductCommentService.createProductComment(userId, productId, comment);
    }

    @PatchMapping("/{id}")
    public ProductComment updateProductComment(@PathVariable Long id, String comment){
        return this.iProductCommentService.updateProductComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteProductComment(@PathVariable Long id){
        this.iProductCommentService.deleteProductComment(id);
    }
}
