package com.example.springsecurity.repo;


import com.example.mobilelele.model.entity.enums.Role;

import com.example.springsecurity.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    UserRole findByName(Role name);
}
