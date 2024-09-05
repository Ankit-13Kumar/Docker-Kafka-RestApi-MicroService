package net.javaguides.springboot.Mapper;

import net.javaguides.springboot.Dto.UserDto;
import net.javaguides.springboot.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    //for interface we need implementation cass
    //This will provide implementation class at compile time
    AutoUserMapper MAPPER= Mappers.getMapper(AutoUserMapper.class);

//At compilation time they will convert
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
