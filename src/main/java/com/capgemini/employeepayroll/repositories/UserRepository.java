package com.capgemini.employeepayroll.repositories;

import com.capgemini.employeepayroll.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findFirstByUserNameAndPasswordAndIsActive(String userName, String password, int isActive);
}
