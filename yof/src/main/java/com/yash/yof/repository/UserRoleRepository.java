package com.yash.yof.repository;

import com.yash.yof.entity.UserRole;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("select ur from UserRole ur where ur.roleId=?1")
    UserRole getUserRoleByRoleId(Long roleId);

    @Query("select ur from UserRole ur where ur.roleTypes=?1")
    UserRole getUserRoleByRoleName(String roleType);

    @Query("select ur from UserRole ur")
    Set<UserRole> getAllUserRoles();
}
