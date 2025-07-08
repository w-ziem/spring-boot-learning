package com.wziem.store.services;


import com.wziem.store.entities.Category;
import com.wziem.store.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //zwraca lub tworzy nowa kategorie po nazwie
    public Category getOtCreateByName(String name){
        return categoryRepository.findByName(name).orElseGet(() -> categoryRepository.save(new Category(name)));
    }

}
