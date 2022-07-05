package com.karakurt.answer1.Entities.ProductComment;

import com.karakurt.answer1.Entities.Product.Product;
import com.karakurt.answer1.Entities.User.User;

import java.sql.Date;

public interface IProductComment {
    Long getId();
    void setId(Long id);
    String getComment();
    void setComment(String comment);
    Date getCommentDate();
    void setCommentDate(Date commentDate);
    Product getProduct();
    void setProduct(Product product);
    User getUser();
    void setUser(User user);
}
