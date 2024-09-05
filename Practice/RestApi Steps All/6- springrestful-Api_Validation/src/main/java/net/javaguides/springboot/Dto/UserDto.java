package net.javaguides.springboot.Dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    //FirstName should not be null or empty

    @NotEmpty(message = "FirstName should not be null or empty")
    private String firstName;
    @NotEmpty(message = "LastName should not be null or empty")
    private  String lastName;
    //FirstName should not be null or empty or email should be valid

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be null or empty")
    private String email;
}
