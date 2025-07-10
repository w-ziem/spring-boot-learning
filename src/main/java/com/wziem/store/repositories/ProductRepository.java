package com.wziem.store.repositories;

import com.wziem.store.dtos.ProductSummary;
import com.wziem.store.dtos.ProductSummaryDTO;
import com.wziem.store.entities.Category;
import com.wziem.store.entities.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    //SELECT * FROM PRODUCT WHERE NAME = '%name%'
    List<Product> findByNameLike(String name);
    List<Product> findByNameContaining(String name);
    //etc.

    //Numbers
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal start, BigDecimal end);


    //Null values
    List<Product> findByDescriptionNull();


    //Mulyiple conditions
    List<Product> findByNameLikeAndPriceGreaterThan(String name, BigDecimal price);

    //Sort
    List<Product> findByNameLikeOrderByPriceDesc(String name);

    //Limit (Top/First)
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);


    // Find all products with prices in a given range and sort by name
//    List<Product> findByPriceBetweenOrderByName(BigDecimal start, BigDecimal end);
    //  sql or jpql
    @Query(value = "SELECT p FROM Product  p WHERE p.price BETWEEN :start and :end ORDER BY p.name")
    List<Product> findProducts(@Param("start") BigDecimal start, @Param("end") BigDecimal end); //can be generated with JPA Buddy

    @Query(value = "SELECT COUNT(p) FROM Product  p WHERE p.price BETWEEN :start and :end")
    long countProducts(@Param("start") BigDecimal start, @Param("end") BigDecimal end);

    @Modifying
    @Query("update Product p set p.price = :price where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal price, byte categoryId);


    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}