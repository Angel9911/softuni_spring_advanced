package com.example.springsecurity.service;

import com.example.springsecurity.model.entity.User;
import com.example.springsecurity.model.entity.UserRole;
import com.example.springsecurity.model.service.UserRegisterServiceModel;

import java.util.List;

public interface UserService {

    // return true, if user authenticated successfully
    boolean authenticate(String username, String password);

    boolean checkUsername(String username);

    void saveUser(UserRegisterServiceModel userRegisterModel);

    List<UserRole> getUserRoles();

    void loginUser(String username);

    User getUserByName(String name);
}
