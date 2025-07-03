package com.wziem.store;


import com.wziem.store.entities.Address;
import com.wziem.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
////        var orderService  = context.getBean(OrderService.class);
////        var orderService2  = context.getBean(OrderService.class);
////        orderService.placeOrder();
//
//        //orderService object is created (it's bean) even tho I don't use it - early/eger initialization
//
//
////        var notificationManager = context.getBean(NotificationManager.class);
////        notificationManager.sendNotification("Order placed successfully!");
//
////        var resource = context.getBean(HeavyResource.class);
//
//        UserService userService = context.getBean(UserService.class);
//        try {
//            userService.registerUser(new User(781, "Wojciech", "wziem@gmail.com", "<PASSWORD>"));
//            userService.registerUser(new User(982, "Jakub", "jacob@gmail.com", "<PASSWORD1>"));
//            userService.registerUser(new User(781, "Wojciech", "wziem@gmail.com", "<PASSWORD>"));
//        } catch (IllegalArgumentException e) {
//            System.err.println("USER ALREADY EXISTS, OMMITING!");
//        }finally {
//            userService.showUsers();
//        }
//        context.close();

//        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
            var user = User.builder().name("John").email("<EMAIL>").password("<PASSWORD>").build();
            var address = Address.builder().state("California").street("321 st.").city("Los Angeles").zip("222-131").build();

            user.addAddress(address);
            System.out.println(user.toString());

        }
}
