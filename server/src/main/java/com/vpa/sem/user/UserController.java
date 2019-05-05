package com.vpa.sem.user;

import com.vpa.sem.DTOs.LoginDto;
import com.vpa.sem.DTOs.RegisterDto;
import com.vpa.sem.DTOs.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public UserDto GetUser() {
        return userService.GetUser();
    }

    @PostMapping("/userLogin")
    public UserDto LoginUser(@RequestBody LoginDto loginDto) {

        return userService.LoginUser(loginDto);
    }

    @PostMapping("/userRegister")
    public UserDto RegisterUser(@RequestBody RegisterDto registerDto) {

        return userService.RegisterNewUser(registerDto);
    }

    @GetMapping("/logoutUser")
    public void LogoutUser(HttpServletRequest request, HttpServletResponse response) {

        userService.Logout(request, response);
    }
}
