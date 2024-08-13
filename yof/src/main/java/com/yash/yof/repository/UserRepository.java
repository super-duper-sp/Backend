package com.yash.yof.repository;

import com.yash.yof.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select ur from User ur where ur.emailAdd=?1")
    User getUserByEmail(String email);

    @Query("select yur from User yur where yur.userRole.roleTypes=?1")
    List<User> findAllUsersByRole(String string);

    @Query("select yur from User yur where yur.empId=?1")
    User getUserByEmpId(Long empId);

    @Modifying
    @Query("delete from User yur where yur.empId=:empId")
    int deleteUserByEmpId(@Param("empId") Long empId);


}
