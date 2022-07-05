package com.karakurt.answer1.Entities.Product;

import java.sql.Date;

public interface IProduct {
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    Double getPrice();
    void setPrice(Double price);
    Date getLastDate();
    void setLastDate(Date lastDate);
}
