package com.tifin.utils;

import com.tifin.dto.request.RegistrationRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.User;
import com.tifin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUtils {

    public NormalResponse saveUser(RegistrationRequestDTO registrationRequestDTO) {
        NormalResponse response = new NormalResponse();
        response.setMessage("Oops! Something went wrong on our end. Please try again later or contact support.");
        response.setCode(1);
        response.setStatus("failed");
        try{
            User user = new User();
            user.setFirstName(registrationRequestDTO.getFirstName());
            user.setLastName(registrationRequestDTO.getLastName());
            user.setFullName(registrationRequestDTO.getFullName());
            user.setAddress(registrationRequestDTO.getAddress());
            user.setEmailId(registrationRequestDTO.getEmailId());
            user.setPassword(registrationRequestDTO.getPassword());
            user.setDateOfBirth(registrationRequestDTO.getDateOfBirth());
            user.setNumber(registrationRequestDTO.getNumber());

        }catch (Exception e){

        }
        return response;
    }
}
