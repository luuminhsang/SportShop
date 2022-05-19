package com.project.controllers;

import com.project.dto.ProductDTO;
import com.project.models.Product;
import com.project.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/Products/{id}")
    public ModelAndView products(@PathVariable(name = "id") int id, HttpServletRequest request) {
        List<ProductDTO> products = productsService.findByBrand(id);
        System.out.println(products);
        request.setAttribute("products", products);
        return new ModelAndView("product-grids");
    }

//    @RequestMapping(path = {"/search"})
//    public ModelAndView home(String keyword, HttpServletRequest request) {
//        if(keyword!=null) {
//            List<Product> list = productsService.getByKeyword(keyword);
//            request.setAttribute("list", list);
//            System.out.println(list);
//        }else {
//            List<Product> list = productsService.getAll();
//            request.setAttribute("list", list);
//            System.out.println(list);
//
//        }
//        return new ModelAndView("product-grids");
//    }
    @GetMapping(path = {"/search"})
    public ModelAndView getProductFromSearch(@Param("keyword") String keyword, Model model) {
            System.out.println("Keyword: " + keyword);
            List<ProductDTO> result = productsService.getByKeyword(keyword);
             System.out.println(result);
            model.addAttribute("result", result);
            return new ModelAndView("search_result");
    }


}
