package com.yash.yof.service.IService;

import com.yash.yof.jwt.JwtRequest;
import com.yash.yof.jwt.JwtResponse;



public interface IAuthService {

    JwtResponse login(JwtRequest authRequest);
}
