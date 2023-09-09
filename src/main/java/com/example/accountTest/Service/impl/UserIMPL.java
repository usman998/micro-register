package com.example.accountTest.Service.impl;
import com.example.accountTest.Dto.UserDTO;
import com.example.accountTest.Entity.User;
import com.example.accountTest.Repo.UserRepo;
import com.example.accountTest.Service.UserService;
import com.example.accountTest.response.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserIMPL implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserResponse addUser(UserDTO userDTO) {
        User user1 = userRepo.findByEmail(userDTO.getEmail());
        if(user1 == null){
            User user = new User(
                    userDTO.getId(),
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getAddress(),
                    userDTO.getEmail(),
                    Objects.isNull(this.passwordEncoder)?userDTO.getPassword():this.passwordEncoder.encode(userDTO.getPassword())
            );
            User s = userRepo.save(user);
            User user2 = userRepo.findByEmail(userDTO.getEmail());
            return new UserResponse(
                    "Success",
                    true,
                    user2.getId(),
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getAddress(),
                    userDTO.getEmail()
            );
        } else{
            return new UserResponse(
                    "Email already Exist",
                    false
            );
        }
    }


}
