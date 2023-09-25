package com.example.springsecurity.model.validation;

import com.example.springsecurity.repo.UserRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final UserRepo userRepo;

    public UniqueUsernameValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) { return true; }
        return userRepo.findByUsername(username).isPresent();
    }
}
