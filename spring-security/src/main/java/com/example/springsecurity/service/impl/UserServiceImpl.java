package com.example.springsecurity.service.impl;


import com.example.springsecurity.model.entity.User;
import com.example.springsecurity.model.entity.UserRole;
import com.example.springsecurity.model.service.UserRegisterServiceModel;
import com.example.springsecurity.repo.UserRepo;
import com.example.springsecurity.repo.UserRoleRepo;
import com.example.springsecurity.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override  // return true, if user authenticated successfully
    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepo.findByUsername(username);
        if (userOpt.isEmpty()){
            return false;
        }
        System.out.println(passwordEncoder.matches(password,userOpt.get().getPassword()));
        return passwordEncoder.matches(password, userOpt.get().getPassword());
    }

    @Override  // set CurrentUser to the Logged-In user
    public void loginUser(String username) {
        final User user = userRepo.findByUsername(username).orElseThrow();
        final List<com.example.mobilelele.model.entity.enums.Role> userRoles = user.getRoles().stream()
                .map(UserRole::getName)
                .collect(Collectors.toList());

//        currentUser.setName(username);
//        currentUser.setUserRoleList(userRoles);
//        currentUser.setAnonymous(false);
    }


    @Override
    public boolean checkUsername(String username) {
        return userRepo.findByUsername(username).isPresent();
    }

    @Override
    public void saveUser(UserRegisterServiceModel userRegisterModel) {
        User user = modelMapper.map(userRegisterModel, User.class);
        UserRole userRole = userRoleRepo.findByName(userRegisterModel.getRoles());
        user.setPassword(passwordEncoder.encode(userRegisterModel.getPassword()));
        user.setRoles(List.of(userRole));
        user.setCreated(Instant.now());
        user.setModified(Instant.now());
        userRepo.save(user);
    }

    public List<UserRole> getUserRoles() {
        return userRoleRepo.findAll();
    }

    @Override
    public User getUserByName(String name) {
        return userRepo.findByUsername(name).orElse(null);
    }
}
