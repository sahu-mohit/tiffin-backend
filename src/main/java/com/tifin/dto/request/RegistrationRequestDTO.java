package com.tifin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDTO {


    private String firstName;
    private String lastName;
    private String fullName;
    private String number;
    private String address;
    private String emailId;
    private String password;
    private String createDate;

}
