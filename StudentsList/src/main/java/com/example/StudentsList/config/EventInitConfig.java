package com.example.StudentsList.config;

import com.example.StudentsList.db.Storage;
import com.example.StudentsList.service.StudentInit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("app.init.enabled")
public class EventInitConfig {

    @Bean
    public StudentInit studentInit(Storage storage) {
        return new StudentInit(storage);
    }


}
