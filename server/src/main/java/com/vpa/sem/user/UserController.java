package com.vpa.sem.user;

import com.vpa.sem.DTOs.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> GetUsers() {
        return userService.GetUsers();
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public User GetUser() {
        return userService.GetUser(1);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean LoginUser() {
        return false;
        //return userService.loginUser(loginDto);
    }

}
