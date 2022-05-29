package com.project.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;


}
