package com.example.dynatechhomework.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO {


    @XmlAttribute
    private String version;
    @XmlAttribute(namespace = "http://www.w3.org/2001/XMLSchema-instance")
    private String type;
    @XmlAttribute
    private String oid;
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String fullName;
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String name;
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String givenName;
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String familyName;
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String honorificPrefix;

    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private Activation activation;



}
