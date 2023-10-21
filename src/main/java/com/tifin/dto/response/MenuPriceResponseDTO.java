package com.tifin.dto.response;

import com.tifin.entity.MenuPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuPriceResponseDTO {
    private String message;
    private String code;
    private String Status;
    List<MenuPrice> menuList;
}
