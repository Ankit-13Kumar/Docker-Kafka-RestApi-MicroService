package net.javaguides.springboot.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.Model.User;
import net.javaguides.springboot.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//Base Url
@RequestMapping("/api/users")
public class UserController {
//@Autowired No use bcoz if spring found one permterized constructor they will automatically inject the dependecy
private UserService userService;

//Build create user rest api
    //url - http://localhost:8080/api/users/create
    //json {
//    "firstName":"Ankit",
//    "lastName":"Kumar",
//    "email":"ankit@gmail.com"
//}
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//Get UserByID rest Api
    //url - http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userid){
        User user=userService.getUserById(userid);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    //getall user list
    //http://localhost:8080/api/users/getuser
    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
//Upadte User
    // url - http://localhost:8080/api/users/update/1
    //json {
//    "firstName":"boby",
//    "lastName":"Kumar",
//    "email":"boby2gmail.com"
//}
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User user){
        //if u will not mention updated user here then we got null point exception error
        user.setId(userId);
        User updateUser=userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

    //Delete user
    //url - http://localhost:8080/api/users/delete/2
    @DeleteMapping("/delete/{id}")
    //generic class pass as a string
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        //message pass as a string
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }
}
