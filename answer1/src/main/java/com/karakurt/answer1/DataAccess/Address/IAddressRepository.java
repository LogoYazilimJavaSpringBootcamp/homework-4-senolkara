package com.karakurt.answer1.DataAccess.Address;

import com.karakurt.answer1.Entities.Address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
