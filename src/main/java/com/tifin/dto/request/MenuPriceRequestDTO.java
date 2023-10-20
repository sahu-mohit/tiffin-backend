package com.tifin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuPriceRequestDTO {
    private Integer id;
    private String itemName;
    private Float price;
}
