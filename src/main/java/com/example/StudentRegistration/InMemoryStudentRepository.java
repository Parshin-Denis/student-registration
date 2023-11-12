package com.example.StudentRegistration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InMemoryStudentRepository {
    private int newStudentId = 1;
    private final List<Student> studentList;
    private final ApplicationEventPublisher publisher;

    public void addStudent(String firstName, String lastName, int age) {
        Student student = new Student(newStudentId++, firstName, lastName, age);
        studentList.add(student);
        publisher.publishEvent(new Event(this, student, OperationType.ADD));
    }

    public String removeStudent(int id) {
        Student student = studentList.stream()
                                     .filter(s -> s.getId() == id)
                                     .findFirst()
                                     .orElse(null);
        if (student != null) {
            studentList.remove(student);
            publisher.publishEvent(new Event(this, student, OperationType.REMOVE));
            return null;
        }
        return "Студент с таким ID не найден";
    }

    public String getStudentList() {
        if (studentList.size() == 0) {
            return "Список студентов пуст";
        }
        return String.join(System.lineSeparator(), studentList.stream()
                                                              .map(Student::toString)
                                                              .toList());
    }

    public void clearStudentList() {
        studentList.clear();
    }

    public void init(String fileName){
        try {
            List<String> defaultsStudents = Files.readAllLines(Path.of(fileName));
            defaultsStudents.forEach(c -> {
                String[] contactData = c.split(";");
                if (contactData.length != 3 || !contactData[2].matches("\\d+")){
                    return;
                }
                Student student = new Student(newStudentId++, contactData[0].trim(), contactData[1].trim()
                        , Integer.parseInt(contactData[2]));
                studentList.add(student);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
