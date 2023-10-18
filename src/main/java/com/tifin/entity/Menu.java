package com.tifin.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MENU")
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DAY")
    private String day;

    @Column(name = "DRY_VEG")
    private String dryVeg;

    @Column(name = "CURRIED_VEG")
    private String curriedVeg;

    @Column(name = "ROTI")
    private String roti;

    @Column(name = "PARATHA")
    private String paratha;

    @Column(name = "RICE")
    private String rice;

    @Column(name = "VEG_TYPE")
    private String vegType;

}
