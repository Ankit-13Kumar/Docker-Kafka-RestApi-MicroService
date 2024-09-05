package net.javaguides.springboot.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//Null
@NoArgsConstructor
//Parameterized constructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)

    private String firstName;
    @Column(name = "last_name", nullable = false)

    private String lastName;
    @Column(name = "email", nullable = false,unique = true)

    private String email;


}
