package com.karakurt.answer1.Entities.Address;

import com.karakurt.answer1.Entities.User.User;

public interface IAddress {
    User getUser();
    void setUser(User user);
    String getAddress();
    void setAddress(String address);
    AddressType getAddressType();
    void setAddressType(AddressType addressType);
}
