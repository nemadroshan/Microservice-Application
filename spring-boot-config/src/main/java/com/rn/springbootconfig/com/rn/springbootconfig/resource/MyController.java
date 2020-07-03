package com.rn.springbootconfig.com.rn.springbootconfig.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    private DemoConfig demoConfig;

    @Value("${msg.val}")
    private String msg;

    @Value("${msg,name: spring app}")
    private  String msg2;

    @Value("${msg.list}")
    private List<String> myList;

    @Value("#{${msg.map}}")
    private Map<String,String> myMap;

    @Autowired
    private Environment environment;

    @GetMapping("/greet")
    public String greeting() {
        return " "+msg+"------"+msg2+"---------"+myList+"------"+myMap+"-----------"+demoConfig;
    }

    @GetMapping("/env")
    public String getEnv(){
        return " "+ Arrays.toString(environment.getActiveProfiles());
    }
}
