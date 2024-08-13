package com.yash.yof.Dto;

import lombok.Data;

@Data
public class UpdatePasswordDto {

        private String oldPassword;

        private String newPassword;

        private String confirmPassword;

}
