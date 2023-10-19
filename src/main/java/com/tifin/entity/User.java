package com.tifin.entity;

import com.tifin.AllConstant.Constant;
import com.tifin.Utility.DataTypeUtility;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USER")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @PrePersist
    public void autoSave(){
        createdDate = DataTypeUtility.getDateTimeofDateTypeByFormat(Constant.SQL_FORMAT_DATE_TIME.getValue(),null);
    }
//    @PreUpdate
//    private void preUpdate(){
//
//    }
}
