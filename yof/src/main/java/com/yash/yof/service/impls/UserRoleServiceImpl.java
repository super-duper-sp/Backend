package com.yash.yof.service.impls;



import com.yash.yof.entity.UserRole;
import com.yash.yof.exceptions.ApplicationException;
import com.yash.yof.repository.UserRoleRepository;
import com.yash.yof.Dto.UserRoleDto;
import com.yash.yof.service.IService.IUserRoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
        UserRole userRole = null;

        if (ObjectUtils.isNotEmpty(userRoleDto)) {
            userRole = this
                    .modelMapper
                    .map(userRoleDto, UserRole.class);

            userRole = this
                    .roleRepository
                    .save(userRole);

            userRoleDto = this
                    .modelMapper
                    .map(userRole, UserRoleDto.class);
        } else {
            throw new ApplicationException("User Role Details are empty or null");
        }

        return userRoleDto;
    }


    @Override
    public UserRoleDto getUserRoleByRoleName(String roleName) {
        UserRoleDto userRoleDto = null;
        UserRole userRole = null;

        if (StringUtils.isNotEmpty(roleName)) {
            userRole = this
                    .roleRepository
                    .getUserRoleByRoleName(roleName);

            if (ObjectUtils.isNotEmpty(userRole)) {
                userRoleDto = this
                        .modelMapper
                        .map(userRole, UserRoleDto.class);
            } else {
                throw new ApplicationException("User Role not found with the provided role name");
            }
        } else {
            throw new ApplicationException("User Role name is empty or null");
        }

        return userRoleDto;
    }

}
