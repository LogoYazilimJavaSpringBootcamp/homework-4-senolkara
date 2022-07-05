package com.karakurt.answer1.RestAPI;

import com.karakurt.answer1.Business.User.IUserService;
import com.karakurt.answer1.Business.User.UserService;
import com.karakurt.answer1.DataAccess.Address.IAddressRepository;
import com.karakurt.answer1.DataAccess.User.IUserRepository;
import com.karakurt.answer1.DataAccess.User.MySQL.MySQLUserDao;
import com.karakurt.answer1.Entities.User.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api")
public class UserController {

    private IUserRepository iUserRepository;
    private IAddressRepository iAddressRepository;
    private IUserService iUserService;

    public UserController(IUserRepository iUserRepository, IAddressRepository iAddressRepository){
        this.iUserRepository = iUserRepository;
        this.iAddressRepository = iAddressRepository;
        this.iUserService = new UserService(
                new MySQLUserDao(
                        this.iUserRepository,
                        this.iAddressRepository
                )
        );
    }

    @GetMapping
    public List<User> getAllUser(){
        return this.iUserService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return this.iUserService.getUser(id);
    }

    @PostMapping
    public User createUser(String firstName, String lastName, String email, String address){
        return this.iUserService.createUser(firstName, lastName, email, address);
    }

    @PatchMapping("/{id}/{addressId}")
    public User updateUser(@PathVariable Long id, String firstName, String lastName, String email, @PathVariable Long addressId, String address){
        return this.iUserService.updateUser(id, firstName, lastName, email, addressId, address);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        this.iUserService.deleteUser(id);
    }

    /**
      spring.datasource.url=jdbc:postgresql://localhost:5433/demo_database?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
      spring.datasource.username=postgres
      spring.datasource.password=example

      spring.sql.init.mode=never
      spring.sql.init.platform=postgres

      spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

      spring.jpa.hibernate.ddl-auto=update


      spring.jpa.show-sql=true

      bu bilgilerle postressql e bağlanıyoruz fakat user tablosu oluşmuyor...

     */
}
