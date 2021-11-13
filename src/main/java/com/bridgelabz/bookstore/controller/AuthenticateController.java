package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.config.JwtUtils;
import com.bridgelabz.bookstore.dto.JWTRequest;
import com.bridgelabz.bookstore.dto.JWTResponse;
import com.bridgelabz.bookstore.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private JwtUtils jwtUtils;



//    private void authenticate(String userName , String password){
//        try{
//            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
//
//        }catch (Exception e ){
//            e.printStackTrace();
//        }
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest){

//        try {
//            authenticate(jwtRequest.getUserName() , jwtRequest.getPassword());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        UserDetails userDetails = userSecurityService.loadUserByUsername(jwtRequest.getUserName());
        String token = jwtUtils.generateToken(userDetails);
//        return ResponseEntity.ok(new JWTResponse(token));
        return new ResponseEntity<>(token , HttpStatus.OK);

    }

}
