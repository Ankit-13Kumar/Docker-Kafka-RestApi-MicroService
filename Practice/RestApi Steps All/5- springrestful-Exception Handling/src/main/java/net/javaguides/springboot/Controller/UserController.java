package net.javaguides.springboot.Controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.Dto.UserDto;
import net.javaguides.springboot.Exception.ErrorDetails;
import net.javaguides.springboot.Exception.ResourceNotFoundException;
import net.javaguides.springboot.Model.User;
import net.javaguides.springboot.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//Get UserByID rest Api
    //url - http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") long userid){
        UserDto user=userService.getUserById(userid);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    //getall user list
    //http://localhost:8080/api/users/getalluser
    @GetMapping("/getalluser")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users=userService.getAllUsers();
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
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto user){
        //if u will not mention updated user here then we got null point exception error
        user.setId(userId);
        UserDto updateUser=userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }

    //Delete user
    //url - http://localhost:8080/api/users/delete/2

    //It is not using User Jpa so not used here Dto class
    @DeleteMapping("/delete/{id}")
    //generic class pass as a string
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        //message pass as a string
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }

    //Specific Exception Handling
   /* @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_Not_Found"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }*/
}
