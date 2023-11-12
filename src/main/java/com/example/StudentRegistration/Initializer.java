package com.example.StudentRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("app.initializer.enabled")
public class Initializer {
    @Autowired
    private InMemoryStudentRepository repository;

    @Value("${app.initializer.filename}")
    private String fileName;

    @EventListener(ApplicationStartedEvent.class)
    public void init(){
        repository.init(fileName);
    }
}
