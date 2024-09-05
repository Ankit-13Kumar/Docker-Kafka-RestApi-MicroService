package net.javaguides.springboot.Service;

import net.javaguides.springboot.Model.User;

import java.util.List;

public interface UserService {

    //Steps create in service then impl then controller
    //post request create
    User createUser(User user);

    //getid
    User getUserById(long userId);
//list of user
    List<User> getAllUser();
    //update
    User updateUser(User user);
    //Delete
    void deleteUser(Long userId);

}
