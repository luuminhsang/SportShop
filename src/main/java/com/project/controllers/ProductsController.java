package com.project.controllers;

import com.project.models.Product;
import com.project.repositories.ProductsRepository;
import com.project.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final ProductsRepository productsRepository;

    @GetMapping("/ProductList/{brand}")
    public ModelAndView products(@PathVariable(value ="brand") Integer id, HttpServletRequest request) {
        System.out.println("add 1 line");
        System.out.println("add 1 line");
        List<Product> products = productsRepository.findProductByBrandId(id);
        return new ModelAndView("product-list");
    }

}
