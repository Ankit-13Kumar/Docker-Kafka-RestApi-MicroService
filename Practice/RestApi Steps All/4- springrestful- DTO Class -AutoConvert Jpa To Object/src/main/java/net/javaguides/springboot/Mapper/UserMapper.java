package net.javaguides.springboot.Mapper;

import net.javaguides.springboot.Dto.UserDto;
import net.javaguides.springboot.Model.User;

public class UserMapper {
    //For reusable code
    //creating static methods

    //convert User Jpa Entity into UserDto
    public static UserDto mapToUserDto(User user) {
        //constructor
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }


        //convert UserDto into User Jpa Entity
        public static User mapToUser(UserDto userDto){
            User user=new User(
                    userDto.getId(),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    userDto.getEmail()

            );
            return user;
        }

    }
