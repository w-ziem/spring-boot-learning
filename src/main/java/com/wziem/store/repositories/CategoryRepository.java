package com.wziem.store.repositories;

import com.wziem.store.entities.Category;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
  Optional<Category> findByName(String name);
}