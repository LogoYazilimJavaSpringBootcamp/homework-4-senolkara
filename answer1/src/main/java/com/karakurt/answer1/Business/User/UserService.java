package com.karakurt.answer1.Business.User;

import com.karakurt.answer1.DataAccess.User.IUserDao;
import com.karakurt.answer1.Entities.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private IUserDao iUserDao;

    public UserService(IUserDao iUserDao){
        this.iUserDao = iUserDao;
    }

    @Override
    public List<User> getAllUser() {
        return this.iUserDao.getAllUser();
    }

    @Override
    public User getUser(Long id) {
        return this.iUserDao.getUser(id);
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String address){
        return this.iUserDao.createUser(firstName, lastName, email, address);
    }

    @Override
    public User updateUser(Long id, String firstName, String lastName, String email, Long addressId, String address) {
        return this.iUserDao.updateUser(id, firstName, lastName, email, addressId, address);
    }

    @Override
    public void deleteUser(Long id) {
        this.iUserDao.deleteUser(id);
    }
}
