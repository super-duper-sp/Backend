package com.yash.yof.jwt;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private  String email;
    private String password;
}