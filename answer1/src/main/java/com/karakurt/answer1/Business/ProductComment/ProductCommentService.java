package com.karakurt.answer1.Business.ProductComment;

import com.karakurt.answer1.DataAccess.ProductComment.IProductCommentDao;
import com.karakurt.answer1.Entities.ProductComment.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentService implements IProductCommentService {

    private IProductCommentDao iProductCommentDao;

    public ProductCommentService(IProductCommentDao iProductCommentDao){
        this.iProductCommentDao = iProductCommentDao;
    }

    @Override
    public List<ProductComment> getAllProductComment() {
        return this.iProductCommentDao.getAllProductComment();
    }

    @Override
    public ProductComment getProductComment(Long id) {
        return this.iProductCommentDao.getProductComment(id);
    }

    @Override
    public ProductComment createProductComment(Long userId, Long productId, String comment) {
        return this.iProductCommentDao.createProductComment(userId, productId, comment);
    }

    @Override
    public ProductComment updateProductComment(Long id, String comment) {
        return this.iProductCommentDao.updateProductComment(id, comment);
    }

    @Override
    public void deleteProductComment(Long id) {
        this.iProductCommentDao.deleteProductComment(id);
    }
}
