package com.yash.yof.controller;


import com.yash.yof.Dto.UserDto;
import com.yash.yof.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController{

    @Autowired
    private IUserService userService;

    @GetMapping("/profiles")
    public ResponseEntity<List<UserDto>> getAllAssociates(){
        List<UserDto> allAssociates = this.userService.getAllAssociates();
        return new ResponseEntity<>(allAssociates, HttpStatus.OK);
    }



}
