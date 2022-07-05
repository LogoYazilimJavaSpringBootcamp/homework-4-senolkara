package com.karakurt.answer1.DataAccess.ProductComment;

import com.karakurt.answer1.Entities.ProductComment.ProductComment;

import java.util.List;

public interface IProductCommentDao {
    List<ProductComment> getAllProductComment();
    ProductComment getProductComment(Long id);
    ProductComment createProductComment(Long userId, Long productId, String comment);
    ProductComment updateProductComment(Long id, String comment);
    void deleteProductComment(Long id);
}
