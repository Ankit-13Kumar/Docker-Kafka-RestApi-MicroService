package net.javaguides.springboot.Dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    //create same model in dto class
    //do not add sensitive info
    private Long id;
    private String firstName;
    private  String lastName;
    private String email;
}
