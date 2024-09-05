package net.javaguides.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//After that go to IMPL class
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException{
private String message;
public EmailAlreadyExistException(String message){
    super(message);
}

}
