package net.javaguides.employeeservice.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {
//read value from properties file added message in github department
    @Value("${spring.boot.message}")
    private String message;

    //Added aanotation for these refresh
    @GetMapping("/user/message")
    public String message(){
        return message;
    }
}
