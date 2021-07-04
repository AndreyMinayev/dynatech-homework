package com.example.dynatechhomework.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.User;


import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name = "object", namespace = "http://prism.evolveum.com/xml/ns/public/types-3")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryObject {

    @XmlElement(name="object",namespace ="http://midpoint.evolveum.com/xml/ns/public/common/api-types-3")
    private UserDTO UserObject;

    @XmlAttribute(namespace = "http://www.w3.org/2001/XMLSchema-instance")
    private String type;






}
