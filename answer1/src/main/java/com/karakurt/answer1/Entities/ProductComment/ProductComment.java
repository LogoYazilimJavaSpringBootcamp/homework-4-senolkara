package com.karakurt.answer1.Entities.ProductComment;

import com.karakurt.answer1.Entities.Product.Product;
import com.karakurt.answer1.Entities.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products_comments")
public class ProductComment implements IProductComment, Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "comment", length = 500)
    private String comment;

    @Column(name = "comment_date")
    private Date commentDate;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
