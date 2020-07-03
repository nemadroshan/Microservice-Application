package com.rn.springbootconfig.com.rn.springbootconfig.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Value("${msg.val}")
    private String msg;

    @Value("${msg,name: spring app}")
    private  String msg2;

    @Value("${msg.list}")
    private List<String> myList;

    @Value("#{${msg.map}}")
    private Map<String,String> myMap;

    @GetMapping("/greet")
    public String greeting() {
        return " "+msg+"------"+msg2+"---------"+myList+"------"+myMap;
    }
}
