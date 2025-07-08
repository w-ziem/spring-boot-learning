package com.wziem.store.services;

import com.wziem.store.entities.Address;
import com.wziem.store.entities.User;
import com.wziem.store.repositories.AddressRepository;
import com.wziem.store.repositories.ProfileRepository;
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
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductService productService;

    @Transactional //changing the lifecycle of the entity - the presistance context is alive for the duration of the transaction - so this method is transactional
    public void showEntityStates(){
        var user = User.builder().name("John").email("<EMAIL>").build();
        if(entityManager.contains(user)) System.out.println("Persisent");
        else System.out.println("Transient / Detached"); //didnt use repository to save the user - so it is transient
        userRepository.save(user);
        if(entityManager.contains(user)) System.out.println("Persisent"); //used repository to save the user - so it is persistent for as long as this method is running
        else System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities(){
        var profile = profileRepository.findById(3L).orElseThrow();
        System.out.println(profile.getUser().getEmail()); //without the @Transactiol it wont work (LazyLodingInitialozationException) because after 30th line the var profile is detached, there is no presistance context, and Hibertnate dosen't know how to use this variable, so we need to set the whole method to being Transactilanl
    }

    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.toString());
    }

    public void persistRelated(){
        var user = User.builder().name("John").email("john@example.com").password("password123").build();
        var address = Address.builder().street("123 st.").city("Los Angeles").state("CA").zip("90291").build();

        user.addAddress(address);
        userRepository.save(user);

    }

    @Transactional
    public void deleteRelated(){
        var user = userRepository.findById(14L).orElseThrow();
        user.removeAddress(user.getAddresses().get(0));
        userRepository.save(user);
    }

    @Transactional
    public void fillWishlist(){
        var user = userRepository.findById(14L).orElseThrow();
        productService.getAllProducts().forEach(user::addToWishlist);
    }


}
