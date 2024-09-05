package net.javaguides.springboot.Controller;

import net.javaguides.springboot.Model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//BaseUrl
@RequestMapping("/Common")
public class StudentController {

    //model + controller object using creates new objects and pass only reference value
    @GetMapping("/student")
    /*public Student getStudent() {
        Student student = new Student(
                1,
                "Ankit",
               "Kumar"
           );
        return student;
    }*/
    //Response Entity
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Ankit",
                "Kumar"
        );
        return new ResponseEntity<>(student,HttpStatus.OK);
    }



    //java method list of students
    @GetMapping("/students")
//    public List<Student> getStudents(){
    public ResponseEntity <List<Student>> getStudents(){

        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Raj","Kumar"));
        students.add(new Student(2,"ravi","pandey"));
        students.add(new Student(3,"sushil","sharma"));
        students.add(new Student(4,"uma","shankar"));
//            return students;
        return ResponseEntity.ok(students);
}


//spring boot rest api with path variable
    //{id} - url template variable
    //To bind id in url for dynamic we have to add pasthvariable and pass value
@GetMapping("/students/{id}/{first-name}/{last-name}")
/*
@GetMapping("/students/{id}")
public Student studentPathVariable(@PathVariable int id){
        return new Student(id,"ravi","pandey");
}*/

//you can pass anything id,firstname,lastname
//url- http://localhost:8080/students/2/sonam/kumari
//public Student studentPathVariable
public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentid,
                                   @PathVariable("first-name") String firstName,
                                   @PathVariable("last-name") String lastName){
//    return new Student(studentid,firstName,lastName);
    Student student=new  Student(studentid,firstName,lastName);
      return ResponseEntity.ok(student);
}

//Spring boot rest api with Request Param
    //url- http://localhost:8080/students/query?id=1
    /*@GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id){
    return new Student(id,"Raj","Nayak");
    }*/

    //url- http://localhost:8080/students/query?id=1&firstName=Raj&lastName=Nayak
@GetMapping("/students/query")
//public Student studentRequestVariable
public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName){
//    return new Student(id,firstName,lastName);
    Student student=new  Student(id,firstName,lastName);
    return ResponseEntity.ok(student);
}

//Handle post request method
    //http://localhost:8080/students/create
    //json {
//    "id":1,
//"firstName":"Ankit",
//"lastName":"Kumar"
//}
    //post mapping & requestBody(json to java object convert automatically)
    @PostMapping("/students/create")
    //backend side message received created
    //@ResponseStatus(HttpStatus.CREATED)
    //public Student createStudent
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
//    return student;
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //Put Mapping-updating existing resource
    //http://localhost:8080/students/1/update
    //json {
    //"firstName":"ravi",
    //"lastName":"Das"
    //}
@PutMapping("/students/{id}/update")
//public Student updateStudent
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
//        return student;
    return ResponseEntity.ok(student);
    }
    //Delete Mapping
    //http://localhost:8080/students/1/delete
@DeleteMapping("/students/{id}/delete")
//public String deleteStudent
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
    System.out.println(studentId);
//    return "Deleted Successfully";
    return ResponseEntity.ok("Deleted Successfully");
    }

}