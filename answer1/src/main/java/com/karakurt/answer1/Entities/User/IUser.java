package com.karakurt.answer1.Entities.User;

import com.karakurt.answer1.Entities.Address.Address;

public interface IUser {
    Long getId();
    void setId(Long id);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getEmail();
    void setEmail(String email);
    Address getAddress();
    void setAddress(Address address);
}
