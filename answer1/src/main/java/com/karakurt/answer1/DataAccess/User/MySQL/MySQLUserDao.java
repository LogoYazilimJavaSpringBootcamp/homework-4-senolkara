package com.karakurt.answer1.DataAccess.User.MySQL;

import com.karakurt.answer1.DataAccess.Address.IAddressRepository;
import com.karakurt.answer1.DataAccess.User.IUserDao;
import com.karakurt.answer1.DataAccess.User.IUserRepository;
import com.karakurt.answer1.Entities.Address.Address;
import com.karakurt.answer1.Entities.Address.AddressType;
import com.karakurt.answer1.Entities.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class MySQLUserDao implements IUserDao {

    private IUserRepository iUserRepository;
    private IAddressRepository iAddressRepository;

    public MySQLUserDao(IUserRepository iUserRepository, IAddressRepository iAddressRepository){
        this.iUserRepository = iUserRepository;
        this.iAddressRepository = iAddressRepository;
    }

    @Override
    public List<User> getAllUser() {
        return this.iUserRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return this.iUserRepository.findById(id).get();
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String address){
        Address iAddress = new Address();
        iAddress.setAddress(address);
        iAddress.setAddressType(AddressType.BILLING);
        this.iAddressRepository.save(iAddress);
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(iAddress);
        this.iUserRepository.save(user);
        iAddress.setUser(user);
        this.iAddressRepository.save(iAddress);
        return user;
    }

    @Override
    public User updateUser(Long id, String firstName, String lastName, String email, Long addressId, String address){
        Address iAddress = this.iAddressRepository.findById(id).get();
        iAddress.setAddress(address);
        iAddress.setAddressType(AddressType.BILLING);
        this.iAddressRepository.save(iAddress);
        User user = this.iUserRepository.findById(id).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(iAddress);
        this.iUserRepository.save(user);
        iAddress.setUser(user);
        this.iAddressRepository.save(iAddress);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.iUserRepository.deleteById(id);
    }
}
