package com.karakurt.answer1.DataAccess.User.PostgresSQL;

import com.karakurt.answer1.DataAccess.Address.IAddressRepository;
import com.karakurt.answer1.DataAccess.Address.PostgresSQL.PostgresSQLAddressDao;
import com.karakurt.answer1.DataAccess.User.IUserDao;
import com.karakurt.answer1.DataAccess.User.IUserRepository;
import com.karakurt.answer1.Entities.Address.Address;
import com.karakurt.answer1.Entities.Address.AddressType;
import com.karakurt.answer1.Entities.Address.IAddress;
import com.karakurt.answer1.Entities.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostgresSQLUserDao implements IUserDao {

    private IUserRepository iUserRepository;

    public PostgresSQLUserDao(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return this.iUserRepository.findById(id).get();
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String address){
        PostgresSQLAddressDao postgresSQLAddressDao = new PostgresSQLAddressDao();
        Address iAddress = postgresSQLAddressDao.createAddress(address);
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(iAddress);
        this.iUserRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, String firstName, String lastName, String email, Long addressId, String address) {
        PostgresSQLAddressDao postgresSQLAddressDao = new PostgresSQLAddressDao();
        Address iAddress = postgresSQLAddressDao.updateAddress(addressId, address);
        User user = this.iUserRepository.findById(id).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(iAddress);
        this.iUserRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.iUserRepository.deleteById(id);
    }
}
