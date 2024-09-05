package net.javaguides.springboot.Service;

import net.javaguides.springboot.Dto.UserDto;
import net.javaguides.springboot.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    //Steps create in service then impl then controller
    //post request create
    UserDto createUser(UserDto user);

    //getid
    UserDto getUserById(long userId);
//list of user
    List<UserDto> getAllUsers();
    //update
    UserDto updateUser(UserDto user);
    //Delete
    void deleteUser(Long userId);

}
