package com.example.StudentRegistration;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentService {
    private final InMemoryStudentRepository repository;

    @ShellMethod(key = "add")
    public void addStudent(String firstName, String lastName, int age) {
        repository.addStudent(firstName, lastName, age);
    }

    @ShellMethod(key = "remove")
    public String removeStudent(int id) {
        return repository.removeStudent(id);
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
