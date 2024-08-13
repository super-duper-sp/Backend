package com.yash.yof.service.IService;

import com.yash.yof.Dto.UpdatePasswordDto;
import com.yash.yof.Dto.UserDto;

import java.util.List;


public interface IUserService {

    String createNewUser(UserDto userDto);

    List<UserDto> getAllAssociates();

    UserDto getAssociateById(long id);

    UserDto deleteAssociateById(Long empId);

    String updatePassword(Long empId, UpdatePasswordDto updatePasswordDto);
}
