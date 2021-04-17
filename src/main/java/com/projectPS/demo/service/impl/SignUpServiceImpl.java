package com.projectPS.demo.service.impl;
import com.fasterxml.jackson.core.JsonToken;
import com.projectPS.demo.dto.CredentialsDTO;
import com.projectPS.demo.dto.LoginSuccessDTO;
import com.projectPS.demo.dto.NewUserDTO;
import com.projectPS.demo.model.Client;
import com.projectPS.demo.model.UserAuth;
import com.projectPS.demo.repository.UserRepository;
import com.projectPS.demo.service.LoginService;
import com.projectPS.demo.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ps.aplicatie.exceptions.ApiExceptionResponse;

import java.util.Collections;
import java.util.Locale;

@Service
public class SignUpServiceImpl implements SignUpService {
    private final UserRepository userRepository;

    public SignUpServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserAuth signUp(NewUserDTO dto) throws ApiExceptionResponse {


        //UserAuth userAuth = userRepository.findByUsername(dto.getUsername());
        UserAuth newUser = new Client(null, dto.getUsername(), dto.getPassword(), dto.getFirstName()+ " " + dto.getLastName(), dto.getAddress());

        Client oldClient = (Client) userRepository.findByUsername(newUser.getUsername());
        if(oldClient != null){
            System.out.println("Acest username e deja folosit");
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad username"))
                    .message("User not found").status(HttpStatus.NOT_FOUND).build();

        }

        userRepository.save(newUser);
        return newUser;

    }
}
