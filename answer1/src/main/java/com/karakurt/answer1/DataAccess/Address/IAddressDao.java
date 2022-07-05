package com.karakurt.answer1.DataAccess.Address;

import com.karakurt.answer1.Entities.Address.Address;

import java.util.List;

public interface IAddressDao {
    List<Address> getAllAddress();
    Address getAddress(Long id);
    Address createAddress(String address);
    Address updateAddress(Long id, String address);
    void deleteAddress(Long id);
}
