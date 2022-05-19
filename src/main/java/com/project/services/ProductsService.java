package com.project.services;

import com.project.dto.ProductDTO;
import com.project.models.Product;
import com.project.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductsService {
    private ProductsRepository repository;

    public List<ProductDTO> findByBrand(int id) {
        List<Product> products = repository.findByBrandId(id);
        List<ProductDTO> arrayList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            ProductDTO dto = new ProductDTO();
            dto.setId(products.get(i).getId());
            dto.setName(products.get(i).getName());
            dto.setBrandName(products.get(i).getBrand().getName());
            dto.setPrice(products.get(i).getPrice());
            dto.setPromotionPrice(products.get(i).getPromotionPrice());
            arrayList.add(dto);
        }
        return arrayList;
    }
    public List<ProductDTO> getByKeyword(String keyword){
        List<Product> products = repository.findByKeyword(keyword);
        List<ProductDTO> arrayList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            ProductDTO dto = new ProductDTO();
            dto.setId(products.get(i).getId());
            dto.setName(products.get(i).getName());
            dto.setBrandName(products.get(i).getBrand().getName());
            dto.setPrice(products.get(i).getPrice());
            dto.setPromotionPrice(products.get(i).getPromotionPrice());
            arrayList.add(dto);
        }
        return arrayList;
    }

    public List<Product> getTrendingProduct(){
        return repository.trendingProduct();
    }
}
