package com.karakurt.answer1.DataAccess.ProductComment.MySQL;

import com.karakurt.answer1.DataAccess.Product.IProductRepository;
import com.karakurt.answer1.DataAccess.ProductComment.IProductCommentDao;
import com.karakurt.answer1.DataAccess.ProductComment.IProductCommentRepository;
import com.karakurt.answer1.DataAccess.User.IUserRepository;
import com.karakurt.answer1.Entities.Product.Product;
import com.karakurt.answer1.Entities.ProductComment.ProductComment;
import com.karakurt.answer1.Entities.User.User;
import com.karakurt.answer1.Needs.Needs;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class MySQLProductCommentDao implements IProductCommentDao {

    private static final Date date = Needs.getCurrentDate();
    private IProductCommentRepository iProductCommentRepository;
    private IUserRepository iUserRepository;
    private IProductRepository iProductRepository;

    public MySQLProductCommentDao(IProductCommentRepository iProductCommentRepository,
                                  IUserRepository iUserRepository,
                                  IProductRepository iProductRepository){
        this.iProductCommentRepository = iProductCommentRepository;
        this.iUserRepository = iUserRepository;
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<ProductComment> getAllProductComment() {
        return this.iProductCommentRepository.findAll();
    }

    @Override
    public ProductComment getProductComment(Long id) {
        return this.iProductCommentRepository.findById(id).get();
    }

    @Override
    public ProductComment createProductComment(Long userId, Long productId, String comment) {
        User user = this.iUserRepository.findById(userId).get();
        Product product = this.iProductRepository.findById(productId).get();
        ProductComment productComment = new ProductComment();
        productComment.setUser(user);
        productComment.setProduct(product);
        productComment.setComment(comment);
        productComment.setCommentDate(date);
        this.iProductCommentRepository.save(productComment);
        return productComment;
    }

    @Override
    public ProductComment updateProductComment(Long id, String comment) {
        ProductComment productComment = this.iProductCommentRepository.findById(id).get();
        productComment.setComment(comment);
        productComment.setCommentDate(date);
        this.iProductCommentRepository.save(productComment);
        return productComment;
    }

    @Override
    public void deleteProductComment(Long id) {
        this.iProductCommentRepository.deleteById(id);
    }
}
