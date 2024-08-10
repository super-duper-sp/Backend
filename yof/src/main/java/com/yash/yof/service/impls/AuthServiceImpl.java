package com.yash.yof.service.impls;

import com.yash.yof.constansts.AppConstants;
import com.yash.yof.constansts.RequestStatusTypes;
import com.yash.yof.constansts.UserAccountStatusTypes;

import com.yash.yof.entity.CustomUserDetails;
import com.yash.yof.entity.CustomUserDetailsServiceImpl;
import com.yash.yof.jwt.JwtHelper;
import com.yash.yof.jwt.JwtRequest;
import com.yash.yof.jwt.JwtResponse;
import com.yash.yof.service.IService.IAuthService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.yash.yof.exceptions.ApplicationException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private JwtHelper tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Override
    public JwtResponse login(JwtRequest authRequest) {
        String userName = authRequest.getEmail();
        String password = authRequest.getPassword();
        String token = null;

        this.authenticate(userName, password);

        CustomUserDetails userDetails = this
                .userDetailsService
                .loadUserByUsername(userName);

        Assert.notNull(userDetails);
        JwtResponse authResponse = new JwtResponse();

        if (StringUtils.equalsIgnoreCase(userDetails.getAccountStatus().toString(),
                UserAccountStatusTypes.APPROVED.toString())) {

            token = this
                    .tokenHelper
                    .generateToken(userDetails);

            authResponse.setToken(token);
            authResponse.setMessage("Successfully Logged In");
            authResponse.setStatus(RequestStatusTypes.SUCCESS.toString());

        } else if (StringUtils.equalsIgnoreCase(userDetails.getAccountStatus().toString(),
                UserAccountStatusTypes.DECLINED.toString())) {

            authResponse.setToken(null);
            authResponse.setStatus(RequestStatusTypes.FAILED.toString());
            authResponse.setMessage(AppConstants.DECLINED_USER_MESSAGE);
        } else {
            authResponse.setToken(null);
            authResponse.setStatus(RequestStatusTypes.FAILED.toString());
            authResponse.setMessage("Your request is in Pending state for Approval");
        }
        return authResponse;
    }

    private void authenticate(String userName,
                              String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException credentialsException) {
            throw new ApplicationException("Invalid username or password");
        }
    }
}
