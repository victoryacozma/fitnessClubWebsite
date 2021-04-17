package com.projectPS.demo.service.impl;

import com.projectPS.demo.dto.CredentialsDTO;
import com.projectPS.demo.dto.LoginSuccessDTO;
import com.projectPS.demo.model.UserAuth;
import com.projectPS.demo.repository.UserRepository;
import com.projectPS.demo.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ps.aplicatie.exceptions.ApiExceptionResponse;

import java.util.Collections;
import java.util.Locale;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public LoginSuccessDTO login(CredentialsDTO dto) throws ApiExceptionResponse {
        UserAuth userAuth = userRepository.findByUsername(dto.getUsername());

        if(userAuth == null){
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad username"))
                    .message("User not found").status(HttpStatus.NOT_FOUND).build();
        }

        LoginSuccessDTO response;
        String role = userAuth.getClass().getSimpleName().toUpperCase();

        if(role.equals("CLIENT")){
            response = LoginSuccessDTO.builder().id(userAuth.getCNP()).role(role).build();
        }
        else{
            response = LoginSuccessDTO.builder().role(role).build();
        }

        if(dto.getPassword().equals(userAuth.getPassword())){
            return response;
        }

        throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad username"))
                .message("User not found").status(HttpStatus.NOT_FOUND).build();

    }
}
