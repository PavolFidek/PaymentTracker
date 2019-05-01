package com.vpa.sem.user;


import com.vpa.sem.DTOs.LoginDto;
import com.vpa.sem.DTOs.RegisterDto;
import com.vpa.sem.DTOs.UserDto;
import com.vpa.sem.role.Role;
import com.vpa.sem.role.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Iterable<User> GetUsers() {
        Iterable<User> users = userRepository.findAll();

        return users;
    }

    public UserDto GetUser(int userId) {
        User user = userRepository.findById(userId).get();

        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    public UserDto RegisterNewUser(RegisterDto registerDto) {
        User newUser = modelMapper.map(registerDto, User.class); // Mapping dto to entity

        List<Role> adminRole = (List<Role>) roleRepository.findAll();

        newUser.setRole(adminRole);

        userRepository.save(newUser);

        UserDto userDto = modelMapper.map(newUser, UserDto.class);

        return userDto;
    }

    public UserDto LoginUser(LoginDto loginDto) {
        String login = loginDto.getLogin();
        String pass = loginDto.getPassword();

        return new UserDto(1, "", "", 3);
    }

}
