package com.wziem.store.services;

import com.wziem.store.entities.User;
import com.wziem.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Transactional //changing the lifecycle of the entity - the presistance context is alive for the duration of the transaction - so this method is transactional
    public void showEntityStates(){
        var user = User.builder().name("John").email("<EMAIL>").build();
        if(entityManager.contains(user)) System.out.println("Persisent");
        else System.out.println("Transient / Detached"); //didnt use repository to save the user - so it is transient
        userRepository.save(user);
        if(entityManager.contains(user)) System.out.println("Persisent"); //used repository to save the user - so it is persistent for as long as this method is running
        else System.out.println("Transient / Detached");
    }
}
