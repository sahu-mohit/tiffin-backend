package com.tifin.controller;

import com.tifin.dto.request.RegistrationRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tiffin")
public class TiffinRestController {

    @Autowired
    private UserUtils userUtils;
    @RequestMapping(value = "/registartion", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userRegistration(@RequestBody RegistrationRequestDTO registrationRequestDTO){
        return ResponseEntity.ok().body(userUtils.saveUser(registrationRequestDTO));
    }

}
