package com.karakurt.answer1.DataAccess.User;

import com.karakurt.answer1.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
