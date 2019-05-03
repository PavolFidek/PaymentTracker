package com.vpa.sem.user;


import com.vpa.sem.DTOs.LoginDto;
import com.vpa.sem.DTOs.RegisterDto;
import com.vpa.sem.DTOs.UserDto;
import com.vpa.sem.role.Role;
import com.vpa.sem.role.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> GetUsers() {
        List<User> users = (List<User>) userRepository.findAll();

        return users;
    }

    public UserDto GetUser(int userId) {
        User user = userRepository.findById(userId).get();

        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    public UserDto RegisterNewUser(RegisterDto registerDto) {
        User newUser = modelMapper.map(registerDto, User.class); // Mapping dto to entity

        if (false) {
            return new UserDto();
        }

        List<Role> adminRole = (List<Role>) roleRepository.findAll();

        newUser.setPassword(passwordEncoder.encode(registerDto.getUserPassword()));

        newUser.setRoles(adminRole);

        // Save new user into database
        userRepository.save(newUser);

        UserDto userDto = modelMapper.map(newUser, UserDto.class);

        return userDto;
    }

    public UserDto LoginUser(LoginDto loginDto) {
        String login = loginDto.getLogin();
        String pass = loginDto.getPassword();

        return new UserDto(1L, "", "", 3);
    }

}
