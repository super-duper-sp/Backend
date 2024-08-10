package com.yash.yof.repository;

import com.yash.yof.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select ur from User ur where ur.emailAdd=?1")
    User getUserByEmail(String email);

    @Query("select yur from User yur where yur.userRole.roleTypes=?1")
    List<User> findAllUsersByRole(String string);
}
