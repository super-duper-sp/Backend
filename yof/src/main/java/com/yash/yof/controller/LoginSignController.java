package com.yash.yof.controller;

import com.yash.yof.Dto.UserDto;
import com.yash.yof.jwt.JwtRequest;
import com.yash.yof.jwt.JwtResponse;
import com.yash.yof.service.IService.IAuthService;
import com.yash.yof.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginSignController {


    @Autowired
    private IAuthService authService;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        JwtResponse authResponse = this
                .authService
                .login(authRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        String newUser = this
                .userService
                .createNewUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}