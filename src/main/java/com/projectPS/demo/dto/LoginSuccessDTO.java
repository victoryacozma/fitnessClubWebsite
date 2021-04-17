package com.projectPS.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginSuccessDTO {
    private String role;
    private Long id;
}
