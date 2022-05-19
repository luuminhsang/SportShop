package com.project.dto;
import com.project.models.Brand;
import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int promotionPrice;
    private int sold;
    private int inStock;
    private String brandName;
}
