package com.projectPS.demo.service;

import com.projectPS.demo.dto.CredentialsDTO;
import com.projectPS.demo.dto.LoginSuccessDTO;
import com.projectPS.demo.dto.NewUserDTO;
import com.projectPS.demo.model.UserAuth;

public interface SignUpService {
    public UserAuth signUp(NewUserDTO dto) throws com.ps.aplicatie.exceptions.ApiExceptionResponse;
}
