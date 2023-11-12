package com.example.StudentRegistration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentService {
    private final InMemoryStudentRepository repository;
    private final ApplicationEventPublisher publisher;

    @ShellMethod(key = "add")
    public void addStudent(String firstName, String lastName, int age) {
        Student student = repository.addStudent(firstName, lastName, age);
        publisher.publishEvent(new Event(this, student, OperationType.ADD));
    }

    @ShellMethod(key = "remove")
    public String removeStudent(int id) {
        Student student = repository.removeStudent(id);
        if (student != null) {
            publisher.publishEvent(new Event(this, student, OperationType.REMOVE));
            return null;
        }
        return "Студент с таким ID не найден";
    }

    @ShellMethod(key = "print")
    public String printStudentList() {
        return repository.getStudentList();
    }

    @ShellMethod(key = "reset")
    public String clearStudentList() {
        repository.clearStudentList();
        return "Список студентов очищен";
    }
}
