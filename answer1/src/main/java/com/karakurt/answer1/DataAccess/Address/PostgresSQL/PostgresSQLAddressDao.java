package com.karakurt.answer1.DataAccess.Address.PostgresSQL;

import com.karakurt.answer1.DataAccess.Address.IAddressDao;
import com.karakurt.answer1.DataAccess.Address.IAddressRepository;
import com.karakurt.answer1.Entities.Address.Address;
import com.karakurt.answer1.Entities.Address.AddressType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostgresSQLAddressDao implements IAddressDao {

    private IAddressRepository iAddressRepository;

    public PostgresSQLAddressDao(IAddressRepository iAddressRepository){
        this.iAddressRepository = iAddressRepository;
    }

    @Override
    public List<Address> getAllAddress() {
        return this.iAddressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return this.iAddressRepository.findById(id).get();
    }

    @Override
    public Address createAddress(String address) {
        Address address1 = new Address();
        address1.setAddress(address);
        address1.setAddressType(AddressType.BILLING);
        this.iAddressRepository.save(address1);
        return address1;
    }

    @Override
    public Address updateAddress(Long id, String address) {
        Address address1 = this.iAddressRepository.findById(id).get();
        address1.setAddress(address);
        address1.setAddressType(AddressType.BILLING);
        this.iAddressRepository.save(address1);
        return address1;
    }

    @Override
    public void deleteAddress(Long id) {
        this.iAddressRepository.deleteById(id);
    }
}
