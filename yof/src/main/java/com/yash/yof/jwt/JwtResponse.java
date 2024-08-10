package com.yash.yof.jwt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JwtResponse {

    private String token;

    private String status;

    private String message;
}