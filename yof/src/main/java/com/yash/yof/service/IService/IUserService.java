package com.yash.yof.service.IService;

import com.yash.yof.Dto.UserDto;

import java.util.List;


public interface IUserService {

    String createNewUser(UserDto userDto);

    List<UserDto> getAllAssociates();

}
