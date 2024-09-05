package net.javaguides.springboot.Repository;

import net.javaguides.springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//entity & primary key
//ctrl+click to check properties in details
public interface UserRepository extends JpaRepository<User,Long> {

}
