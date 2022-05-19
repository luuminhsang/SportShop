package com.project.controllers;

import com.project.models.Product;
import com.project.services.CategoryService;
import com.project.services.ProductsService;
import lombok.AllArgsConstructor;
import com.project.models.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
public class WebController {
    private final CategoryService categoryService;
    private final ProductsService productsService;

    @GetMapping(path = "/")
    public ModelAndView index(HttpServletRequest request) {
        List<Brand> branches = categoryService.findAll();
        List<Product> products = productsService.getTrendingProduct();
        request.setAttribute("products", products);
        request.setAttribute("brandList", branches);
        return new ModelAndView("index");
    }
    @GetMapping(path = "/contact")
    public ModelAndView getContact() {
        return new ModelAndView("contact");
    }
    @GetMapping(path = "/about-us")
    public ModelAndView getAboutUs() {
        return new ModelAndView("about-us");
    }
    @GetMapping(path = "/login")
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }
    @GetMapping(path = "/register")
    public ModelAndView getRegister() {
        return new ModelAndView("register");
    }
    @GetMapping(path = "/productlist")
    public ModelAndView getProduct(HttpServletRequest request) {
        List<Brand> brandList = categoryService.findAll();
        request.setAttribute("brandList", brandList);
        return new ModelAndView("product-list");
    }


}
