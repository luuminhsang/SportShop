package com.project.controllers;

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

    @GetMapping(path = "/")
    public ModelAndView index(HttpServletRequest request) {
        List<Brand> branches = categoryService.findAll();
        request.setAttribute("brandList", branches);
        return new ModelAndView("index");
    }
    @GetMapping(path = "/contact")
    public ModelAndView contact() {
        return new ModelAndView("contact");
    }
    @GetMapping(path = "/productlist")
    public ModelAndView products(HttpServletRequest request) {
        List<Brand> brandList = categoryService.findAll();
        request.setAttribute("brandList", brandList);
        return new ModelAndView("product-list");
    }


}
