package com.example.dynatechhomework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {


    private String name;
    private String givenName;
    private String familyName;
    private String fullName;
    private String honorificPrefix;
    private String effectiveStatus;
}
