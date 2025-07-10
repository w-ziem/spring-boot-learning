package com.wziem.store.services;


import com.wziem.store.entities.Category;
import com.wziem.store.entities.Product;
import com.wziem.store.repositories.CategoryRepository;
import com.wziem.store.repositories.ProductRepository;
import com.wziem.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final UserRepository userRepository;


    @Transactional
    public void createExampleProduct() {
        var product = new Product("mp3", "Już niefajna empetruja 2005", BigDecimal.valueOf(20.99));
        var category = categoryService.getOtCreateByName("audio");
        product.addCategory(category);
        productRepository.save(product);
    }

    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public void removeProduct(){
        var product = productRepository.findById(1L).orElseThrow();
        product.getWishlist().forEach((u) -> {
            u.getWishlist().remove(product);
            userRepository.save(u);
        });

        productRepository.delete(product);
    }

    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 3);
    }

    public void fetchProduct(){
        var products = productRepository.findByCategory(new Category((byte) 3));
        products.forEach(System.out::println);
    }
}
