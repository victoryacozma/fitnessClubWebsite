package com.projectPS.demo.controller;

import com.projectPS.demo.dto.CredentialsDTO;
import com.projectPS.demo.dto.NewUserDTO;
import com.projectPS.demo.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ps.aplicatie.exceptions.ApiExceptionResponse;

@RestController
@CrossOrigin

public class SignUpController {
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService){
        this.signUpService = signUpService;
    }

    @PostMapping("/newUser")
    public ResponseEntity signUp(@RequestBody NewUserDTO dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(signUpService.signUp(dto));
    }
}
