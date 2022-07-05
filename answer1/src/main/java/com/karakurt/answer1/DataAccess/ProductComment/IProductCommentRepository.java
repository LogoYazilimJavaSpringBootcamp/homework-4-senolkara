package com.karakurt.answer1.DataAccess.ProductComment;

import com.karakurt.answer1.Entities.ProductComment.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCommentRepository extends JpaRepository<ProductComment,Long> {
}
