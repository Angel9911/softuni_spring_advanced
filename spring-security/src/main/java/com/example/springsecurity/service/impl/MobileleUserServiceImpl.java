package com.example.springsecurity.service.impl;

import com.example.springsecurity.model.entity.User;
import com.example.springsecurity.repo.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MobileleUserServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;


    public MobileleUserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User getUserbyUsername = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));

        return mapToUserDetails(getUserbyUsername);
    }

    // used to map user entity to the userdetails which is spring security implementation
    private static UserDetails mapToUserDetails(User user){
        // GrantedAuthority is the representation of a user role in spring world. SimpleGrantedAuthority is the implementation of the GrantedAuthority that spring provides for convenience.
        List<GrantedAuthority> grantedAuthorities = user.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name())).collect(Collectors.toList());

        org.springframework.security.core.userdetails.User userSecurityImpl = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);

        return userSecurityImpl;
    }

}
