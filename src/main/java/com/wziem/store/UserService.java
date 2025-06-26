package com.wziem.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService){
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) throws IllegalArgumentException{
        if(!userRepository.contains(user)){
            userRepository.save(user);
            sendWelcomeEmail(user);
        } else{
            throw new IllegalArgumentException("User already exists");
        }
    }

    public void sendWelcomeEmail(User user){
        notificationService.send("Welcome to our store " + user.getName() + "!", user.getEmail());
    }

    public void showUsers(){
        userRepository.showUsersList();
    }
}
