package com.example.accountTest.userController;
import com.example.accountTest.Dto.LoginDTO;
import com.example.accountTest.Dto.UserDTO;
import com.example.accountTest.Service.UserService;
import com.example.accountTest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")

public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping(path = "/save")
    public ResponseEntity<?> saveEmployee(@RequestBody UserDTO userDTO)
    {
        UserResponse id = userService.addUser(userDTO);
        return ResponseEntity.ok(id);

    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        UserResponse loginResponse = userService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
