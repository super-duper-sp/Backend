package com.yash.yof.controller;


import com.yash.yof.Dto.UpdatePasswordDto;
import com.yash.yof.Dto.UserDto;
import com.yash.yof.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController{

    @Autowired
    private IUserService userService;

    //get all Associates
    @GetMapping("/profiles")
    public ResponseEntity<List<UserDto>> getAllAssociates(){
        List<UserDto> allAssociates = this.userService.getAllAssociates();
        return new ResponseEntity<>(allAssociates, HttpStatus.OK);
    }

    //Get assiciate by Employee Id
    @GetMapping("/profiles/{empId}")
    public ResponseEntity<UserDto> getAssociateById(@PathVariable Long empId){
        System.out.println(empId);
        UserDto associate = this.userService.getAssociateById(empId);
        return new ResponseEntity<>(associate, HttpStatus.OK);
    }

    //Delete Associate by Employee Id
    @DeleteMapping("/profiles/{empId}")
    public ResponseEntity<UserDto> deleteAssociateById(@PathVariable Long empId){
        System.out.println(empId);
        UserDto associate = this.userService.deleteAssociateById(empId);
        return new ResponseEntity<>(associate, HttpStatus.OK);
    }

    //Update Associate by Employee Id
    @PutMapping("/profiles/{empId}/reset_password")
    public ResponseEntity<String> updatePassword(@PathVariable Long empId, @RequestBody UpdatePasswordDto updatePasswordDto){
        String updatedPassword = userService.updatePassword(empId, updatePasswordDto);
        return new ResponseEntity<>(updatedPassword, HttpStatus.OK);
    }

}
