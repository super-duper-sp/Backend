package com.yash.yof.service.IService;



import com.yash.yof.Dto.UserRoleDto;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface IUserRoleService {

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    UserRoleDto createUserRole(UserRoleDto userRoleDto);

    UserRoleDto getUserRoleByRoleName(String roleName);


}
