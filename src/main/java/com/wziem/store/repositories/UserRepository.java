package com.wziem.store.repositories;

import com.wziem.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { //<Type, IdType>

}
