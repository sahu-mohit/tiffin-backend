package com.tifin.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_ORDER")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "ROTI")
    private Integer roti;

    @Column(name = "rice")
    private Integer rice;

    @Column(name = "PARATHA")
    private Integer paratha;

    @Column(name = "CURRIED_VEG")
    private Integer curriedVeg;

    @Column(name = "DRY_VEG")
    private Integer dryVeg;

    @Column(name = "RAYETA")
    private Integer rayeta;

    @Column(name = "SWEET")
    private Integer sweet;

    @Column(name = "ACHAR")
    private Integer achar;

    @Column(name = "SALED_CHATNI")
    private Integer saledChatni;

    @Column(name = "AMMOUNT")
    private Float ammount;

    @Column(name = "TIFFIN_TYPE")
    private String tiffinType;

    @Column(name = "IS_VEG")
    private Boolean isVeg;

    @Column(name = "START_DATE_TIME")
    private String startDateTime;

    @Column(name = "END_DATE_TIME")
    private String endDateTime;

    @Column(name = "DAY")
    private String day;

    @Column(name = "QUANTITY")
    private Integer quantity;


}
