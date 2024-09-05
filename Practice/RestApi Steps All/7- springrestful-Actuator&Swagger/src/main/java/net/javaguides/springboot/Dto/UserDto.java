package net.javaguides.springboot.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//for swagger schema
@Schema(
        description = "UserDto Model Information "
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    //create same model in dto class
    //do not add sensitive info
    private Long id;
    //FirstName should not be null or empty

    //Swagger only
    @Schema(
            description = "User FirsName"
    )
    @NotEmpty(message = "FirstName should not be null or empty")
    private String firstName;

    //Swagger only
    @Schema(
            description = "User LastName"
    )
    @NotEmpty(message = "LastName should not be null or empty")
    private  String lastName;
    //FirstName should not be null or empty or email should be valid
    //Swagger only
    @Schema(
            description = "User EmailAddress"
    )
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be null or empty")
    private String email;
}
