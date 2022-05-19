package com.project.repositories;

import com.project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
     List<Product> findByBrandId(int id);

     @Query(value = "select * from product p where p.name like %:keyword%", nativeQuery = true)
     List<Product> findByKeyword(String keyword);

     @Query(value = "SELECT * FROM sportstore.product where sold > 1;", nativeQuery = true)
     List<Product> trendingProduct();
}
