package net.javaguides.springboot.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloworldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }
}