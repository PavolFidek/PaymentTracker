package com.vpa.sem.user;

import com.vpa.sem.DTOs.LoginDto;
import com.vpa.sem.DTOs.RegisterDto;
import com.vpa.sem.DTOs.UserDto;
import com.vpa.sem.role.Role;
import com.vpa.sem.role.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserDto GetUser(int userId) {
        User user = userRepository.findById(userId).get();

        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    public UserDto RegisterNewUser(RegisterDto registerDto) {
        User newUser = modelMapper.map(registerDto, User.class); // Mapping dto to entity

        User existingUser = userRepository.findByLogin(newUser.getLogin()); // Find if exist user with given login already

        if (existingUser != null) {
            return new UserDto(-1L, "", "", -1);
        }

        // List<Role> adminRole = (List<Role>) roleRepository.findAll(); // Role for admin, contains all roles
        List<Role> userRole = roleRepository.GetRole("USER");

        newUser.setPassword(passwordEncoder.encode(registerDto.getUserPassword()));

        // newUser.setRoles(adminRole); // Set roles for admin
        newUser.setRoles(userRole);

        userRepository.save(newUser); // Save new user into database

        UserDto userDto = modelMapper.map(newUser, UserDto.class);

        return userDto;
    }

    public UserDto LoginUser(LoginDto loginDto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getLogin());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, loginDto.getPassword(), userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        User loggedUser = userRepository.findByLogin(loginDto.getLogin());

        UserDto userDto = modelMapper.map(loggedUser, UserDto.class);

        return userDto;
    }

}
