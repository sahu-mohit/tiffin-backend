package com.tifin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequestDTO {
    private Integer id;
    private String day;
    private String dryVeg;
    private String curriedVeg;
    private String roti;
    private String paratha;
    private String rice;
    private String vegType;
}
