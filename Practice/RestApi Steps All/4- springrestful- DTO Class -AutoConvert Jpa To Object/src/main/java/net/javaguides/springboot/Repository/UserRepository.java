package net.javaguides.springboot.Repository;

import net.javaguides.springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//entity & primary key
//ctrl+click to check properties in details
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
