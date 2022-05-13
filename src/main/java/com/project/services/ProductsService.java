package com.project.services;

import com.project.models.Brand;
import com.project.models.Product;
import com.project.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

//    public List<Product> findAllProductByBrandId(@PathVariable int id) {
//        return productsRepository.findAllProductByBrandId(id);
//    }
}
