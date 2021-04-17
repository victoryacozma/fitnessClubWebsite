package com.projectPS.demo.service;

import com.projectPS.demo.dto.CredentialsDTO;
import com.projectPS.demo.dto.LoginSuccessDTO;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    public LoginSuccessDTO login(CredentialsDTO dto) throws com.ps.aplicatie.exceptions.ApiExceptionResponse;
}
