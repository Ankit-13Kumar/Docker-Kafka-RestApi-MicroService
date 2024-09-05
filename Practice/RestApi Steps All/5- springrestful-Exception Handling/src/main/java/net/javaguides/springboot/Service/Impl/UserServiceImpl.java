package net.javaguides.springboot.Service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.Dto.UserDto;
import net.javaguides.springboot.Exception.EmailAlreadyExistException;
import net.javaguides.springboot.Exception.ResourceNotFoundException;
import net.javaguides.springboot.Mapper.AutoUserMapper;
import net.javaguides.springboot.Model.User;
import net.javaguides.springboot.Repository.UserRepository;
import net.javaguides.springboot.Service.UserService;
import org.modelmapper.ModelMapper;
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

    //no need of constructor already use annotation no need autowired when contructor is there
    //single parameterized constructor so no need anotation
    private ModelMapper modelMapper;

    //add user
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert UserDto into Jpa Entity
        //make constructor
        /*User user= UserMapper.mapToUser(userDto);*/
       // User user= modelMapper.map(userDto,User.class);
        //User DTO to User Jpa

        //To check user email exist or not
        Optional<User> optionalUser=userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){throw new EmailAlreadyExistException("Email Already Exist");
        }

        User user= AutoUserMapper.MAPPER.mapToUser(userDto);

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

/*
        UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);
*/
//        UserDto savedUserDto=modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto=AutoUserMapper.MAPPER.mapToUserDto(savedUser);

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
//        Optional<User> optionalUser = userRepository.findById(userId);
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId)
        );
       // User user=optionalUser.get();
        //user JPa to User Dto convert
/*
        return UserMapper.mapToUserDto(user);
*/
//        return modelMapper.map(user,UserDto.class);
//        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
        return AutoUserMapper.MAPPER.mapToUserDto(user);

    }


    //Get list of All user
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= userRepository.findAll();
      /*  return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());*/
        //It takes functions so use lambda function
        /*return users.stream().map((user) ->modelMapper.map(user,UserDto.class) )
                .collect(Collectors.toList());*/
        return users.stream().map((user) ->AutoUserMapper.MAPPER.mapToUserDto(user) )
                .collect(Collectors.toList());
    }

    //Update User
    @Override
    public UserDto updateUser(UserDto user) {
        //object contains optional method so get in end
//        User existingUser = userRepository.findById(user.getId()).get();
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",user.getId())
        );

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return updatedUser;
       // return UserMapper.mapToUserDto(updatedUser);
//        return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

    }

    //deleteuser
    //not using mapper so no need to change
    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",userId)
        );
        userRepository.deleteById(userId);
    }
}
