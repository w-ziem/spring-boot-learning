package com.wziem.store;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value( "${spring.application.name}")
    private String appName;

    @RequestMapping("/") //when a request is sent to the root (specified URL pattern - here root) this method is called
    public String index(){
        System.out.println("appName: " + appName + "");
        return "index.html";
    }

}
