package com.example.dynatechhomework.dto;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Activation {
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String effectiveStatus;
    @XmlElement(namespace = "http://midpoint.evolveum.com/xml/ns/public/common/common-3")
    private String enableTimestamp;

    public String getEffectiveStatus() {
        return effectiveStatus;
    }

    public void setEffectiveStatus(String effectiveStatus) {
        this.effectiveStatus = effectiveStatus;
    }

    public String  getEnableTimestamp() {
        return enableTimestamp;
    }

    public void setEnableTimestamp(String enableTimestamp) {
          this.enableTimestamp = enableTimestamp;
    }
}
