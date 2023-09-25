package com.example.springsecurity.service;


import com.example.springsecurity.model.entity.Model;
import com.example.springsecurity.model.view.BrandViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<BrandViewModel> getAllBrands();

    Model getModelById(Long id);
}
