package com.project.services;

import com.project.dto.ProductDTO;
import com.project.models.Brand;
import com.project.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.project.repositories.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository repository;
    public List<Brand> findAll() {
        return repository.findAll();}


}

