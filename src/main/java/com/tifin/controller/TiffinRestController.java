package com.tifin.controller;

import com.tifin.dto.request.LoginRequestDTO;
import com.tifin.dto.request.MenuPriceRequestDTO;
import com.tifin.dto.request.RegistrationRequestDTO;
import com.tifin.dto.request.UserOrderRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.utils.MenuPriceUtils;
import com.tifin.utils.UserOrderUtils;
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

    @Autowired
    private UserOrderUtils userOrderUtils;

    @Autowired
    private MenuPriceUtils MenuPriceUtils;

    @RequestMapping(value = "/registration", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userRegistration(@RequestBody RegistrationRequestDTO registrationRequestDTO){
        return ResponseEntity.ok().body(userUtils.saveUser(registrationRequestDTO));
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userLogin(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok().body(userUtils.userLogin(loginRequestDTO));
    }

    @RequestMapping(value = "/order", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userOrder(@RequestBody UserOrderRequestDTO userOrderRequestDTO){
        return ResponseEntity.ok().body(userOrderUtils.userOrder(userOrderRequestDTO));
    }

    @RequestMapping(value = "/menu-price", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> menuPrice(@RequestBody MenuPriceRequestDTO menuPriceRequestDTO){
        return ResponseEntity.ok().body(MenuPriceUtils.setItemPrice(menuPriceRequestDTO));
    }

}
