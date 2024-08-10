package com.yash.yof.controller;


import com.yash.yof.Dto.UserDto;
import com.yash.yof.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/users")
public class HomeController {

    @Autowired
    private IUserService userService;

     @GetMapping("/get")
        public ResponseEntity<List<UserDto>> getAllAssociates() {
            List<UserDto> allStudents = this.userService.getAllAssociates();
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        }
}
