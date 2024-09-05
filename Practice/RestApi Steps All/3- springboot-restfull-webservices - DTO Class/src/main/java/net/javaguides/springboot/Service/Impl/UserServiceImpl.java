package net.javaguides.springboot.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.Dto.UserDto;
import net.javaguides.springboot.Mapper.UserMapper;
import net.javaguides.springboot.Model.User;
import net.javaguides.springboot.Repository.UserRepository;
import net.javaguides.springboot.Service.UserService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//Constructor for reposiory parameterized 4.0 onwords no need of autowired
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    //@Autowired No use bcoz if spring found one permterized constructor they will automatically inject the dependecy
    private UserRepository userRepository;

    //add user
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert UserDto into Jpa Entity
        //make constructor
        User user= UserMapper.mapToUser(userDto);
//        User user=new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
        //we need to return dto object so we remove return here
        User savedUser=userRepository.save(user);

        //Convert User JPA entity to UserDto
        //pass value to a constructor
        //rest api assume to return same object so we convert here as a return type
        //savedUser contain primary key here

        UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto=new UserDto(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//             );
        return savedUserDto;

    }

    //get user by id
    @Override
    public UserDto getUserById(long userId) {
        //findbyid returns optional user as a type & optonal user has get method
        Optional<User> optionalUser = userRepository.findById(userId);
        User user=optionalUser.get();
        //user JPa to User Dto convert
        return UserMapper.mapToUserDto(user);
    }


    //Get list of All user
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    //Update User
    @Override
    public UserDto updateUser(UserDto user) {
        //object contains optional method so get in end
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return updatedUser;
        return UserMapper.mapToUserDto(updatedUser);
    }

    //deleteuser
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
