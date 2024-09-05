package net.javaguides.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

//Global Exception work
@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_Not_Found"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    //Another one
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Email_Already_Exist"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    //Global Exception for all types they will handle
    //without body pass POST mapping getting internal server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                                         WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internal Server Error"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
