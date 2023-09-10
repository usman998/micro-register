package com.example.accountTest.Service;
import com.example.accountTest.Dto.LoginDTO;
import com.example.accountTest.Dto.UserDTO;
import com.example.accountTest.response.UserResponse;

public interface UserService {

    UserResponse addUser(UserDTO userDTO);

    UserResponse loginEmployee(LoginDTO loginDTO);

}
