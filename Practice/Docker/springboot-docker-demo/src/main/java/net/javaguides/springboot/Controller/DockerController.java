package net.javaguides.springboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

@GetMapping("/docker")
    public String DockerController(){
        return "Dockerizing Spring Boot Application";
    }
}
