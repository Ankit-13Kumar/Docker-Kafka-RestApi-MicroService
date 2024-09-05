package net.javaguides.springboot.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Global Exception work

//extends for validation only and then overide
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
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
                                                                         WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
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
                                                              WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internal Server Error"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Override method

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
            //when we used to store miltiple error  used map
            Map<String, String> errors = new HashMap<>();
            List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

            errorList.forEach((error)->{
            String fieldName=((FieldError) error).getField();
            String message =error.getDefaultMessage();
            errors.put(fieldName,message);
            });
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }
    }
