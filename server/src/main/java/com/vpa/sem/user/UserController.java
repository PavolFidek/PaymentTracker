package com.vpa.sem.user;

import com.vpa.sem.DTOs.LoginDto;
import com.vpa.sem.DTOs.RegisterDto;
import com.vpa.sem.DTOs.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    @ResponseBody
    public UserDto GetUser() {
        return userService.GetUser(1);
    }

    @PostMapping("/userLogin")
    @ResponseBody
    public UserDto LoginUser(@RequestBody LoginDto loginDto) {

        return userService.LoginUser(loginDto);
    }

    @PostMapping("/userRegister")
    @ResponseBody
    public UserDto RegisterUser(@RequestBody RegisterDto registerDto) {

        return userService.RegisterNewUser(registerDto);
    }
}
