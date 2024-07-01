package com.tifin.controller;

import com.tifin.dto.request.*;
import com.tifin.dto.response.MenuPriceResponseDTO;
import com.tifin.dto.response.MenuResponseDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.utils.MenuPriceUtils;
import com.tifin.utils.MenuUtils;
import com.tifin.utils.UserOrderUtils;
import com.tifin.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tiffin")
@CrossOrigin(origins = "http://localhost:3000")
public class TiffinRestController {

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserOrderUtils userOrderUtils;

    @Autowired
    private MenuPriceUtils menuPriceUtils;

    @Autowired
    private MenuUtils menuUtils;

    @RequestMapping(value = "/sign-up", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userRegistration(@RequestBody Payload payload){
        return ResponseEntity.ok().body(userUtils.saveUser(payload));
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userLogin(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok().body(userUtils.userLogin(loginRequestDTO));
    }

    @RequestMapping(value = "/add-order", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> userOrder(@RequestBody UserOrderRequestDTO userOrderRequestDTO){
        return ResponseEntity.ok().body(userOrderUtils.userOrder(userOrderRequestDTO));
    }

    @RequestMapping(value = "/add-menu-price", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> menuPrice(@RequestBody MenuPriceRequestDTO menuPriceRequestDTO){
        return ResponseEntity.ok().body(menuPriceUtils.setItemPrice(menuPriceRequestDTO));
    }

    @RequestMapping(value = "/get-menu-price", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<MenuPriceResponseDTO> getMenuPrice(){
        return ResponseEntity.ok().body(menuPriceUtils.getMenuPrice());
    }

    @RequestMapping(value = "/add-menu", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<NormalResponse> addMenu(@RequestBody MenuRequestDTO menuRequestDTO){
        return ResponseEntity.ok().body(menuUtils.addMenu(menuRequestDTO));
    }

    @RequestMapping(value = "/get-menu", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<MenuResponseDTO> getMenu(){
        return ResponseEntity.ok().body(menuUtils.getMenu());
    }

}
