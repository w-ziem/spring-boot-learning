package com.wziem.store;


import com.wziem.store.entities.*;
import com.wziem.store.repositories.*;
import com.wziem.store.services.ProductService;
import com.wziem.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;


@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
    /*
       ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService  = context.getBean(OrderService.class);
        var orderService2  = context.getBean(OrderService.class);
        orderService.placeOrder();

        orderService object is created (it's bean) even tho I don't use it - early/eger initialization


        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Order placed successfully!");

        var resource = context.getBean(HeavyResource.class);

        UserService userService = context.getBean(UserService.class);
        try {
            userService.registerUser(new User(781, "Wojciech", "wziem@gmail.com", "<PASSWORD>"));
            userService.registerUser(new User(982, "Jakub", "jacob@gmail.com", "<PASSWORD1>"));
            userService.registerUser(new User(781, "Wojciech", "wziem@gmail.com", "<PASSWORD>"));
        } catch (IllegalArgumentException e) {
            System.err.println("USER ALREADY EXISTS, OMMITING!");
        }finally {
            userService.showUsers();
        }
        context.close();

            var user = User.builder().name("John").email("<EMAIL>").password("<PASSWORD>").build();
            var address = Address.builder().state("California").street("321 st.").city("Los Angeles").zip("222-131").build();

            user.addAddress(address);
            System.out.println(user.toString());

            user.addTag("tag");
            user.addTag("tag1");
            System.out.println(user.toString());

            var profile = Profile.builder().user(user).bio("some text").build();
            user.setProfile(profile);
            System.out.println(user.toString());


 }
*/
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class); //spring creates classes from repository interfaces at runtime
//        service.showEntityStates();
//        service.fetchAddress();
//        service.showRelatedEntities();
//        service.persistRelated();
//        service.deleteRelated();
        var productService = context.getBean(ProductService.class);
//        productService.createExampleProduct();
//        userService.fillWishlist();
//        productService.removeProduct();
//        productService.updateProductPrices();
//        productService.fetchProduct();
        userService.fetchUsers();

    }}
