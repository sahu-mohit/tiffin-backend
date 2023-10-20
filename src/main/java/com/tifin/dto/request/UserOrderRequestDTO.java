package com.tifin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderRequestDTO {
    private Integer id;
    private Integer userId;
    private Integer roti;
    private Integer rice;
    private Integer paratha;
    private Integer curriedVeg;
    private Integer dryVeg;
    private Integer rayeta;
    private Integer sweet;
    private Integer achar;
    private Integer saledChatni;
    private Float amount;
    private String tiffinType;
    private Boolean isVeg;
    private String startDateTime;
    private String endDateTime;
    private String day;
    private Integer quantity;
}
