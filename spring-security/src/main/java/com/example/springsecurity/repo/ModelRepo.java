package com.example.springsecurity.repo;

import com.example.springsecurity.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepo extends JpaRepository<Model, Long> {
    Model findByName(String model);
}
