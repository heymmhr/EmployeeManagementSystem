package com.ems.ems.controller;

import com.ems.ems.dto.ResponseDto;
import com.ems.ems.utils.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("read-data-from-property")
public class PropertyController extends BaseController{

    @Value("${secret_key1}") //taking the value from application property
    private String secretKey;

    @Autowired
    private Environment environment;

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/way1")
    public ResponseEntity<ResponseDto> wayOne(){

        return new ResponseEntity<>(successResponse("success",secretKey), HttpStatus.OK);
    }

    @GetMapping("/way2")
    public ResponseEntity<ResponseDto> wayTwo(){

        return new ResponseEntity<>(successResponse("success",environment.getProperty("secret_key2")), HttpStatus.OK);
    }

    @GetMapping("/way3")
    public ResponseEntity<ResponseDto> wayThree(){

        Map<String, String > dataMap = new HashMap<>();
        dataMap.put("username", appProperties.getUsername());
        dataMap.put("password", appProperties.getPassword());


        return new ResponseEntity<>(successResponse("success",dataMap), HttpStatus.OK);
    }
}
