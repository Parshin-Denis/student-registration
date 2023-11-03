package com.example.StudentRegistration;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @EventListener
    public void listen(Event event) {
        switch (event.getOperationType()){
            case ADD -> System.out.println("Студент \"" + event.getStudent() + "\" добавлен в список");
            case REMOVE -> System.out.println("Студент с ID " + event.getStudent().getId() + " удалён из списка");
        }
    }
}
