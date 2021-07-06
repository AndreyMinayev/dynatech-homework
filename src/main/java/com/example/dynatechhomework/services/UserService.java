package com.example.dynatechhomework.services;


import com.example.dynatechhomework.dto.QueryObject;

import com.example.dynatechhomework.dto.UserDTO;
import com.example.dynatechhomework.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;


@Service
@Slf4j
public class UserService {



    public UserDTO getUserByName(String userName) {

        // Preparing request
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWRtaW5pc3RyYXRvcjo1ZWNyM3Q=");
        headers.add("Accept", "application/xml");

        headers.setContentType(MediaType.APPLICATION_XML);

        String body ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<q:query xmlns:q=\"http://prism.evolveum.com/xml/ns/public/query-3\"\n" +
                "xmlns=\"http://prism.evolveum.com/xml/ns/public/query-3\"\n" +
                "xmlns:c='http://midpoint.evolveum.com/xml/ns/public/common/common-3'>\n" +
                "    <q:filter>\n" +
                "        <q:equal>\n" +
                "            <q:path>c:name</q:path>\n" +
                "            <q:value>"+userName+"</q:value>\n" +
                "        </q:equal>\n" +
                "    </q:filter>\n" +
                "</q:query>";
        HttpEntity<String> request = new HttpEntity<String>(body, headers);


        //  Making request
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("administrator", "5ecr3t"));
       ResponseEntity<String> response =
                restTemplate.exchange(
                        "http://127.0.0.1:8088/midpoint/ws/rest/users/search",HttpMethod.POST, request,
                       String.class);




       //  Unmarshaling the result to UserDTO
        try{
            JAXBContext context = JAXBContext.newInstance(QueryObject.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            QueryObject unmarshaled = (QueryObject)unmarshaller.unmarshal(new StringReader(response.getBody()));

            return unmarshaled.getUserObject();
        }catch (Exception e){
            log.error("There is no such user", e);
            throw new UserNotFoundException("There is no Such user");
        }






        // Getting XML data using DOM
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
//
//        Document dom = builder.parse(new InputSource(new StringReader(response.getBody())));
//        dom.normalizeDocument();
//        Element root = dom.getDocumentElement();
//        System.out.println("Name: " + root.getElementsByTagName("name").item(0).getTextContent());
//        System.out.println("FamilyName: " + root.getElementsByTagName("familyName").item(0).getTextContent());
        ////////////////////////////////////////////






    }

}
