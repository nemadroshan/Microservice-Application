package com.example.demo;

import com.example.demo.generated.CurddemoApplication;
import com.example.demo.generated.CurddemoApplicationBuilder;
import com.example.demo.generated.curddemo.curddemo.person.Person;
import com.example.demo.generated.curddemo.curddemo.person.PersonManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpreedmentConfig {

    @Bean
    CurddemoApplication getApplication(){
        return new CurddemoApplicationBuilder().withUsername("root").withPassword("root").build();
    }

    @Bean
    PersonManager getpersonManager(CurddemoApplication app){
        return app.getOrThrow(PersonManager.class);
    }

}
