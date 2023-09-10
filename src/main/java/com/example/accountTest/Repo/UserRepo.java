package com.example.accountTest.Repo;
import com.example.accountTest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Integer>{

    User findByEmail(String email);

    Optional<User> findOneByEmailAndPassword(String email, String password);
}
