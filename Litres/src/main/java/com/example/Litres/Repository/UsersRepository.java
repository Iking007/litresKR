package com.example.Litres.Repository;


import com.example.Litres.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * @author Pavel
 */
public interface UsersRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    User findByUsername(String username);
}
