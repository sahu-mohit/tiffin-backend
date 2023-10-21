package com.tifin.service;

import com.tifin.dto.request.MenuPriceRequestDTO;
import com.tifin.dto.response.NormalResponse;
import com.tifin.entity.MenuPrice;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuPriceService {
    MenuPrice savePrice(MenuPrice menuPrice);

    List<MenuPrice> getMenuPriceList();
}
