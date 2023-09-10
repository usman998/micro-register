package com.example.accountTest.Service.impl;
import com.example.accountTest.Dto.LoginDTO;
import com.example.accountTest.Dto.UserDTO;
import com.example.accountTest.Entity.User;
import com.example.accountTest.Repo.UserRepo;
import com.example.accountTest.Service.UserService;
import com.example.accountTest.response.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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


    @Override
    public UserResponse  loginEmployee(LoginDTO loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new UserResponse(
                             "Login Success",
                            true,
                            user1.getId(),
                            user1.getFirstName(),
                            user1.getLastName(),
                            user1.getAddress(),
                            user1.getEmail()
                            );
                } else {
                    return new UserResponse("Login Failed", false);
                }
            } else {
                return new UserResponse("password Not Match", false);
            }
        }else {
            return new UserResponse("Email not exits", false);
        }
    }


}
