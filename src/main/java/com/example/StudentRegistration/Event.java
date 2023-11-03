package com.example.StudentRegistration;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class Event extends ApplicationEvent {

    private final Student student;
    private final OperationType operationType;

    public Event(Object source, Student student, OperationType operationType) {
        super(source);
        this.student = student;
        this.operationType = operationType;
    }
}
