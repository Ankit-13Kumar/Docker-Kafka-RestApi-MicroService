package net.javaguides.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    //make parameterized constructor
    public  ResourceNotFoundException(String resourceName,String fieldName, Long fieldValue){
      super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldValue));
      this.resourceName=resourceName;
      this.fieldName=fieldName;
      this.fieldValue=fieldValue;
    }

}
