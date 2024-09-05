package net.javaguides.springboot.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.Model.User;
import net.javaguides.springboot.Repository.UserRepository;
import net.javaguides.springboot.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Constructor for reposiory parameterized 4.0 onwords no need of autowired
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    //@Autowired No use bcoz if spring found one permterized constructor they will automatically inject the dependecy
    private UserRepository userRepository;

    //add user
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //get user by id
    @Override
    public User getUserById(long userId) {
        //findbyid returns optional user as a type & optonal user has get method
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    //Get list of user
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //Update User
    @Override
    public User updateUser(User user) {
        //object contains optional method so get in end
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    //deleteuser
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
