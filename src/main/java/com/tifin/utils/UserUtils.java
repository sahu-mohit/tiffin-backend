package com.tifin.utils;

import com.tifin.AllConstant.Constant;
import com.tifin.Utility.DataTypeUtility;
import com.tifin.dto.request.LoginRequestDTO;
import com.tifin.dto.request.RegistrationRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.User;
import com.tifin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    @Autowired
    private UserService userService;

    public NormalResponse saveUser(RegistrationRequestDTO registrationRequestDTO) {
        NormalResponse response = new NormalResponse();
        response.setMessage(Constant.TECHNICAL_ERROR.getValue());
        response.setCode(Constant.FAILED_CODE.getValue());
        response.setStatus(Constant.FAILED_STATUS.getValue());
        try {
            String firstName = registrationRequestDTO.getFirstName();
            String lastName = registrationRequestDTO.getLastName();
            String address = registrationRequestDTO.getAddress();
            String emailId = registrationRequestDTO.getEmailId();
            String password = registrationRequestDTO.getPassword();
            String number = registrationRequestDTO.getNumber();
            if (DataTypeUtility.isNull(firstName)) {
                response.setMessage("First name can not be empty");
                return response;
            }
            if (DataTypeUtility.isNull(lastName)) {
                response.setMessage("Last name can not be empty");
                return response;
            }
            if (DataTypeUtility.isNull(address)) {
                response.setMessage("Address can not be empty");
                return response;
            }
            if (DataTypeUtility.isNull(emailId)) {
                response.setMessage("Email Id can not be empty");
                return response;
            }
            if (DataTypeUtility.isNull(password)) {
                response.setMessage("Password can not be empty");
                return response;
            }
            if (DataTypeUtility.isNull(number)) {
                response.setMessage("Number can not be empty");
                return response;
            }
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setFullName(firstName + " " + lastName);
            user.setAddress(address);
            user.setEmailId(emailId);
            user.setPassword(DataTypeUtility.getEncryption(password));
            user.setNumber(registrationRequestDTO.getNumber());
            user = userService.saveUser(user);

            if (user == null) {
                response.setMessage(Constant.TECHNICAL_ERROR.getValue());
                response.setCode(Constant.FAILED_CODE.getValue());
                response.setStatus(Constant.FAILED_STATUS.getValue());
            } else {
                response.setMessage("Hello " + firstName + " " + lastName + "! Welcome to Mere Tiffin. We're delighted to have you as a part of our community. Explore, connect, and enjoy your experience.");
                response.setCode(Constant.SUCCESS_CODE.getValue());
                response.setStatus(Constant.SUCCESS_STATUS.getValue());
            }
        } catch (Exception e) {
            response.setMessage(Constant.TECHNICAL_ERROR.getValue());
            response.setCode(Constant.FAILED_CODE.getValue());
            response.setStatus(Constant.FAILED_CODE.getValue());
        }
        return response;
    }

    public NormalResponse userLogin(LoginRequestDTO loginRequestDTO) {
        NormalResponse response = new NormalResponse();
        response.setMessage(Constant.ERROR.getValue());
        response.setCode(Constant.FAILED_CODE.getValue());
        response.setStatus(Constant.FAILED_STATUS.getValue());
        String emailId = loginRequestDTO.getEmailId();
        String password = loginRequestDTO.getPassword();
        if (!DataTypeUtility.isNull(emailId)) {
            if (!DataTypeUtility.isNull(password)) {
                User user = userService.getUserByEmailId(emailId);
                if (!DataTypeUtility.isNull(user)) {
                    if (user.getPassword().equals(DataTypeUtility.getEncryption(password))) {
                        response.setMessage("Welcome " + user.getFullName());
                        response.setCode(Constant.SUCCESS_CODE.getValue());
                        response.setStatus(Constant.SUCCESS_STATUS.getValue());
                        return response;
                    } else {
                        response.setMessage("Invalid password");
                        return response;
                    }
                } else {
                    response.setMessage("Invalid Email ID");
                    return response;
                }
            } else {
                response.setMessage("Password can not be Empty");
                return response;
            }
        } else {
            response.setMessage("Email Id can not be Empty");
            return response;
        }
    }
}
