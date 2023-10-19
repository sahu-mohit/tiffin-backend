package com.tifin.utils;

import com.tifin.Utility.DataTypeUtility;
import com.tifin.dto.request.RegistrationRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.User;
import com.tifin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    @Autowired(required=true)
    private UserService userService;

    public NormalResponse saveUser(RegistrationRequestDTO registrationRequestDTO) {
        NormalResponse response = new NormalResponse();
        response.setMessage("Oops! Something went wrong on our end. Please try again later or contact support.");
        response.setCode(1);
        response.setStatus("failed");
        try{
            String firstName = registrationRequestDTO.getFirstName();
            String lastName = registrationRequestDTO.getLastName();
            String address = registrationRequestDTO.getAddress();
            String emailId = registrationRequestDTO.getEmailId();
            String password = registrationRequestDTO.getPassword();
            String number = registrationRequestDTO.getNumber();
            if(DataTypeUtility.isNull(firstName)){
                response.setMessage("First name can not be empty");
                return response;
            }
            if(DataTypeUtility.isNull(lastName)){
                response.setMessage("Last name can not be empty");
                return response;
            }
            if(DataTypeUtility.isNull(address)){
                response.setMessage("Address can not be empty");
                return response;
            }
            if(DataTypeUtility.isNull(emailId)){
                response.setMessage("Email Id can not be empty");
                return response;
            }
            if(DataTypeUtility.isNull(password)){
                response.setMessage("Password can not be empty");
                return response;
            }
            if(DataTypeUtility.isNull(number)){
                response.setMessage("Number can not be empty");
                return response;
            }
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setFullName(firstName+" "+lastName);
            user.setAddress(address);
            user.setEmailId(emailId);
            user.setPassword(DataTypeUtility.getEncryption(password));
            user.setNumber(registrationRequestDTO.getNumber());
            user = userService.saveUser(user);

            if(user == null){
                response.setMessage("Oops! Something went wrong on our end. Please try again later or contact support.");
                response.setCode(1);
                response.setStatus("failed");
            }else{
                response.setMessage("Hello "+firstName+" "+lastName+"! Welcome to Mere Tiffin. We're delighted to have you as a part of our community. Explore, connect, and enjoy your experience.");
                response.setCode(0);
                response.setStatus("success");
            }
        }catch (Exception e){
            response.setMessage("Technical Error Occurred");
            response.setCode(5);
            response.setStatus("failed");
        }
        return response;
    }
}
