package com.karakurt.answer1.DataAccess.User;

import com.karakurt.answer1.Entities.User.User;

import java.util.List;

public interface IUserDao {
    List<User> getAllUser();
    User getUser(Long id);
    User createUser(String firstName, String lastName, String email, String address);
    User updateUser(Long id, String firstName, String lastName, String email, Long addressId, String address);
    void deleteUser(Long id);
}
